/**
 *
 * Nama : Bayu Rifki Alghifari
 * Nim : 10120003
 * Kelas : IF 1
 * Email : Bayu Rifki Alghifari
 *
 */

package com.uts.bayurifkialghifari_10120003.ui.notes;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.uts.bayurifkialghifari_10120003.AddActivity;
import com.uts.bayurifkialghifari_10120003.MyDBHelper;
import com.uts.bayurifkialghifari_10120003.NoteModel;
import com.uts.bayurifkialghifari_10120003.CustomNotesAdapter;
import com.uts.bayurifkialghifari_10120003.R;
import com.uts.bayurifkialghifari_10120003.databinding.FragmentNotesBinding;
import java.util.ArrayList;

public class NotesFragment extends Fragment {

    private FragmentNotesBinding binding;
    RecyclerView recyclerView;
    FloatingActionButton add_button;
    CustomNotesAdapter customNotesAdapter;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        NotesViewModel ViewModel =
                new ViewModelProvider(this).get(NotesViewModel.class);

        binding = FragmentNotesBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        recyclerView = root.findViewById(R.id.recycleNote);
        add_button = root.findViewById(R.id.add_button);
        add_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), AddActivity.class);
                startActivity(intent);
            }
        });

        MyDBHelper db = new MyDBHelper(getActivity());
        ArrayList<NoteModel> data = db.getNotes();

        customNotesAdapter = new CustomNotesAdapter(getActivity(), data);
        recyclerView.setAdapter(customNotesAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}