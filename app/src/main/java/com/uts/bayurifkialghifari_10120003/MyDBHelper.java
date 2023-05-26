/**
 *
 * Nama : Bayu Rifki Alghifari
 * Nim : 10120003
 * Kelas : IF 1
 * Email : Bayu Rifki Alghifari
 *
 */

package com.uts.bayurifkialghifari_10120003;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import androidx.annotation.Nullable;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class MyDBHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "uts";
    private static final int DATABASE_VERSION = 3;
    private static final String TABLE_NAME = "notes";
    private static final String KEY_ID = "id";
    private static final String KEY_TITLE = "title";
    private static final String KEY_DESCRIPTION = "description";
    private static final String CREATED_AT = "created_at";
    private static final String UPDATED_AT = "updated_at";

    public MyDBHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + TABLE_NAME + "("+ KEY_ID +" INTEGER PRIMARY KEY AUTOINCREMENT," +
                KEY_TITLE + " TEXT," +
                KEY_DESCRIPTION +" TEXT," +
                CREATED_AT + " datetime default current_timestamp," +
                UPDATED_AT + " datetime default current_timestamp)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);

        onCreate(db);
    }

    public void insertNote(String title, String description) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues val = new ContentValues();
        val.put(KEY_TITLE, title);
        val.put(KEY_DESCRIPTION, description);

        db.insert(TABLE_NAME, null, val);
    }

    public ArrayList<NoteModel> getNotes() {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_NAME, null);
        ArrayList<NoteModel> arrayList = new ArrayList<>();

        while (cursor.moveToNext()) {
            NoteModel notes = new NoteModel();
            notes.id = cursor.getInt(0);
            notes.title = cursor.getString(1);
            notes.description = cursor.getString(2);
            notes.created_at = cursor.getString(3);
            notes.updated_at = cursor.getString(4);

            arrayList.add(notes);
        }

        return arrayList;
        // MyDBHelper db = new MyDBHelper(this);
        // ArrayList<NoteModel> data = dbHelper.getNotes(); data.size();
    }

    public void updateNote(NoteModel note) {
        SQLiteDatabase db = this.getWritableDatabase();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date = sdf.format(new Date());

        ContentValues val = new ContentValues();
        val.put(KEY_TITLE, note.title);
        val.put(KEY_DESCRIPTION, note.description);
        val.put(UPDATED_AT, date);

        db.update(TABLE_NAME, val, KEY_ID + "=" + note.id, null);
        // NoteModel note = new NoteModel();
        // note.id = 1;
        // dbHelper.updateNote(note)
    }
}
