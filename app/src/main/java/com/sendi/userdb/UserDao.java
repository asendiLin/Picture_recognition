package com.sendi.userdb;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;

import de.greenrobot.dao.AbstractDao;
import de.greenrobot.dao.Property;
import de.greenrobot.dao.internal.DaoConfig;

import com.sendi.userdb.User;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "USER".
*/
public class UserDao extends AbstractDao<User, Long> {

    public static final String TABLENAME = "USER";

    /**
     * Properties of entity User.<br/>
     * Can be used for QueryBuilder and for referencing column names.
    */
    public static class Properties {
        public final static Property Id = new Property(0, Long.class, "id", true, "_id");
        public final static Property User_nickname = new Property(1, String.class, "user_nickname", false, "USER_NICKNAME");
        public final static Property User_id = new Property(2, String.class, "user_id", false, "USER_ID");
        public final static Property User_pic_url = new Property(3, String.class, "user_pic_url", false, "USER_PIC_URL");
        public final static Property Phone_number = new Property(4, String.class, "phone_number", false, "PHONE_NUMBER");
        public final static Property Gander = new Property(5, String.class, "gander", false, "GANDER");
        public final static Property Hobbies = new Property(6, String.class, "hobbies", false, "HOBBIES");
    };


    public UserDao(DaoConfig config) {
        super(config);
    }
    
    public UserDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(SQLiteDatabase db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"USER\" (" + //
                "\"_id\" INTEGER PRIMARY KEY ," + // 0: id
                "\"USER_NICKNAME\" TEXT," + // 1: user_nickname
                "\"USER_ID\" TEXT," + // 2: user_id
                "\"USER_PIC_URL\" TEXT," + // 3: user_pic_url
                "\"PHONE_NUMBER\" TEXT," + // 4: phone_number
                "\"GANDER\" TEXT," + // 5: gander
                "\"HOBBIES\" TEXT);"); // 6: hobbies
    }

    /** Drops the underlying database table. */
    public static void dropTable(SQLiteDatabase db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"USER\"";
        db.execSQL(sql);
    }

    /** @inheritdoc */
    @Override
    protected void bindValues(SQLiteStatement stmt, User entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
 
        String user_nickname = entity.getUser_nickname();
        if (user_nickname != null) {
            stmt.bindString(2, user_nickname);
        }
 
        String user_id = entity.getUser_id();
        if (user_id != null) {
            stmt.bindString(3, user_id);
        }
 
        String user_pic_url = entity.getUser_pic_url();
        if (user_pic_url != null) {
            stmt.bindString(4, user_pic_url);
        }
 
        String phone_number = entity.getPhone_number();
        if (phone_number != null) {
            stmt.bindString(5, phone_number);
        }
 
        String gander = entity.getGander();
        if (gander != null) {
            stmt.bindString(6, gander);
        }
 
        String hobbies = entity.getHobbies();
        if (hobbies != null) {
            stmt.bindString(7, hobbies);
        }
    }

    /** @inheritdoc */
    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0);
    }    

    /** @inheritdoc */
    @Override
    public User readEntity(Cursor cursor, int offset) {
        User entity = new User( //
            cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0), // id
            cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1), // user_nickname
            cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2), // user_id
            cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3), // user_pic_url
            cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4), // phone_number
            cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5), // gander
            cursor.isNull(offset + 6) ? null : cursor.getString(offset + 6) // hobbies
        );
        return entity;
    }
     
    /** @inheritdoc */
    @Override
    public void readEntity(Cursor cursor, User entity, int offset) {
        entity.setId(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
        entity.setUser_nickname(cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1));
        entity.setUser_id(cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2));
        entity.setUser_pic_url(cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3));
        entity.setPhone_number(cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4));
        entity.setGander(cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5));
        entity.setHobbies(cursor.isNull(offset + 6) ? null : cursor.getString(offset + 6));
     }
    
    /** @inheritdoc */
    @Override
    protected Long updateKeyAfterInsert(User entity, long rowId) {
        entity.setId(rowId);
        return rowId;
    }
    
    /** @inheritdoc */
    @Override
    public Long getKey(User entity) {
        if(entity != null) {
            return entity.getId();
        } else {
            return null;
        }
    }

    /** @inheritdoc */
    @Override    
    protected boolean isEntityUpdateable() {
        return true;
    }
    
}