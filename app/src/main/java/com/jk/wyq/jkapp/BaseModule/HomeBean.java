package com.jk.wyq.jkapp.BaseModule;

/**
 * Created by wangyuqi on 2018/2/27.
 */

public class HomeBean {
    public int type;

    public String plan;

    public String step;

    public String tip;

    public String time;

    public String bmi;

    public String date;

    public HomeBean(int type){
        this.type = type;
    }

    public HomeBean(int type,String tip,String time){
        this.type = type;
        this.tip = tip;
        this.time = time;
    }
}
