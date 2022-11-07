package com.example.willpower;

import android.annotation.SuppressLint;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
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
//        File dbFile = new File(DB_PATH + DB_NAME);
//        File dbFile = context.getDatabasePath(DB_NAME);
//        if (dbFile.exists()){
//
//            Toast.makeText(context, "db exist not created", Toast.LENGTH_SHORT).show();
//        }
//        else {
//            Toast.makeText(context, "db created"+dbFile, Toast.LENGTH_SHORT).show();
//        }
//
//        return dbFile.exists();

        SQLiteDatabase checkDB = null;
        try {
            String myPath = DB_PATH + DB_NAME;
            checkDB = SQLiteDatabase.openDatabase(myPath, null,SQLiteDatabase.OPEN_READONLY);

        } catch (Exception e)
        {
            Toast.makeText(context, "db not exist checkd 2", Toast.LENGTH_SHORT).show();
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
