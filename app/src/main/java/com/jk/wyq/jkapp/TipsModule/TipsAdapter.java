package com.jk.wyq.jkapp.TipsModule;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.jk.wyq.jkapp.R;

import org.json.JSONArray;
import org.json.JSONObject;

/**
 * Created by yangzhaoheng on 2018/4/1.
 */

public class TipsAdapter extends BaseAdapter{
    private JSONArray tipsArray;
    private Context mContext;

    public TipsAdapter(JSONArray tipsArray,Context context){
        this.tipsArray = tipsArray;
        this.mContext = context;
    }

    @Override
    public int getCount() {
        return tipsArray.length();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = LayoutInflater.from(mContext).inflate(R.layout.item_tips,null);
        TextView txt_title = view.findViewById(R.id.title);
        TextView txt_content = view.findViewById(R.id.content);
        try {
            JSONObject tip = (JSONObject)tipsArray.get(i);
            txt_content.setText(tip.getString("content"));
            txt_title.setText(tip.getString("title"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return view;
    }
}
