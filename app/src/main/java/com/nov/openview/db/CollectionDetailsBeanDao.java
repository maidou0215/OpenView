package com.nov.openview.db;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.internal.DaoConfig;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;

import com.nov.openview.bean.CollectionDetailsBean;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "COLLECTION_DETAILS_BEAN".
*/
public class CollectionDetailsBeanDao extends AbstractDao<CollectionDetailsBean, Long> {

    public static final String TABLENAME = "COLLECTION_DETAILS_BEAN";

    /**
     * Properties of entity CollectionDetailsBean.<br/>
     * Can be used for QueryBuilder and for referencing column names.
     */
    public static class Properties {
        public final static Property Id = new Property(0, Long.class, "id", true, "_id");
        public final static Property Url = new Property(1, String.class, "url", false, "URL");
        public final static Property Time = new Property(2, String.class, "time", false, "TIME");
        public final static Property Type = new Property(3, String.class, "type", false, "TYPE");
        public final static Property ImgUrl = new Property(4, String.class, "imgUrl", false, "IMG_URL");
        public final static Property Title = new Property(5, String.class, "title", false, "TITLE");
    }


    public CollectionDetailsBeanDao(DaoConfig config) {
        super(config);
    }
    
    public CollectionDetailsBeanDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"COLLECTION_DETAILS_BEAN\" (" + //
                "\"_id\" INTEGER PRIMARY KEY AUTOINCREMENT ," + // 0: id
                "\"URL\" TEXT UNIQUE ," + // 1: url
                "\"TIME\" TEXT," + // 2: time
                "\"TYPE\" TEXT," + // 3: type
                "\"IMG_URL\" TEXT," + // 4: imgUrl
                "\"TITLE\" TEXT);"); // 5: title
    }

    /** Drops the underlying database table. */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"COLLECTION_DETAILS_BEAN\"";
        db.execSQL(sql);
    }

    @Override
    protected final void bindValues(DatabaseStatement stmt, CollectionDetailsBean entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
 
        String url = entity.getUrl();
        if (url != null) {
            stmt.bindString(2, url);
        }
 
        String time = entity.getTime();
        if (time != null) {
            stmt.bindString(3, time);
        }
 
        String type = entity.getType();
        if (type != null) {
            stmt.bindString(4, type);
        }
 
        String imgUrl = entity.getImgUrl();
        if (imgUrl != null) {
            stmt.bindString(5, imgUrl);
        }
 
        String title = entity.getTitle();
        if (title != null) {
            stmt.bindString(6, title);
        }
    }

    @Override
    protected final void bindValues(SQLiteStatement stmt, CollectionDetailsBean entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
 
        String url = entity.getUrl();
        if (url != null) {
            stmt.bindString(2, url);
        }
 
        String time = entity.getTime();
        if (time != null) {
            stmt.bindString(3, time);
        }
 
        String type = entity.getType();
        if (type != null) {
            stmt.bindString(4, type);
        }
 
        String imgUrl = entity.getImgUrl();
        if (imgUrl != null) {
            stmt.bindString(5, imgUrl);
        }
 
        String title = entity.getTitle();
        if (title != null) {
            stmt.bindString(6, title);
        }
    }

    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0);
    }    

    @Override
    public CollectionDetailsBean readEntity(Cursor cursor, int offset) {
        CollectionDetailsBean entity = new CollectionDetailsBean( //
            cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0), // id
            cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1), // url
            cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2), // time
            cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3), // type
            cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4), // imgUrl
            cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5) // title
        );
        return entity;
    }
     
    @Override
    public void readEntity(Cursor cursor, CollectionDetailsBean entity, int offset) {
        entity.setId(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
        entity.setUrl(cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1));
        entity.setTime(cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2));
        entity.setType(cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3));
        entity.setImgUrl(cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4));
        entity.setTitle(cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5));
     }
    
    @Override
    protected final Long updateKeyAfterInsert(CollectionDetailsBean entity, long rowId) {
        entity.setId(rowId);
        return rowId;
    }
    
    @Override
    public Long getKey(CollectionDetailsBean entity) {
        if(entity != null) {
            return entity.getId();
        } else {
            return null;
        }
    }

    @Override
    public boolean hasKey(CollectionDetailsBean entity) {
        return entity.getId() != null;
    }

    @Override
    protected final boolean isEntityUpdateable() {
        return true;
    }
    
}
