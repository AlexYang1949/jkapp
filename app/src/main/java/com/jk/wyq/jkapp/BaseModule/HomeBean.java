package com.jk.wyq.jkapp.BaseModule;

/**
 * Created by yangzhaoheng on 2018/2/27.
 */

public class HomeBean {
    private int type;

    private int step;

    private String tip;

    private String time;

    public HomeBean(int type,int step){
        this.type = type;
        this.step = step;
    }

    public HomeBean(int type,String tip,String time){
        this.type = type;
        this.tip = tip;
        this.time = time;
    }


    public int getType() {
        return type;
    }

    public int getStep() {
        return step;
    }

    public String getTime() {
        return time;
    }

    public String getTip() {
        return tip;
    }
}
