package com.example.andrei.eventdrivenprogramming_lab4;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private Button basicBtn, normalBtn, advancedBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        basicBtn=(Button)findViewById(R.id.btn_basic);
        normalBtn=(Button)findViewById(R.id.btn_normal);
        advancedBtn=(Button)findViewById(R.id.btn_advanced);

        basicBtn.setOnClickListener(this);
        normalBtn.setOnClickListener(this);
        advancedBtn.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        Intent intent;
        switch (v.getId()){
            case R.id.btn_basic:
                intent=new Intent(this,StageActivity.class);
                intent.putExtra("LEVEL",1);
                startActivity(intent);

        }
    }
}
