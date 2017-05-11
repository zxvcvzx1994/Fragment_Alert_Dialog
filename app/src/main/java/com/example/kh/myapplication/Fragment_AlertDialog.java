package com.example.kh.myapplication;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.SpannableString;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by kh on 5/11/2017.
 */

public class Fragment_AlertDialog extends DialogFragment {
    String a[];
    ListView list;
    ArrayList<String> data ;
    boolean [] selected = new boolean[]{false,false,true,false,true,true};
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder  = new AlertDialog.Builder(getActivity());
        builder.setTitle("Notice");

        a= getResources().getStringArray(R.array.demo);
//        builder.setItems(R.array.demo, new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialog, int which) {
//                Toast.makeText(getActivity(), a[which], Toast.LENGTH_SHORT).show();
//            }
//        });

        builder.setMultiChoiceItems(R.array.demo,selected, new DialogInterface.OnMultiChoiceClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                 list  = ((AlertDialog) dialog).getListView();
                data = new ArrayList<String>();




                if(a[which].equals("Check All"))
                 for(int i=0; i<= list.getCount()-1;i++){
                     selected[i] = isChecked;
                     list.setItemChecked(i, isChecked);
                 }



                  for(int i = 0; i<= selected.length-1; i++) {
                      if (selected[i] == true) {
                          if(!a[i].equals("Check All"))
                          data.add(a[i]);
                      }
                  }

                StringBuffer string  =new StringBuffer();
                for(String s: data){
                    string.append(s +"\n");
                }

                String a = string.toString();
                Typeface typeface =  Typeface.createFromAsset(getActivity().getAssets(),"fonts/GoldfingerKingdom.ttf");
                Paint paint = new Paint();
                paint.setTypeface(typeface);
                SpannableString s = new SpannableString(a);
                Toast.makeText(getActivity(), a, Toast.LENGTH_SHORT).show();
            }
        });
        builder.setNegativeButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getActivity(), "yes", Toast.LENGTH_SHORT).show();
            }
        });
        builder.setPositiveButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getActivity(), "no", Toast.LENGTH_SHORT).show();
            }
        });
        Dialog dialog= builder.create();

        return dialog;
    }
}
