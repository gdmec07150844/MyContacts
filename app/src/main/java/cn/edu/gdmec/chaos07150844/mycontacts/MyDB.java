package cn.edu.gdmec.chaos07150844.mycontacts;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Chaos丶 on 2016/10/18.
 */
public class MyDB extends SQLiteOpenHelper{
    private static String DB_NAME = "My_DB.db";
    private static int DB_VERSION = 2;
    private SQLiteDatabase db;

    public MyDB(Context context){
        super(context,DB_NAME,null,DB_VERSION);
        db = getWritableDatabase();
    }

    public SQLiteDatabase openConn(){
        db = getWritableDatabase();
        return db;
    }

    public void closeConn(){
        db.close();
    }

    public boolean createTable(String createTableSql){
        try {
            openConn();
            db.execSQL(createTableSql);
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }finally {
            closeConn();
        }
        return true;
    }

    public boolean save(String tableName, ContentValues values){
        try {
            openConn();
            db.insert(tableName,null,values);
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }finally {
            closeConn();
        }
        return true;
    }

    public boolean update(String table,ContentValues values,String whereClause,String []whereArgs){
        try {
            openConn();
            db.update(table,values,whereClause,whereArgs);
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }finally {
            closeConn();
        }
        return true;
    }

    public boolean dalete(String table,String deleteSql,String obj[]){
        try {
            openConn();
            db.delete(table,deleteSql,obj);
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }finally {
            closeConn();
        }
        return true;
    }

    public Cursor find(String findSql,String obj[]){
        try{
            openConn();
            Cursor cursor = db.rawQuery(findSql,obj);
            return cursor;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }finally {
            closeConn();
        }
    }

    public boolean isTableExits(String tableName){
        try {
            openConn();
            String str = "select count(*)xcount from " + tableName;
            db.rawQuery(str,null).close();
        }catch (Exception e){
            return false;
        }
        return true;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
