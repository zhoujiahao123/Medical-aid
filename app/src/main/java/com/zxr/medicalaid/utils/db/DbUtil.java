package com.zxr.medicalaid.utils.db;

import android.database.sqlite.SQLiteDatabase;

import com.zxr.medicalaid.App;

/**
 * Created by ASUS-NB on 2017/7/7.
 */

public class DbUtil {
    public static DaoSession getDaosession(){
        DaoSession daoSession;
        DaoMaster daoMaster;
        DaoMaster.DevOpenHelper helper;
        SQLiteDatabase db;
        helper=new DaoMaster.DevOpenHelper(App.getBaseApplicationContext(),"Example-DB",null);
        db=helper.getWritableDatabase();
        daoMaster=new DaoMaster(db);
        daoSession=daoMaster.newSession();
        return daoSession;
    }
}
