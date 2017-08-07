package com.zxr.medicalaid.utils.db;

import com.zxr.medicalaid.DaoSession;
import com.zxr.medicalaid.User;
import com.zxr.medicalaid.UserDao;

/**
 * Created by ASUS-NB on 2017/7/8.
 */

public class IdUtil {
    public static String getIdString(){
        DaoSession daoSession = DbUtil.getDaosession();
        UserDao userDao = daoSession.getUserDao();
        User user = userDao.queryBuilder().where(UserDao.Properties.IsAlready.eq(1)).unique();
        return user.getIdString();
    }

}
