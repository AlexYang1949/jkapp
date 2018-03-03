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

    private final int TYPE_COUNT = 3;
    private final int TYPE_STEP =1;


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
        if (type==TYPE_STEP){
            view = inflater.inflate(R.layout.item_home_step, null);
            TextView finish = (TextView) view.findViewById(R.id.finish);
            finish.setText(String.valueOf(bean.getStep()));
        }
        return view;
    }

    @Override
    public int getViewTypeCount() {
        return TYPE_COUNT;
    }
}
