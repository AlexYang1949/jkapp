package com.jk.wyq.jkapp.UserModule;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.jk.wyq.jkapp.BaseModule.DataManager;
import com.jk.wyq.jkapp.BaseModule.DbUtils;
import com.jk.wyq.jkapp.R;

import java.util.List;

public class PunchActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_punch);

        UserBean user = DataManager.currentUser(this);
        UserBean userupdate = new UserBean();
        int point = Integer.parseInt(user.getPoint())+10;
        userupdate.setPoint(point+"");
        DbUtils.update(userupdate);
    }
}
