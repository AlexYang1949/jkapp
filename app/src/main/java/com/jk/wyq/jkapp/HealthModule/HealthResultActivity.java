package com.jk.wyq.jkapp.HealthModule;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.jk.wyq.jkapp.BaseModule.DataManager;
import com.jk.wyq.jkapp.R;
import com.jk.wyq.jkapp.UserModule.DatePicker.DatePickerView;
import com.litesuits.orm.db.annotation.Mapping;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HealthResultActivity extends AppCompatActivity {

    private ListView listView;
    private List<Map<String, String>> list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_health_result);
        listView = findViewById(R.id.health_list);
        list = new ArrayList<Map<String, String>>();
//        String name[] = {"用户名", "年龄", "身高", "体重", "BMI", "血压", "血糖", "血糖"};
        HealthBean health = DataManager.healthBean(this);
        addToList("用户名",health.name);
        addToList("年龄",health.age);
        addToList("身高",health.height==null?"未录入":health.height);
        addToList("体重",health.weight);
        addToList("BMI",health.bmi);
        addToList("血压",health.presslow+"/"+health.presshigh);
        addToList("血糖",health.bloodsugar);
//        addToList("心跳",health.sd);
        String[] from = {"title","value"};
        Log.i("list", list.toString());
        int[] to = {R.id.tv_name,R.id.tv_result};
        SimpleAdapter adapter = new SimpleAdapter(this,list,R.layout.item_health_result,from,to);
        listView.setAdapter(adapter);

    }

    private void addToList(String title,String value){
        Map<String,String> map = new HashMap<String,String>();
        map.put("title",title);
        map.put("value",value);
        list.add(map);
    }

}
