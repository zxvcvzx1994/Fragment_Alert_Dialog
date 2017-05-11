package com.example.kh.myapplication;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

/**
 * Created by kh on 5/11/2017.
 */

public class Fragment_AlertDialog_Custom extends DialogFragment {
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder  =new AlertDialog.Builder(getActivity());
        View view  = getActivity().getLayoutInflater().inflate(R.layout.fragment_alertdialog_custom,null);
        builder.setView(view);
        builder.setNegativeButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getActivity(), "yes", Toast.LENGTH_SHORT).show();
            }
        });
        builder.setPositiveButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getActivity(), "No", Toast.LENGTH_SHORT).show();
            }
        });
        Dialog dialog= builder.create();
        return dialog;
    }
}
