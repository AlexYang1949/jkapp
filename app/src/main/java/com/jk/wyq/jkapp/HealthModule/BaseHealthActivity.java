package com.jk.wyq.jkapp.HealthModule;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.jk.wyq.jkapp.R;
public class BaseHealthActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base_health);
    }
}
