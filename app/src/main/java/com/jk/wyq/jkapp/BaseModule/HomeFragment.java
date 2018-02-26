package com.jk.wyq.jkapp.BaseModule;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.jk.wyq.jkapp.HealthModule.HealthSelectActivity;
import com.jk.wyq.jkapp.HeartBeatModule.HeartBeatActivity;
import com.jk.wyq.jkapp.R;
import com.jk.wyq.jkapp.StepModule.activity.StepActivity;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {

    private Button hbBtn;
    private Button stepBtn;
    private Button jkBtn;

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
        return view;
    }


    // 跳转心跳activity
    private void gotoHeartBeatAct(){
        Intent intent = new Intent(getActivity(), HeartBeatActivity.class);
        startActivity(intent);
    }

    // 跳转记步activity
    private  void gotoStepAct(){
        Intent intent = new Intent(getActivity(), StepActivity.class);
        startActivity(intent);
    }
    // 跳转健康测试activity
    private  void gotoJKTest(){
        Intent intent = new Intent(getActivity(), HealthSelectActivity.class);
        startActivity(intent);
    }

}
