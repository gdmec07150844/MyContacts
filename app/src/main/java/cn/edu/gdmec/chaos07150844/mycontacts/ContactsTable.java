package cn.edu.gdmec.chaos07150844.mycontacts;

import android.content.ContentValues;
import android.content.Context;

/**
 * Created by Chaos丶 on 2016/10/18.
 */
public class ContactsTable {
    private final static String TABLENAME = "contactsTable";
    private MyDB db;

    public ContactsTable(Context context){
        db = new MyDB(context);
        if (!db.isTableExits(TABLENAME)){
            String createTableSql = "CREATE TABLE IF NOT EXISTS " + TABLENAME + "(id_DB integer " + "primary key AUTOINCREMENT," +
                    User.NAME + "VARCHAR," + User.PHONE + "VARCHAR," + User.DANWEI + "VARCHAR," + User.QQ + "VARCHAR," + User.ADDRESS + "VARCHAR)";
            db.createTable(createTableSql);
        }
    }

    public boolean addData(User user){
        ContentValues values = new ContentValues();
        values.put(User.NAME,user.getName());
        values.put(User.PHONE,user.getPhone());
        values.put(User.DANWEI,user.getDanwei());
        values.put(User.QQ,user.getQq());
        values.put(User.ADDRESS,user.getAddress());
        return db.save(TABLENAME,values);
    }
}
