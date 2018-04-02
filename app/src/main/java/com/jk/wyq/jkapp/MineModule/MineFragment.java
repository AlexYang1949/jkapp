package com.jk.wyq.jkapp.MineModule;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.jk.wyq.jkapp.BaseModule.WebActivity;
import com.jk.wyq.jkapp.HealthModule.HealthSelectActivity;
import com.jk.wyq.jkapp.R;
import com.jk.wyq.jkapp.StepModule.activity.StepActivity;
import com.jk.wyq.jkapp.UserModule.PunchActivity;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class MineFragment extends Fragment {

    ListView listView;
    private String[] mListStr = {"打卡记录","测试历史","今日运动","健康商城","退出登录"};
    public MineFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_mine, container, false);
        listView =  view.findViewById(R.id.listView);
        listView.setAdapter(new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_list_item_activated_1, mListStr));
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position,
                                    long id) {
                if (position==3){
                    Intent intent=new Intent(getActivity(), WebActivity.class);
                    intent.putExtra("url", "http://www.39.net");
                    startActivity(intent);
                }else if(position==2){
                    Intent intent=new Intent(getActivity(), StepActivity.class);
                    startActivity(intent);
                }else if (position==0){
                    Intent intent=new Intent(getActivity(), PunchActivity.class);
                    startActivity(intent);
                }else if (position==1){
                    Intent intent=new Intent(getActivity(), HealthSelectActivity.class);
                    startActivity(intent);
                }
            }
        });
        return view;
    }


}
