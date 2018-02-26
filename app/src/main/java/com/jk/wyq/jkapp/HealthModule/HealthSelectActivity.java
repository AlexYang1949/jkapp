package com.jk.wyq.jkapp.HealthModule;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.jk.wyq.jkapp.R;
public class HealthSelectActivity extends AppCompatActivity {

    Button baseBtn ;
    Button advanceBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_health_select);
        baseBtn = findViewById(R.id.baseBtn);
        baseBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotoBaseHealth();
            }
        });

        advanceBtn = findViewById(R.id.advanceBtn);
        advanceBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotoAdvance();
            }
        });
    }

    private void gotoBaseHealth(){
        Intent intent = new Intent(this, BaseHealthActivity.class);
        startActivity(intent);
    }

    private void gotoAdvance(){
        Intent intent = new Intent(this, AdvanceHealthActivity.class);
        startActivity(intent);
    }
}
