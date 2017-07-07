package com.zxr.medicalaid.net;

import com.zxr.medicalaid.mvp.entity.Data;
import com.zxr.medicalaid.mvp.entity.moudle.DrugInfo;

import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import rx.Observable;

/**
 * Created by 猿人 on 2017/5/24.
 */

public interface Api {
    @POST("drug/info")
    @FormUrlEncoded
    Observable<Data<DrugInfo>> getDrugInfo(@Field("chineseName")String drugName);
}
