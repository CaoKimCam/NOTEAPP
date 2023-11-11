package com.example.sqlite.Database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.ContactsContract;

public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME="APPNOTE";
    private static final int DATABASE_VERSION =1;
    //1. bang note
    private static final String TABLE_NOTES="NOTE";
    private static final String COLUMN_NOTE_ID="ID";
    private static final String COLUMN_NOTE_TITLE="TITLE";
    private static final String COLUMN_NOTE_DATE="DATE";
    private static final String COLUMN_NOTE_CONTENT="CONTENT";
    //2. bang user
    private static final String TABLE_USER="USER";
    private static final String COLUMN_USER_NAME="NAME";
    private static final String COLUMN_USER_PASSWD="PASSWD";
    private static final String COLUMN_USER_EMAIL="EMAIL";
    //3. bang account
    private static final String TABLE_ACCOUNT ="ACCOUNT";
    private static final String COLUMN_ACCOUNT_NAME="NAME";
    private static final String COLUMN_ACCOUNT_EMAIL ="EMAIL";
    private static final String COLUMN_ACCOUNT_BIO="BIO";
    private static final String COLUMN_ACCOUNT_ID="ID";
    //4. bang notepage
    private static final String TABLE_NOTEPAGE="NOTEPAGE";
    private static final String COLUMN_NOTEP_ACCOUNT_ID="ID";
    private static final String COLUMN_NOTEP_TOTAL="TOTAL";
    private static final String COLUMN_NOTEP_NOTE_ID="NOTE_ID";
    //5. bang group
    private static final String TABLE_GROUP="GROUP";
    private static final String COLUMN_GROUP_ACCOUNT_ID="ACCOUNT_ID";
    private static final String COLUMN_GROUP_NAME="GROUP_NAME";
    private static final String COLUMN_GROUP_ID="GROUP_ID";
    public DatabaseHelper(Context context)
    {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //1. bang note
        String createtablenote ="CREATE TABLE NOTE"+ TABLE_NOTES+"("+
        COLUMN_NOTE_ID+"INTEGER PRIMARY KEY AUTOINCREMENT," +
        COLUMN_NOTE_TITLE+"TEXT,"+
        COLUMN_NOTE_CONTENT+"TEXT,"+
        COLUMN_NOTE_DATE+"DATETIME DEFAULT CURRENT_TIMESTAMP"+")";

        //2.bang user
        String createtableuser = "CREATE TABLE USER"+ TABLE_USER+"("+
        COLUMN_USER_EMAIL+"TEXT PRIMARY KEY,"+
        COLUMN_USER_NAME+"TEXT,"+
        COLUMN_USER_PASSWD+"TEXT"+")";

        //3.bang accoount
        String createtableaccount ="CREATE TABLE ACCOUNT"+ TABLE_ACCOUNT+"("+
        COLUMN_ACCOUNT_ID+"INTEGER PRIMARY KEY,"+
        COLUMN_ACCOUNT_NAME+"TEXT,"+
        COLUMN_ACCOUNT_EMAIL+"TEXT,"+
        COLUMN_ACCOUNT_BIO+"TEXT"+")";

        //4.bang notepage
        String createtablenotepage="CREATE TABLE NOTEPAGE"+TABLE_NOTEPAGE+"("+
        COLUMN_NOTEP_NOTE_ID+"INTEGER PRIMARY KEY,"+ COLUMN_NOTEP_ACCOUNT_ID+"TEXT"+
        COLUMN_NOTEP_TOTAL+"INTEGER"+")";

        //5.bang group
        String createtablegroup="CREATE TABLE GROUP"+TABLE_GROUP+"("+
        COLUMN_GROUP_ID+"INTEGER PRIMARY KEY,"+
        COLUMN_GROUP_NAME+"TEXT,"+
        COLUMN_GROUP_ACCOUNT_ID+"INTEGER"+")";

        db.execSQL(createtablenote);
        db.execSQL(createtableuser);
        db.execSQL(createtableaccount);
        db.execSQL(createtablenotepage);
        db.execSQL(createtablegroup);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //xử lý khi cập nhật phiên bản database
        String drop_table= String.format("DROP TABLE IF EXIST %s", TABLE_NOTES);
        db.execSQL(drop_table);
        onCreate(db);
    }

    //Thêm một record mới (cần tạo lớp Note)

    //Truy van bảng dữ liệu (dùng Cusor) (cần tạo lớp Note)

    //Cập nhật dữ liệu trong bảng
    //Xoá 1 record
}
