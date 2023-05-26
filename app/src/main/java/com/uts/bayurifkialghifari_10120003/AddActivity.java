/**
 *
 * Nama : Bayu Rifki Alghifari
 * Nim : 10120003
 * Kelas : IF 1
 * Email : Bayu Rifki Alghifari
 *
 */

package com.uts.bayurifkialghifari_10120003;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddActivity extends AppCompatActivity {

    EditText note_title, note_category, note_description;
    Button save_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        note_title = findViewById(R.id.note_title);
        note_category = findViewById(R.id.note_category);
        note_description = findViewById(R.id.note_description);
        save_btn = findViewById(R.id.save_btn);
        save_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyDBHelper db = new MyDBHelper(AddActivity.this);
                db.insertNote(
                        note_title.getText().toString(),
                        note_category.getText().toString(),
                        note_description.getText().toString());

                note_title.setText("");
                note_category.setText("");
                note_description.setText("");
            }
        });

    }
}