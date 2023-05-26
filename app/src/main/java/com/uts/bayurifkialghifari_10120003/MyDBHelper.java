/**
 *
 * Nama : Bayu Rifki Alghifari
 * Nim : 10120003
 * Kelas : IF 1
 * Email : Bayu Rifki Alghifari
 *
 */

package com.uts.bayurifkialghifari_10120003;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import androidx.annotation.Nullable;

public class MyDBHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "uts";
    private static final int DATABASE_VERSION = 1;
    private static final String TABLE_NAME = "notes";
    private static final String KEY_ID = "id";
    private static final String KEY_TITLE = "title";
    private static final String KEY_DESCRIPTION = "description";
    private static final String CREATED_AT = "created_at";
    private static final String UPDATED_AT = "updated_at";

    public MyDBHelper(@Nullable Context context) {
        super(context, this.DATABASE_NAME, null, this.DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + this.TABLE_NAME + "("+ this.KEY_ID +" INTEGER PRIMARY KEY AUTOINCREMENT," +
                this.KEY_TITLE + " TEXT," +
                this.KEY_DESCRIPTION +" TEXT," +
                this.CREATED_AT + "TEXT," +
                this.UPDATED_AT + "TEXT)");

        SQLiteDatabase database = this.getWritableDatabase();

        database.close();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + this.TABLE_NAME);

        onCreate(db);
    }
}
