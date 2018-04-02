package com.jk.wyq.jkapp.BaseModule;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.jk.wyq.jkapp.R;


import java.util.List;

/**
 * Created by yangzhaoheng on 2018/2/27.
 */

public class HomeAdapter extends BaseAdapter {
    private List<HomeBean> dataList;
    private Context context;
    private LayoutInflater inflater;


    public final int TYPE_STEP = 1; // 步数
    public final int TYPE_WEATHER = 2; // 天气
    public final int TYPE_HEALTH = 3; // 健康
    public final int TYPE_TIME = 4; // 定时
    private final int TYPE_COUNT = 4; // 总个数

    public HomeAdapter(Context context,List dataList){
        this.context = context;
        this.dataList = dataList;
        inflater = LayoutInflater.from(context);
    }
    @Override
    public int getCount() {
        return dataList.size();
    }

    @Override
    public Object getItem(int i) {
        return dataList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        HomeBean bean = dataList.get(i);
        int type = bean.getType();

        if (type==TYPE_WEATHER){
            view = inflater.inflate(R.layout.item_home_weather, null);
        }else if (type==TYPE_STEP){
            view = inflater.inflate(R.layout.item_home_step, null);
            TextView finish = (TextView) view.findViewById(R.id.finish);
            finish.setText(bean.getStep()==0?"0":String.valueOf(bean.getStep()));
        }else if(type==TYPE_TIME){
            view = inflater.inflate(R.layout.item_home_time, null);
            TextView txt_tip = (TextView) view.findViewById(R.id.txt_tip);
            txt_tip.setText(bean.getTip());
            TextView txt_time = (TextView) view.findViewById(R.id.txt_time);
            txt_time.setText(bean.getTime());
        }else if(type==TYPE_HEALTH) {
            view = inflater.inflate(R.layout.item_home_health, null);
        }
        return view;
    }

    @Override
    public int getViewTypeCount() {
        return TYPE_COUNT;
    }
}
