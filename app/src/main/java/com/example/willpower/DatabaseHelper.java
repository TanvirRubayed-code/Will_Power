package com.example.willpower;

import android.annotation.SuppressLint;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;


public class DatabaseHelper extends SQLiteOpenHelper {

    private Context context;
    String DB_PATH = "";

    private static final String DB_NAME = "willpower.db";

    private static final int VERSION = 1;
    String TABLE = "game_task";
    String TABLE_F = "SELECT * FROM " + TABLE;
    private final File DB_FILE;
    private SQLiteDatabase mDataBase;


    public DatabaseHelper(@Nullable Context context) throws IOException {
        super(context, DB_NAME, null, VERSION);
        this.context = context;

        DB_PATH = "/data/data/" + context.getApplicationContext().getPackageName() + "/databases/";

        DB_FILE = context.getDatabasePath(DB_NAME);

        if (!checkDataBase(context)) {
            createDatabase();
        }

    }

    public boolean checkDataBase(Context context) {


        SQLiteDatabase checkDB = null;
        try {
            String myPath = DB_PATH + DB_NAME;
            checkDB = SQLiteDatabase.openDatabase(myPath, null,SQLiteDatabase.OPEN_READONLY);

        } catch (Exception e)
        {

        }
        if (checkDB != null) {
            checkDB.close();
        }
        return checkDB != null ? true : false;

    }

    public void createDatabase() throws IOException {

        //If database not exists copy it from the assets

        boolean mDataBaseExist = checkDataBase(context);
        if (!mDataBaseExist) {
            this.getReadableDatabase();
            this.close();
            try {

                //Copy the database from assests
                copyDataBase();
            } catch (IOException mIOException) {
                throw new Error("ErrorCopyingDataBase");
            }
        }
    }

    private void copyDataBase() throws IOException {

        InputStream mInput = context.getApplicationContext().getAssets().open(DB_NAME);

        String outFileName = DB_PATH + DB_NAME;

        OutputStream mOutput = new FileOutputStream(outFileName);


        byte[] mBuffer = new byte[1024];
        int mLength;
        while ((mLength = mInput.read(mBuffer)) > 0) {
            mOutput.write(mBuffer, 0, mLength);
        }
        mOutput.flush();
        mOutput.close();
        mInput.close();
    }

    public String selectedTaskForDay(String addiction, int day){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = null;
        int dayC = day + 1;
        String addictionS = addiction.toLowerCase();
        String data = null;
        try {
            cursor = db.rawQuery("SELECT * FROM "+addictionS+"_task WHERE id="+dayC, null);

            if (cursor.moveToFirst()) {
                do {
                    // get  the  data into array,or class variable
                    data=cursor.getString(1);
                } while (cursor.moveToNext());
            }
            db.close();
        } catch (Exception e) {
            Toast.makeText(context, ""+e, Toast.LENGTH_SHORT).show();

        }

        return data;
    }

    public String selectResourceFortheDay(String addiction, int day){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = null;
        int dayC = day + 1;
        String addictionS = addiction.toLowerCase();
        String resources = null;

        try {
            cursor = db.rawQuery("SELECT * FROM "+addictionS+"_resource WHERE id="+dayC, null);

            if (cursor.moveToFirst()) {
                do {
                    // get  the  data into array,or class variable
                    resources=cursor.getString(1);
                } while (cursor.moveToNext());
            }
            db.close();
        } catch (Exception e) {
            Toast.makeText(context, ""+e, Toast.LENGTH_SHORT).show();

        }

        return resources;
    }

    public String selectRandomInspiration(int num){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = null;
        String randomInspiration = null;
        try {
            cursor = db.rawQuery("SELECT * from inspiraton where id="+num, null);

            if (cursor.moveToFirst()) {
                do {
                    // get  the  data into array,or class variable
                    randomInspiration=cursor.getString(1);
                } while (cursor.moveToNext());
            }
            db.close();
        } catch (Exception e) {
            Toast.makeText(context, ""+e, Toast.LENGTH_SHORT).show();

        }
        return randomInspiration;
    }

    public String selectMotivationForDay(String addiction, int day){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = null;
        int dayC = day + 1;
        String addictionS = addiction.toLowerCase();
        String motivation = null;
        try {
            cursor = db.rawQuery("SELECT * FROM "+addictionS+"_motivation WHERE id="+dayC, null);

            if (cursor.moveToFirst()) {
                do {
                    // get  the  data into array,or class variable
                    motivation=cursor.getString(1);
                } while (cursor.moveToNext());
            }
            db.close();
        } catch (Exception e) {
            Toast.makeText(context, ""+e, Toast.LENGTH_SHORT).show();

        }

        return motivation;
    }


    @SuppressLint("Range")
    public Cursor getValues() {

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = null;

        try {
             cursor = db.rawQuery(TABLE_F, null);
             if(cursor==null){
                 Toast.makeText(context, "null", Toast.LENGTH_SHORT).show();
             }
        } catch (Exception e) {
            Toast.makeText(context, ""+e, Toast.LENGTH_SHORT).show();

        }

        return cursor;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }


}
