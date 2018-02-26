package com.jk.wyq.jkapp.HealthModule;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.jk.wyq.jkapp.HeartBeatModule.HeartBeatActivity;
import com.jk.wyq.jkapp.R;

public class AdvanceHealthActivity extends AppCompatActivity {

    Button startBtn ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_advance_health);
        startBtn = findViewById(R.id.startBtn);
        startBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotoResult();
            }
        });
    }

    private void gotoResult(){
        Intent intent = new Intent(this, HealthResultActivity.class);
        startActivity(intent);
    }
}
