package com.zxr.medicalaid.mvp.ui.activities;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LayoutAnimationController;
import android.view.animation.LinearInterpolator;

import com.github.lazylibrary.util.ToastUtils;
import com.jude.easyrecyclerview.EasyRecyclerView;
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;
import com.zxr.medicalaid.R;
import com.zxr.medicalaid.dagger.scope.ContextLife;
import com.zxr.medicalaid.mvp.entity.Person;
import com.zxr.medicalaid.mvp.entity.moudle.PatientInfo;
import com.zxr.medicalaid.mvp.presenter.presenterImpl.CanclePresenterImpl;
import com.zxr.medicalaid.mvp.presenter.presenterImpl.PatientListPresenterImpl;
import com.zxr.medicalaid.mvp.ui.activities.base.BaseActivity;
import com.zxr.medicalaid.mvp.ui.adapters.PatientListAdapter;
import com.zxr.medicalaid.mvp.view.CancleView;
import com.zxr.medicalaid.mvp.view.PatientListView;
import com.zxr.medicalaid.net.ResponseCons;
import com.zxr.medicalaid.utils.db.IdUtil;
import com.zxr.medicalaid.utils.system.ToActivityUtil;

import java.security.Key;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import javax.inject.Inject;

import butterknife.InjectView;

/**
 * 区分药师和病人
 */
public class CurrentPatientsActivity extends BaseActivity implements SwipeRefreshLayout.OnRefreshListener, RecyclerArrayAdapter.OnLoadMoreListener, PatientListView,CancleView {

    @Inject
    PatientListPresenterImpl presenter;
    @Inject
    CanclePresenterImpl canclePresenter;
    @InjectView(R.id.mToolbar)
    Toolbar mToolbar;
    @InjectView(R.id.person_list)
    EasyRecyclerView mRecycler;
    public static final String GET_FROM = "get_from";
    private int type = 0;
    public static final int DOCTOR = 1;
    public static final int PATIENT = 2;
    MessageDigest md;
    /**
     * adapter
     */
    private PatientListAdapter adapter;
    /**
     *
     */
    String doctorId;
    /**
     * context
     */

    @Inject
    @ContextLife("Activity")
    Context mContext;

    //===============================================测试
    private List<Person> lists = new ArrayList<>();
    private List<String> listId = new ArrayList<>();
    @Override
    public void initInjector() {
        mActivityComponent.inject(this);
        presenter.injectView(this);
        canclePresenter.injectView(this);
    }

    @Override
    public void initViews() {
        //toolbar
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        mToolbar.setTitle(R.string.current_patients_num);
        mToolbar.setTitleTextColor(getResources().getColor(R.color.white));
         doctorId = getIntent().getStringExtra("uId");
        if (doctorId != null) {
            Log.e(TAG, doctorId);
            type = PATIENT;
            presenter.getPatient(doctorId, 1);
        } else {
            presenter.getPatient(IdUtil.getIdString(), 1);
        }

        //recyclerview
        //adapter设置
        adapter = new PatientListAdapter(this);
        //===============================================测试
//        for (int i = 0; i < 5; i++) {
//            Person person = new Person("张兴锐", "13:19", "120.77.87.78:8080/arti-sports/image//user15.png");
//            lists.add(person);
//        }
//        adapter.addAll(lists);
        //设置item的点击监听
        adapter.setOnItemClickListener(
                pos -> {
                    if (type == PATIENT) {
//                        Toast.makeText(this, "病人，可选择退出", Toast.LENGTH_SHORT).show();
                        return;
                    } else {
//                        Toast.makeText(this, "医生，点击进行开药", Toast.LENGTH_SHORT).show();
                        ToActivityUtil.toNextActivity(mContext, PrescribeActivity.class);
                    }
                }
        );
        if (type == DOCTOR) {
            adapter.setOnItemLongClickListener(
                    position -> {
                        new AlertDialog.Builder(this)
                                .setTitle("提示")
                                .setCancelable(true)
                                .setMessage("确定要将他出当前队列?")
                                .setPositiveButton("确定",
                                        (dialog, what) -> {
                                            adapter.remove(position);
                                            canclePresenter.cancleLink(IdUtil.getIdString(),listId.get(position));
                                            dialog.dismiss();
                                        }
                                )
                                .setNegativeButton("取消",
                                        (dialog, what) ->
                                                dialog.dismiss()
                                )
                                .show();
                        return false;
                    }
            );
        }

        mRecycler.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        mRecycler.setLayoutManager(new LinearLayoutManager(this));
        mRecycler.setAdapter(adapter);
        mRecycler.setRefreshListener(this);
        mRecycler.setRefreshing(true, true);//打开自动刷新并且立即毁掉
        mRecycler.setRefreshingColorResources(R.color.red_600, R.color.yellow_600, R.color.blue_600, R.color.green_600);
        //设置动画
        AnimationSet set = new AnimationSet(true);
        set.addAnimation(AnimationUtils.loadAnimation(this, R.anim.anim_patient_list_item));
        set.setInterpolator(new DecelerateInterpolator());
        LayoutAnimationController lc = new LayoutAnimationController(set);
        lc.setInterpolator(new LinearInterpolator());
        lc.setOrder(LayoutAnimationController.ORDER_NORMAL);
        lc.setDelay(0.4f);
        mRecycler.getRecyclerView().setLayoutAnimation(lc);

    }

    @Override
    public boolean onCreatePanelMenu(int featureId, Menu menu) {
        if (type == PATIENT){
            getMenuInflater().inflate(R.menu.patient_quit_menu,menu);
        }
        return super.onCreatePanelMenu(featureId, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // TODO Auto-generated method stub
        //add top-left icon click event deal
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                break;
            case R.id.quit:
                if (doctorId == null){
                    ToastUtils.showToast(this,"出现异常，请重试");
                    return super.onOptionsItemSelected(item);
                }
                new AlertDialog.Builder(this)
                        .setTitle("提示")
                        .setMessage("您确定要取消挂号吗?")
                        .setPositiveButton("确定",
                                (dialog,what) -> {
                                    canclePresenter.cancleLink(doctorId,IdUtil.getIdString());
                                    dialog.dismiss();
                                })
                        .setNegativeButton("取消",
                                (dialog,what) ->
                                    dialog.dismiss()
                                )
                        .setCancelable(true)
                        .show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public int getLayout() {
        return R.layout.activity_current_patients;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        type = getIntent().getIntExtra(GET_FROM, 0);
        super.onCreate(savedInstanceState);
    }


    Handler handler = new Handler();

    @Override
    public void onRefresh() {
        handler.postDelayed(
                () -> {
                    adapter.notifyDataSetChanged();
                    return;
                }, 2000);
    }

    @Override
    public void onLoadMore() {

    }

    @Override
    public void showProgress() {

    }

    @Override
    public void hideProgress() {

    }

    @Override
    public void showMsg(String msg) {

    }

    public String doEncode(String data, String keyString) {
        try {
            md = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        //生成字节Key
        byte[] byteKey = md.digest(keyString.getBytes());
        //Key转换
        Key convertKey = new SecretKeySpec(byteKey, "AES");
        Key myKey = convertKey;
        try {
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            //解密
            cipher.init(Cipher.DECRYPT_MODE, myKey);
            byte[] decodeByte = cipher.doFinal(hex2byte(data));
            String decodeString = new String(decodeByte);
            Log.e("decodeString", new String(decodeString));
            return decodeString;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static final byte[] hex2byte(String hex)
            throws IllegalArgumentException {
        if (hex.length() % 2 != 0) {
            throw new IllegalArgumentException();
        }
        char[] arr = hex.toCharArray();
        byte[] b = new byte[hex.length() / 2];
        for (int i = 0, j = 0, l = hex.length(); i < l; i++, j++) {
            String swap = "" + arr[i++] + arr[i];
            int byteint = Integer.parseInt(swap, 16) & 0xFF;
            b[j] = new Integer(byteint).byteValue();
        }
        return b;
    }

    @Override
    public void showPatient(PatientInfo patientInfo) {
        for (int i = 0; i < patientInfo.getBody().getList().size(); i++) {
            String name = doEncode(patientInfo.getBody().getList().get(i).getNickName(), ResponseCons.KEY_NAME);
            Person person = new Person(name, "", "120.77.87.78:8080/arti-sports/image//user15.png");
            lists.add(person);
            listId.add(patientInfo.getBody().getList().get(i).getIdString());
        }
        adapter.addAll(lists);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void cancleLinkSucceed() {
        if(type ==PATIENT)
        {
            SharedPreferences preferences =getSharedPreferences("isConnect",MODE_PRIVATE);
            SharedPreferences.Editor editor = preferences.edit();
            editor.clear();
            editor.commit();
            finish();
        }
        else {

        }
    }
}
