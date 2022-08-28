package com.example.sqlhinhanh;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;
import androidx.annotation.Nullable;
public class DataSQL extends SQLiteOpenHelper {
    public DataSQL(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }
    void SetDataSQL(String s){
        SQLiteDatabase database = getWritableDatabase();
        database.execSQL(s);
    }
    void INSERT_DOVAT(String ten,String mota,byte[] hinh){
        SQLiteDatabase database = getWritableDatabase();
        String sql = "INSERT INTO DOVAT VALUES(null,?,?,?)";
        SQLiteStatement statement = database.compileStatement(sql);
        statement.clearBindings();
        statement.bindString(1,ten);
        statement.bindString(2,mota);
        statement.bindBlob(3,hinh);
        statement.executeInsert();
    }
    Cursor getDataSQL(String s){
        SQLiteDatabase database = getReadableDatabase();
        return database.rawQuery(s,null);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
