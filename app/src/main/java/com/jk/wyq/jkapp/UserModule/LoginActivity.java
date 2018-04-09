package com.jk.wyq.jkapp.UserModule;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.jk.wyq.jkapp.BaseModule.DataManager;
import com.jk.wyq.jkapp.BaseModule.DbUtils;
import com.jk.wyq.jkapp.BaseModule.SharedPreferencesUtils;
import com.jk.wyq.jkapp.R;
import com.jk.wyq.jkapp.StepModule.step.bean.StepBean;
import com.litesuits.orm.LiteOrm;

import org.w3c.dom.Text;

import java.util.List;

public class LoginActivity extends AppCompatActivity {
    private EditText accountTxt;
    private EditText pwdTxt;
    private Button loginButton;

    private TextView txt_info;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        accountTxt = (EditText) findViewById(R.id.etxt_account);
        pwdTxt = findViewById(R.id.etxt_pwd);
        loginButton = findViewById(R.id.login);
    }

    public void login(View view){
        if (accountTxt.getText().length()==0||pwdTxt.getText().length()==0){
            Toast.makeText(this,"重新输入",Toast.LENGTH_LONG).show();
            return;
        }
        String name = accountTxt.getText().toString();
        DataManager.saveCurrentUserName(this,name);
        UserBean user = new UserBean();
        user.setName(name);
        user.setPoint("60");
        DataManager.saveCurrentUser(this,user);
        UserBean lg = DataManager.currentUser(this);
        Log.i("login", lg.toString());
        finish();
    }
}
