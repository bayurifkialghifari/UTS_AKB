/**
 *
 * Nama : Bayu Rifki Alghifari
 * Nim : 10120003
 * Kelas : IF 1
 * Email : Bayu Rifki Alghifari
 *
 */

package com.uts.bayurifkialghifari_10120003.ui.information;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.uts.bayurifkialghifari_10120003.databinding.FragmentInformationBinding;

public class InformationsFragment extends Fragment {

    private FragmentInformationBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        InformationsViewModel ViewModel =
                new ViewModelProvider(this).get(InformationsViewModel.class);

        binding = FragmentInformationBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}