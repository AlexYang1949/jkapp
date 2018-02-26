package com.jk.wyq.jkapp.HealthModule;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;

import com.jk.wyq.jkapp.R;
public class BaseHealthActivity extends AppCompatActivity {

    TextView resultView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base_health);
        resultView = findViewById(R.id.result);

    }

    public void test(View view){

        EditText editText1 =(EditText) findViewById (R.id.height);
        if (editText1.getText().toString() == ""){
            return;
        }
        Integer height = Integer.parseInt(editText1.getText().toString());
        EditText editText2 =(EditText) findViewById (R.id.weight);
        Integer weight = Integer.parseInt(editText2.getText().toString());
        EditText editText3 =(EditText) findViewById (R.id.age);
        Integer age = Integer.parseInt(editText3.getText().toString());

        float result = weight*10000/height/height;
        String resultStr = "";
        String bmi = String.valueOf(result);
        if (result<18.5){
            resultStr = "BMI值为:"+bmi+"    体重过低";
        }else if (result>=18.5&&result<24.9){
            resultStr = "BMI值为:"+bmi+"    正常范围";
        }else {
            resultStr = "BMI值为:"+bmi+"    超重";
        }
        resultView.setText(resultStr);
        closeKeyboard();
    }

    private void closeKeyboard() {
        View view = getWindow().peekDecorView();
        if (view != null) {
            InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }

}
