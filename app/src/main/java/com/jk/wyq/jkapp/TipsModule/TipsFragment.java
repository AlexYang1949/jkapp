package com.jk.wyq.jkapp.TipsModule;


import android.content.Intent;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.JsonReader;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.jk.wyq.jkapp.BaseModule.WebActivity;
import com.jk.wyq.jkapp.R;

import org.json.JSONArray;
import org.json.JSONObject;
import org.w3c.dom.Text;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class TipsFragment extends Fragment {
    public ListView listView;
    public JSONArray jsonArray;
    public TipsFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        jsonArray = readTipsJson();

        View view = inflater.inflate(R.layout.fragment_tips, container, false);
        listView = view.findViewById(R.id.listView);
        TipsAdapter adapter = new TipsAdapter(jsonArray,this.getContext());
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position,
                                    long id) {
                try {
                    JSONObject tip = (JSONObject)jsonArray.get(position);
                    String url = tip.getString("url");
                    Intent intent=new Intent(getActivity(), WebActivity.class);
                    intent.putExtra("url", url);
                    startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        return view;
    }

    // 读取json文件
    private JSONArray readTipsJson(){
        StringBuilder sb = new StringBuilder();
        AssetManager am = this.getContext().getAssets();
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(
                    am.open("tips.json")));
            String next = "";
            while (null != (next = br.readLine())) {
                sb.append(next);
            }
        } catch (IOException e) {
            e.printStackTrace();
            sb.delete(0, sb.length());
        }
        try {
            JSONObject jObject = new JSONObject(sb.toString());
            JSONArray jsona =  new JSONArray(jObject.getString("data"));
            return jsona;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
