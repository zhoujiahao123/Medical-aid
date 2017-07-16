package com.zxr.medicalaid;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;

import de.greenrobot.dao.AbstractDao;
import de.greenrobot.dao.Property;
import de.greenrobot.dao.internal.DaoConfig;

import com.zxr.medicalaid.Date;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table DATE.
*/
public class DateDao extends AbstractDao<Date, Void> {

    public static final String TABLENAME = "DATE";

    /**
     * Properties of entity Date.<br/>
     * Can be used for QueryBuilder and for referencing column names.
    */
    public static class Properties {
        public final static Property Date = new Property(0, String.class, "date", false, "DATE");
    };


    public DateDao(DaoConfig config) {
        super(config);
    }
    
    public DateDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(SQLiteDatabase db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "'DATE' (" + //
                "'DATE' TEXT);"); // 0: date
    }

    /** Drops the underlying database table. */
    public static void dropTable(SQLiteDatabase db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "'DATE'";
        db.execSQL(sql);
    }

    /** @inheritdoc */
    @Override
    protected void bindValues(SQLiteStatement stmt, Date entity) {
        stmt.clearBindings();
 
        String date = entity.getDate();
        if (date != null) {
            stmt.bindString(1, date);
        }
    }

    /** @inheritdoc */
    @Override
    public Void readKey(Cursor cursor, int offset) {
        return null;
    }    

    /** @inheritdoc */
    @Override
    public Date readEntity(Cursor cursor, int offset) {
        Date entity = new Date( //
            cursor.isNull(offset + 0) ? null : cursor.getString(offset + 0) // date
        );
        return entity;
    }
     
    /** @inheritdoc */
    @Override
    public void readEntity(Cursor cursor, Date entity, int offset) {
        entity.setDate(cursor.isNull(offset + 0) ? null : cursor.getString(offset + 0));
     }
    
    /** @inheritdoc */
    @Override
    protected Void updateKeyAfterInsert(Date entity, long rowId) {
        // Unsupported or missing PK type
        return null;
    }
    
    /** @inheritdoc */
    @Override
    public Void getKey(Date entity) {
        return null;
    }

    /** @inheritdoc */
    @Override    
    protected boolean isEntityUpdateable() {
        return true;
    }
    
}
