package com.example.myvulnerableapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import at.favre.lib.crypto.bcrypt.BCrypt;

public class MyDBHandler extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "users.db";
    private static final String TABLE_USERS = "users";
    private static final String COLUMN_ID = "_id";
    private static final String COLUMN_USERNAME = "_username";
    private static final String COLUMN_PASSWORD = "_password";
    private static final String COLUMN_PHONE = "_phone";

    //SQLITE CONSTRUCTOR
    public MyDBHandler(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DATABASE_NAME, factory, DATABASE_VERSION);
    }

    //METHOD EXECUTED ON CREATION OF DATABASE
    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE " + TABLE_USERS + "("+
                COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_USERNAME + " TEXT, " +
                COLUMN_PASSWORD + " TEXT, " +
                COLUMN_PHONE + " INTEGER " +
                ");";
        db.execSQL(query);
    }

    //METHOD EXECUTED ON UPGRADE OF DATABASE
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_USERS);
        onCreate(db);
    }

    //METHOD TO ADD USER TO DB
    public void addUser(User user){
        ContentValues values = new ContentValues();
        String bcryptHashString = BCrypt.withDefaults().hashToString(12, user.get_password().toCharArray());

        values.put(COLUMN_USERNAME, user.get_userName());
        values.put(COLUMN_PASSWORD, bcryptHashString);
        values.put(COLUMN_PHONE, user.get_phone());
        SQLiteDatabase db = getWritableDatabase();
        db.insert(TABLE_USERS,null, values);
        db.close();
    }

    //HELPER METHOD TO SEE DB CONTENT
    public String databaseToString(){
        String dbString = "";
        SQLiteDatabase db = getWritableDatabase();
        String query = "SELECT * FROM " + TABLE_USERS + " WHERE 1";
        Cursor c = db.rawQuery(query,null);
        c.moveToFirst();
        while (c.moveToNext()){
            if (c.getString(c.getColumnIndexOrThrow("_username"))!=null){
                dbString += c.getString(c.getColumnIndexOrThrow("_username"));
                dbString+= " ";
                dbString += c.getString(c.getColumnIndexOrThrow("_password"));
                dbString+= " ";
                dbString += c.getString(c.getColumnIndexOrThrow("_phone"));
                dbString+= "\n";
            }
        }
        db.close();
        return dbString;
    }

    //METHOD TO CHECK IF DATA ALREADY EXISTS IN DATABASE
    public boolean checkDataExistOrNot(String columnName, String value) {
        SQLiteDatabase sqLiteDatabase = getReadableDatabase();
        String query = "SELECT * FROM " + TABLE_USERS + " WHERE " + columnName + " = " + "'"+ value + "' ;";
        Cursor cursor = sqLiteDatabase.rawQuery(query, null);
        if (cursor.getCount() <= 0) {
            cursor.close();
            return false;  // return false if value not exists in database
        }
        cursor.close();
        return true;  // return true if value exists in database
    }

    public String getPhone(String userName){
        SQLiteDatabase sqLiteDatabase = getReadableDatabase();
        String query = "SELECT _phone FROM " + TABLE_USERS + " WHERE " + COLUMN_USERNAME + " = " + "'"+userName+"' ;";
        Cursor result = sqLiteDatabase.rawQuery(query, null);
        result.moveToFirst();
        return result.getString(0);
    }

    public boolean checkPassword(String password, String userName){
        SQLiteDatabase sqLiteDatabase = getReadableDatabase();
        String query = "SELECT _password FROM " + TABLE_USERS + " WHERE " + COLUMN_USERNAME + " = " + "'"+userName+"' ;";
        Cursor result = sqLiteDatabase.rawQuery(query, null);
        result.moveToFirst();
        if(result.getCount()>0 && BCrypt.verifyer().verify(password.toCharArray(), result.getString(0)).verified){
            return true;
        }else{
            return false;
        }
    }

}
