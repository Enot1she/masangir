package com.example.masangir.ui.home;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProvider;

import com.example.masangir.Chat;
import com.example.masangir.Nav;
import com.example.masangir.R;
import com.example.masangir.databinding.FragmentHomeBinding;
import com.example.masangir.ui.MyDialogFragment;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import androidx.fragment.app.DialogFragment;

public class HomeFragment extends Fragment {

    private FloatingActionButton mFButton;
    private FragmentHomeBinding binding;
    private FragmentManager manager;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        HomeViewModel homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        mFButton = (FloatingActionButton) root.findViewById(R.id.floating_action_button);

        mFButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                builder.setTitle("Создание чата")
                        .setMessage("Покормите кота!")
                        .setPositiveButton("ОК, иду на кухню", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                // Закрываем диалоговое окно
                                Intent intent = new Intent(HomeFragment.this.getContext(), Chat.class);
                                startActivity(intent);
                            }
                        });

                builder.show();

            }
        });
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}