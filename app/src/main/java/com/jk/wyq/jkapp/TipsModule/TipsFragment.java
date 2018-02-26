package com.jk.wyq.jkapp.TipsModule;


import android.content.res.AssetManager;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.JsonReader;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jk.wyq.jkapp.R;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * A simple {@link Fragment} subclass.
 */
public class TipsFragment extends Fragment {


    public TipsFragment() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        readTipsJson();
        return inflater.inflate(R.layout.fragment_tips, container, false);
    }

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
            return new JSONArray(jObject.getString("data"));

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
