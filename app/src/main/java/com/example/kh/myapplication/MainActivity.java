package com.example.kh.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void process(View view){
        if(view.getId()==R.id.btn){
            Fragment_AlertDialog dialog  = new Fragment_AlertDialog();
            dialog.show(getFragmentManager(), "dialog");
        }
        if(view.getId()==R.id.btncustom){
            Fragment_AlertDialog_Custom dialog_custom = new Fragment_AlertDialog_Custom();
            dialog_custom.show(getFragmentManager(), "customdialog");
        }

        if(view.getId()==R.id.btncustom1){
            Fragment_Dialog dialog_custom = new Fragment_Dialog();
          dialog_custom.show(getFragmentManager(),"a");
        }

    }
}
