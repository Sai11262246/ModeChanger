package com.vivartha.modechanger;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by sai krishna, vikas on 11/8/2018.
 * This integrates the SQLite database into the apploication
 * craetes two tables.
 * one is to store user details.
 * another is to store the user ctredentials and details.
 */

public class DataBaseHelper extends SQLiteOpenHelper {

    /**
     * The name of the database.
     */
    public static final String DB_NAME = "mode.db";

    /**
     * The DB's version number. This needs to be increased on schema changes.
     */
    public static final int DB_VERSION = 1;
    private static final String TAG = "ServicePulseDbHelper";

    /**
     * Singleton instance of {@link DataBaseHelper}.
     */
    private static DataBaseHelper instance = null;
    private SQLiteDatabase db;

    /**
     * @return the {@link DataBaseHelper} singleton.
     */
    public static DataBaseHelper getInstance() {
        if (instance != null) {
            return instance;
        } else {
            return new DataBaseHelper();
        }
    }

    private DataBaseHelper() {
        super(AppController.getInstance().getApplicationContext(), DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String modes_table = "CREATE TABLE modes ("
                + "row_id INTEGER PRIMARY KEY NOT NULL,"
                + "mode_name TEXT,"
                + "mode_value TEXT,"
                + "other1 TEXT,"
                + "other2 TEXT,"
                + "other3 TEXT,"
                + "other4 TEXT)";
        sqLiteDatabase.execSQL(modes_table);

        String users_table = "CREATE TABLE users ("
                + "row_id INTEGER PRIMARY KEY NOT NULL,"
                + "name TEXT,"
                + "phone TEXT,"
                + "email TEXT,"
                + "password TEXT,"
                + "other3 TEXT,"
                + "other4 TEXT)";
        sqLiteDatabase.execSQL(users_table);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public String getValueByOptionName(String option){
        db = getReadableDatabase();
        Cursor c = null;
        try {
            c = db.rawQuery("SELECT mode_value FROM modes WHERE mode_name ='" + option + "'", null);
            if (c != null)
                if (c.getCount() > 0){
                    c.moveToFirst();
                    return  c.getString(0);
                }


        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (c != null && !c.isClosed()) c.close();
        }
        return "";
    }

    public String getOptionNameByValue(String value){
        db = getReadableDatabase();
        Cursor c = null;
        try {
            c = db.rawQuery("SELECT mode_name FROM modes WHERE mode_value ='" + value + "'", null);
            if (c != null)
                if (c.getCount() > 0){
                    c.moveToFirst();
                    return  c.getString(0);
                }else{
                    return value;
                }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (c != null && !c.isClosed()) c.close();
        }
        return "";
    }


    public boolean isValidUser(String email, String passowrd){
        db = getReadableDatabase();
        Cursor c = null;
        try {
            c = db.rawQuery("SELECT * FROM users WHERE email ='" + email + "' AND password = '"+passowrd+"'", null);
            if (c != null)
                if (c.getCount() > 0){
                   return true;
                }else{
                    return false;
                }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (c != null && !c.isClosed()) c.close();
        }
        return false;
    }




    public void updateValueByOption(String optionName, String new_val) {
        ContentValues cv = new ContentValues();
        db = getWritableDatabase();
        db.rawQuery("delete from modes where mode_name = '"+optionName+"'", null);
        try {
            db.beginTransaction();
            cv.put("mode_name", optionName);
            cv.put("mode_value", new_val);

            db.insert("modes", null, cv);
            db.setTransactionSuccessful();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            db.endTransaction();
            db.close();
        }
    }


    public void inserNewUser(String name, String email,String  phone,String  password ) {
        db = getWritableDatabase();
        ContentValues cv = new ContentValues();
        try {
            db.beginTransaction();
            cv.put("name", name);
            cv.put("phone", phone);
            cv.put("email", email);
            cv.put("password", password);
            db.insert("users", null, cv);
            db.setTransactionSuccessful();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            db.endTransaction();
            db.close();
        }
    }

}
