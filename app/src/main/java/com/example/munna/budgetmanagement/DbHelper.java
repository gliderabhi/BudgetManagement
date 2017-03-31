package com.example.munna.budgetmanagement;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.text.format.DateFormat;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;


public class DbHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "MonthlyManagement.db";
   public  static final String TABLE_NAME="March";

    ArrayList<String> Table_Array=new ArrayList<>();


Context ctx;
int i=0;

    public DbHelper(Context context) {

        super(context, DATABASE_NAME, null, 1);
        ctx=context;
    }
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("create table "+TABLE_NAME + "(Description String,Money_Spent int,DateTime String)");
    }

    private String getDateTime() {
        SimpleDateFormat dateFormat = new SimpleDateFormat(
                "yyyy-MM-dd", Locale.getDefault());
        Date date = new Date();
        return dateFormat.format(date);
    }

    public boolean insertExpenditure(String desc,int spent/*,String cat*/) {
        SQLiteDatabase db = this.getWritableDatabase();
       /* if(cat=="Money Return" || cat=="Money Added To account"){
            spent=spent*(-1);
        }*/
        ContentValues contentValues = new ContentValues();
        contentValues.put("Description",desc);
        //contentValues.put("Category",cat);
        contentValues.put("Money_Spent",spent );
        contentValues.put("DateTime",getDateTime());
        db.insert(TABLE_NAME, null, contentValues);
        return  true;
    }

    public Cursor TotalExpenses(){
       SQLiteDatabase db=this.getReadableDatabase();
       Cursor res=db.rawQuery("Select sum(Money_Spent) from "+TABLE_NAME,null);
       res.moveToFirst();
       return res;

          }
    public ArrayList<String> description(){

        String selectQuery = "SELECT  * FROM " + TABLE_NAME;
        SQLiteDatabase db  = this.getReadableDatabase();
        Cursor cursor      = db.rawQuery(selectQuery, null);
        ArrayList<String> data=new ArrayList<String>();
        if (cursor.moveToFirst()) {
            do {
                data.add(cursor.getString(0));
            } while (cursor.moveToNext());
        }
        cursor.close();
        return data;
    }

    public ArrayList<Integer> Values(){

        String selectQuery = "SELECT  * FROM " + TABLE_NAME;
        SQLiteDatabase db  = this.getReadableDatabase();
        Cursor cursor      = db.rawQuery(selectQuery, null);
        ArrayList<Integer> data=new ArrayList<Integer>();
        if (cursor.moveToFirst()) {
            do {
                data.add(cursor.getInt(1));
            } while (cursor.moveToNext());
        }
        cursor.close();
        return data;
    }
   /* public ArrayList<String> Category(){

        String selectQuery = "SELECT  * FROM " + TABLE_NAME;
        SQLiteDatabase db  = this.getReadableDatabase();
        Cursor cursor      = db.rawQuery(selectQuery, null);
        ArrayList<String> data=new ArrayList<String>();
        if (cursor.moveToFirst()) {
            do {
                data.add(cursor.getString(2));
            } while (cursor.moveToNext());
        }
        cursor.close();
        return data;
    }*/
    public ArrayList<String> DateTime(){

        String selectQuery = "SELECT  * FROM " + TABLE_NAME;
        SQLiteDatabase db  = this.getReadableDatabase();
        Cursor cursor      = db.rawQuery(selectQuery, null);
        ArrayList<String> data=new ArrayList<String>();
        if (cursor.moveToFirst()) {
            do {
                data.add(cursor.getString(2));
            } while (cursor.moveToNext());
        }
        cursor.close();
        return data;
    }
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
      onCreate(sqLiteDatabase);
    }
      /* long addTable(String loc) {
            SQLiteDatabase sqLiteDatabase=this.getWritableDatabase();
               Table_Array.add(loc);
        String TABLE_NAME=loc;
            sqLiteDatabase.execSQL("create table  "+TABLE_NAME + "(Description String,Money_Spent int,DateTime String)");
            ContentValues cv = new ContentValues();
            cv.put(TABLE_NAME, loc);
            return sqLiteDatabase.insert(loc, null, cv);

        }
*/
}
