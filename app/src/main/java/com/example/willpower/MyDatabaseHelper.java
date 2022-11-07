package com.example.willpower;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class MyDatabaseHelper extends SQLiteOpenHelper {
    private static  final String DB_NAME = "willpower.db";
    private static  final int VERSION = 1;
    private Context context;
    String DB_PATH = "/data/data/" + context.getApplicationContext().getPackageName() + "/";


    public MyDatabaseHelper(@Nullable Context context) throws IOException {
        super(context, DB_NAME, null, VERSION);
//        this.context = context;
        Toast.makeText(context, "Open helper called", Toast.LENGTH_SHORT).show();

//        if(checkDataBase()){
//            Toast.makeText(context, "database found", Toast.LENGTH_SHORT).show();
//        }


    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
//    public boolean readGameMotivation() {
//        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
//        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM game_motivation;",null);
//        if(cursor.getCount()>0){
//            Toast.makeText(context, "data fetched successfully from database", Toast.LENGTH_SHORT).show();
//            return true;
//        }
//        else {
//            Toast.makeText(context, "data fetched none", Toast.LENGTH_SHORT).show();
//            return false;
//        }
//
//    }
//
//    @SuppressLint("Range")
//    public ArrayList<String> getValues(String table) {
//        ArrayList<String> values = new ArrayList<String>();
//
//        SQLiteDatabase db = this.getReadableDatabase();
//        Cursor cursor = db.rawQuery("SELECT value FROM " + table, null);
//
//        if(cursor.moveToFirst()) {
//            do {
//                values.add(cursor.getString(cursor.getColumnIndex("message")));
//            }while(cursor.moveToNext());
//        }
//
//        cursor.close();
//        db.close();
//        return values;
//    }

    public void createDatabase() throws IOException {

        //If database not exists copy it from the assets

        boolean mDataBaseExist = checkDataBase();
        if (!mDataBaseExist) {
            try {
                //Copy the database from assests
                copyDataBase();
            } catch (IOException mIOException) {
                throw new Error("ErrorCopyingDataBase");
            }
        }
        else {
        }
    }

//
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

    public boolean checkDataBase() {
        File dbFile = new File(DB_PATH + DB_NAME);
        return dbFile.exists();
    }

}
