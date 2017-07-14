package com.zxr.medicalaid.mvp.model;

import okhttp3.ResponseBody;
import rx.Observable;

/**
 * Created by 猿人 on 2017/7/13.
 */

public interface QbImageModel {
    Observable<ResponseBody> getQBImage(String id);
}
