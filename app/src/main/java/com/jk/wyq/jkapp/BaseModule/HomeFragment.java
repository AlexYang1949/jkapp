package com.jk.wyq.jkapp.BaseModule;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.jk.wyq.jkapp.HealthModule.HealthSelectActivity;
import com.jk.wyq.jkapp.HeartBeatModule.HeartBeatActivity;
import com.jk.wyq.jkapp.R;
import com.jk.wyq.jkapp.StepModule.activity.StepActivity;

import org.json.JSONException;
import org.json.JSONObject;

import com.jk.wyq.jkapp.BaseModule.HomeAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {

    private Button hbBtn;
    private Button stepBtn;
    private Button jkBtn;
    public Button loginBtn;
    private ArrayList<HomeBean> dataList;

    private ListView listView;
    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        hbBtn = (Button)view.findViewById(R.id.heartBeat);
        hbBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotoHeartBeatAct();
            }
        });

        stepBtn = (Button)view.findViewById(R.id.step);
        stepBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotoStepAct();
            }
        });

        jkBtn = (Button)view.findViewById(R.id.jktest);
        jkBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotoJKTest();
            }
        });

        loginBtn = (Button)view.findViewById(R.id.loginBtn);
        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login();
            }
        });
        listView = (ListView)view.findViewById(R.id.listView);
        return view;
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
    }

    @Override
    public void onStart() {

        super.onStart();
    }

    public void initData(){
        dataList = new ArrayList<>();
        HomeBean home1 = new HomeBean(HomeAdapter.TYPE_STEP);
        home1.step = DataManager.currentStep(getContext()).step;
        HomeBean home2 = new HomeBean(HomeAdapter.TYPE_HEALTH);
        home2.bmi = DataManager.healthBean(getContext()).bmi;
        home2.date = DataManager.healthBean(getContext()).date;
        HomeBean home3 = new HomeBean(HomeAdapter.TYPE_WEATHER);

        HomeBean home4 = new HomeBean(HomeAdapter.TYPE_TIME,"睡觉","22:00");
        HomeBean home5 = new HomeBean(HomeAdapter.TYPE_TIME,"喝水","19:00");
        dataList.add(home1);
        dataList.add(home2);
        dataList.add(home3);
        dataList.add(home4);
        dataList.add(home5);
        HomeAdapter adapter = new HomeAdapter(getActivity(), dataList);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position,
                                    long id) {
                if(dataList.get(position).type==HomeAdapter.TYPE_HEALTH){
                    gotoJKTest();
                }else if(dataList.get(position).type==HomeAdapter.TYPE_STEP){
                    gotoStepAct();
                }
//                Toast.makeText(getContext(),"您选择了" + dataList.get(position), Toast.LENGTH_LONG).show();
            }
        });
    }

    // 跳转心跳activity
    private void gotoHeartBeatAct(){
        Intent intent = new Intent(getActivity(), HeartBeatActivity.class);
        startActivity(intent);
    }

    // 跳转记步activity
    private  void gotoStepAct(){
        if(!DataManager.isLogin(getActivity())) return;
        Intent intent = new Intent(getActivity(), StepActivity.class);
        startActivity(intent);
    }
    // 跳转健康测试activity
    private  void gotoJKTest(){
        if(!DataManager.isLogin(getActivity())) return;
        Intent intent = new Intent(getActivity(), HealthSelectActivity.class);
        startActivity(intent);
    }

    public void login(){
        DataManager.isLogin(getActivity());
    }


}
