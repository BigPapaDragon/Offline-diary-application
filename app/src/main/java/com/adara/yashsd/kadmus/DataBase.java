package com.adara.yashsd.kadmus;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


public class DataBase extends SQLiteOpenHelper {
    public final static String DATABASE_NAME = "Enteries.db";
    public final static String TABLE_NAME = "emteries";
    public final static String COL_1 = "ID";
    public final static String COL_2 = "NAME";
    public final static String COL_3 = "AUTHOR";
    public final static String COL_4 = "TIMESTAMP";
    public final static String COL_5 = "TYPE";
    public final static String COL_6 = "BODY";
    public final static String COL_7 = "HASHTAG1";
    public final static String COL_8 = "HASHTAG2";
    public final static String COL_9 = "HASHTAG3";
    public final static String COL_10 = "HASHTAG4";
    public final static String COL_11 = "HASHTAG5";
    public final static String COL_12 = "HASHTAG6";
    public final static String COL_13 = "HASHTAG7";
    public final static String COL_14 = "HASHTAG8";
    public final static String COL_15 = "HASHTAG9";
    public final static String COL_16 = "HASHTAG10";

    private Context context = null;

    public DataBase(Context context) {
        super(context,DATABASE_NAME, null, 1);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_NAME + "(ID INTEGER PRIMARY KEY AUTOINCREMENT,NAME TEXT,AUTHOR TEXT,TIMESTAMP TEXT,TYPE TEXT,BODY TEXT,HASHTAGCOUNT TEXT,HASHTAG1 TEXT,HASHTAG2 TEXT,HASHTAG3 TEXT,HASHTAG4 TEXT,HASHTAG5 TEXT,HASHTAG6 TEXT,HASHTAG7 TEXT,HASHTAG8 TEXT,HASHTAG9 TEXT,HASHTAG10 TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public boolean insertdata(String name,String author,String timestamp,String type,String body,
                              String hashtag1,String hashtag2,String hashtag3,String hashtag4,String hashtag5,String hashtag6,String hashtag7,
                              String hashtag8,String hashtag9,String hashtag10)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_2,name);
        contentValues.put(COL_3,author);
        contentValues.put(COL_4,timestamp);
        contentValues.put(COL_5,type);
        contentValues.put(COL_6,body);
        contentValues.put(COL_7,hashtag1);
        contentValues.put(COL_8,hashtag2);
        contentValues.put(COL_9,hashtag3);
        contentValues.put(COL_10,hashtag4);
        contentValues.put(COL_11,hashtag5);
        contentValues.put(COL_12,hashtag6);
        contentValues.put(COL_13,hashtag7);
        contentValues.put(COL_14,hashtag8);
        contentValues.put(COL_15,hashtag9);
        contentValues.put(COL_16,hashtag10);
        long success = db.insert(TABLE_NAME,null,contentValues);
        if(success == -1){
            Toast.makeText(context, "Save fail", Toast.LENGTH_SHORT).show();
            return false;
        }
        else
            return true;

    }


    public Cursor viewalldata()
    {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from "+TABLE_NAME,null);
        return res;
    }

    public boolean updatedata(String id,String name,String author,String timestamp,String type,String body,
                              String hashtag1,String hashtag2,String hashtag3,String hashtag4,String hashtag5,String hashtag6,String hashtag7,
                              String hashtag8,String hashtag9,String hashtag10)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_1,id);
        contentValues.put(COL_2,name);
        contentValues.put(COL_3,author);
        contentValues.put(COL_4,timestamp);
        contentValues.put(COL_5,type);
        contentValues.put(COL_6,body);
        contentValues.put(COL_7,hashtag1);
        contentValues.put(COL_8,hashtag2);
        contentValues.put(COL_9,hashtag3);
        contentValues.put(COL_10,hashtag4);
        contentValues.put(COL_11,hashtag5);
        contentValues.put(COL_12,hashtag6);
        contentValues.put(COL_13,hashtag7);
        contentValues.put(COL_14,hashtag8);
        contentValues.put(COL_15,hashtag9);
        contentValues.put(COL_16,hashtag10);
        int effected = db.update(TABLE_NAME,contentValues,"ID = ?",new String[] { id } );
        if(effected>0)
            return true;
        else
            return false;
    }

    public boolean deletedata(String id) {
        SQLiteDatabase db = this.getWritableDatabase();
        int effected = db.delete(TABLE_NAME,"ID = ?",new String[] { id });
        if(effected>0)
            return true;
        else
            return false;
    }

    public List<String> IdForArray()
    {
        ArrayList<String> names = new ArrayList();
        SQLiteDatabase mydb = this.getWritableDatabase();
        Cursor res = mydb.rawQuery("select * from "+TABLE_NAME,null);
        res.moveToFirst();
        if(res.getCount()>0) {
            do {
                //names.add(Integer.toString(res.getInt(0)));
                names.add(res.getString(0));
            }
            while (res.moveToNext());
        }
        else
        {
            names.add("");
        }
        return names;
    }

    public List<String> NamesForArray()
    {
        ArrayList<String> names = new ArrayList();
        SQLiteDatabase mydb = this.getWritableDatabase();
        Cursor res = mydb.rawQuery("select * from "+TABLE_NAME,null);
        res.moveToFirst();
        if(res.getCount()>0) {
            do {
                //names.add(Integer.toString(res.getInt(0)));
                names.add(res.getString(1));
            }
            while (res.moveToNext());
        }
        else
        {
            names.add("");
        }
        return names;
    }

    public List<String> AuthorForArray()
    {
        ArrayList<String> phonenumbers = new ArrayList();
        SQLiteDatabase mydb = this.getWritableDatabase();
        Cursor res = mydb.rawQuery("select * from "+TABLE_NAME,null);
        res.moveToFirst();
        if(res.getCount()>0) {
            do {
                //names.add(Integer.toString(res.getInt(0)));
                phonenumbers.add(res.getString(2));
            }
            while (res.moveToNext());
        }
        else
        {
            phonenumbers.add("");
        }
        return phonenumbers;
    }

    public List<String> TimestampForArray()
    {
        ArrayList<String> phonenumbers = new ArrayList();
        SQLiteDatabase mydb = this.getWritableDatabase();
        Cursor res = mydb.rawQuery("select * from "+TABLE_NAME,null);
        res.moveToFirst();
        if(res.getCount()>0) {
            do {
                //names.add(Integer.toString(res.getInt(0)));
                phonenumbers.add(res.getString(3));
            }
            while (res.moveToNext());
        }
        else
        {
            phonenumbers.add("");
        }
        return phonenumbers;
    }

    public List<String> TypeForArray()
    {
        ArrayList<String> phonenumbers = new ArrayList();
        SQLiteDatabase mydb = this.getWritableDatabase();
        Cursor res = mydb.rawQuery("select * from "+TABLE_NAME,null);
        res.moveToFirst();
        if(res.getCount()>0) {
            do {
                //names.add(Integer.toString(res.getInt(0)));
                phonenumbers.add(res.getString(4));
            }
            while (res.moveToNext());
        }
        else
        {
            phonenumbers.add("");
        }
        return phonenumbers;
    }

    public List<String> BodyForArray()
    {
        ArrayList<String> phonenumbers = new ArrayList();
        SQLiteDatabase mydb = this.getWritableDatabase();
        Cursor res = mydb.rawQuery("select * from "+TABLE_NAME,null);
        res.moveToFirst();
        if(res.getCount()>0) {
            do {
                //names.add(Integer.toString(res.getInt(0)));
                phonenumbers.add(res.getString(5));
            }
            while (res.moveToNext());
        }
        else
        {
            phonenumbers.add("");
        }
        return phonenumbers;
    }

    public List<String> Hashtag1ForArray()
    {
        ArrayList<String> phonenumbers = new ArrayList();
        SQLiteDatabase mydb = this.getWritableDatabase();
        Cursor res = mydb.rawQuery("select * from "+TABLE_NAME,null);
        res.moveToFirst();
        if(res.getCount()>0) {
            do {
                //names.add(Integer.toString(res.getInt(0)));
                phonenumbers.add(res.getString(6));
            }
            while (res.moveToNext());
        }
        else
        {
            phonenumbers.add("");
        }
        return phonenumbers;
    }

    public List<String> Hashtag2ForArray()
    {
        ArrayList<String> phonenumbers = new ArrayList();
        SQLiteDatabase mydb = this.getWritableDatabase();
        Cursor res = mydb.rawQuery("select * from "+TABLE_NAME,null);
        res.moveToFirst();
        if(res.getCount()>0) {
            do {
                //names.add(Integer.toString(res.getInt(0)));
                phonenumbers.add(res.getString(7));
            }
            while (res.moveToNext());
        }
        else
        {
            phonenumbers.add("");
        }
        return phonenumbers;
    }

    public List<String> Hashtag3ForArray()
    {
        ArrayList<String> phonenumbers = new ArrayList();
        SQLiteDatabase mydb = this.getWritableDatabase();
        Cursor res = mydb.rawQuery("select * from "+TABLE_NAME,null);
        res.moveToFirst();
        if(res.getCount()>0) {
            do {
                //names.add(Integer.toString(res.getInt(0)));
                phonenumbers.add(res.getString(8));
            }
            while (res.moveToNext());
        }
        else
        {
            phonenumbers.add("");
        }
        return phonenumbers;
    }

    public List<String> Hashtag4ForArray()
    {
        ArrayList<String> phonenumbers = new ArrayList();
        SQLiteDatabase mydb = this.getWritableDatabase();
        Cursor res = mydb.rawQuery("select * from "+TABLE_NAME,null);
        res.moveToFirst();
        if(res.getCount()>0) {
            do {
                //names.add(Integer.toString(res.getInt(0)));
                phonenumbers.add(res.getString(9));
            }
            while (res.moveToNext());
        }
        else
        {
            phonenumbers.add("");
        }
        return phonenumbers;
    }

    public List<String> Hashtag5ForArray()
    {
        ArrayList<String> phonenumbers = new ArrayList();
        SQLiteDatabase mydb = this.getWritableDatabase();
        Cursor res = mydb.rawQuery("select * from "+TABLE_NAME,null);
        res.moveToFirst();
        if(res.getCount()>0) {
            do {
                //names.add(Integer.toString(res.getInt(0)));
                phonenumbers.add(res.getString(10));
            }
            while (res.moveToNext());
        }
        else
        {
            phonenumbers.add("");
        }
        return phonenumbers;
    }

    public List<String> Hashtag6ForArray()
    {
        ArrayList<String> phonenumbers = new ArrayList();
        SQLiteDatabase mydb = this.getWritableDatabase();
        Cursor res = mydb.rawQuery("select * from "+TABLE_NAME,null);
        res.moveToFirst();
        if(res.getCount()>0) {
            do {
                //names.add(Integer.toString(res.getInt(0)));
                phonenumbers.add(res.getString(11));
            }
            while (res.moveToNext());
        }
        else
        {
            phonenumbers.add("");
        }
        return phonenumbers;
    }

    public List<String> Hashtag7ForArray()
    {
        ArrayList<String> phonenumbers = new ArrayList();
        SQLiteDatabase mydb = this.getWritableDatabase();
        Cursor res = mydb.rawQuery("select * from "+TABLE_NAME,null);
        res.moveToFirst();
        if(res.getCount()>0) {
            do {
                //names.add(Integer.toString(res.getInt(0)));
                phonenumbers.add(res.getString(12));
            }
            while (res.moveToNext());
        }
        else
        {
            phonenumbers.add("");
        }
        return phonenumbers;
    }

    public List<String> Hashtag8ForArray()
    {
        ArrayList<String> phonenumbers = new ArrayList();
        SQLiteDatabase mydb = this.getWritableDatabase();
        Cursor res = mydb.rawQuery("select * from "+TABLE_NAME,null);
        res.moveToFirst();
        if(res.getCount()>0) {
            do {
                //names.add(Integer.toString(res.getInt(0)));
                phonenumbers.add(res.getString(13));
            }
            while (res.moveToNext());
        }
        else
        {
            phonenumbers.add("");
        }
        return phonenumbers;
    }

    public List<String> Hashtag9ForArray()
    {
        ArrayList<String> phonenumbers = new ArrayList();
        SQLiteDatabase mydb = this.getWritableDatabase();
        Cursor res = mydb.rawQuery("select * from "+TABLE_NAME,null);
        res.moveToFirst();
        if(res.getCount()>0) {
            do {
                //names.add(Integer.toString(res.getInt(0)));
                phonenumbers.add(res.getString(14));
            }
            while (res.moveToNext());
        }
        else
        {
            phonenumbers.add("");
        }
        return phonenumbers;
    }

    public List<String> Hashtag10ForArray()
    {
        ArrayList<String> phonenumbers = new ArrayList();
        SQLiteDatabase mydb = this.getWritableDatabase();
        Cursor res = mydb.rawQuery("select * from "+TABLE_NAME,null);
        res.moveToFirst();
        if(res.getCount()>0) {
            do {
                //names.add(Integer.toString(res.getInt(0)));
                phonenumbers.add(res.getString(15));
            }
            while (res.moveToNext());
        }
        else
        {
            phonenumbers.add("");
        }
        return phonenumbers;
    }
}
