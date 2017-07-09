package com.zxr.medicalaid.net;


import com.zxr.medicalaid.mvp.entity.Data;
import com.zxr.medicalaid.mvp.entity.moudle.DrugInfo;
import com.zxr.medicalaid.mvp.entity.moudle.LinkInfo;
import com.zxr.medicalaid.mvp.entity.moudle.UserInfo;

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

    @POST("user/signUp")
    @FormUrlEncoded
    Observable<Data<String>> signIn(@Field("nickName")String nickName,@Field("password")String password,@Field("phoneNumber")String phoneNumber,
                                    @Field("type")String type);
    @POST("user/signIn")
    @FormUrlEncoded
    Observable<UserInfo> logIn(@Field("phoneNumber")String phoneNumber, @Field("password")String password);

    @POST("link")
    @FormUrlEncoded
    Observable<LinkInfo> linkDP(@Field("doctorId")String doctorId,@Field("patient")String patientId);
}
