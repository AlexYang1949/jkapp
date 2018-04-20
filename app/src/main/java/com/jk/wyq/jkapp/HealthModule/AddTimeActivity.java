package com.jk.wyq.jkapp.HealthModule;

import android.app.Activity;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.jk.wyq.jkapp.BaseModule.DataManager;
import com.jk.wyq.jkapp.BaseModule.NotificationManager;
import com.jk.wyq.jkapp.R;
import com.jk.wyq.jkapp.UserModule.UserBean;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class AddTimeActivity extends Activity {

    EditText txt_name;
    EditText txt_time;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_time);
        txt_name = findViewById(R.id.name);
        txt_time = findViewById(R.id.time);
    }

    public void save(View view){
        if (txt_name.getText().toString() == ""
                ||txt_time.getText().toString() == ""){
            Toast.makeText(this,"请输入信息后重试",Toast.LENGTH_LONG).show();
            return;
        }
        TimeBean time = new TimeBean();
        time.tip  = txt_name.getText().toString();
        time.time = txt_time.getText().toString();
        DataManager.saveTimeBean(this,time);

        NotificationManager.addAlert(this,"111",time.tip);
        Toast.makeText(this,"保存成功！奖励10积分！",Toast.LENGTH_LONG).show();
        UserBean user = DataManager.currentUser(this);
        int point = Integer.parseInt(user.point)+10;
        user.point = point+"";
        DataManager.saveCurrentUser(this,user);
    }
}
