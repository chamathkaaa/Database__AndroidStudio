package com.example.database_androidstudio.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class DBHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "UserInfo.db";

    public static final String TABLE_NAME = "users";
    public static final String COL_ID = "username";
    public static final String COL_USERNAME = "username";
    public static final String COL_PASSWORD = "password";

    public DBHelper(Context context){
        super(context,DATABASE_NAME,null,1);
        SQLiteDatabase db = this.getWritableDatabase();

    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE " +TABLE_NAME+ "(ID INTEGER PRIMARY KEY AUTOINCREMENT, username TEXT, password TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " +TABLE_NAME);
        onCreate(sqLiteDatabase);
    }

    //insert values
    public boolean addInfo(Users obj){
        SQLiteDatabase db = getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(DBHelper.COL_USERNAME, obj.getUsername());
        values.put(DBHelper.COL_PASSWORD, obj.getPassword());

        long  result = db.insert(TABLE_NAME,null,values);

        if(result > 0){
            return true;
        }else{
            return false;
        }
    }

    public boolean updateInfo(int id, String username, String password){
        SQLiteDatabase db = getWritableDatabase();

        ContentValues values = new ContentValues();


    }
}
