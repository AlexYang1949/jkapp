package com.jk.wyq.jkapp.BaseModule;

/**
 * Created by yangzhaoheng on 2018/2/27.
 */

public class HomeBean {
    private int type;

    private int step;

    public HomeBean(int type,int step){
        this.type = type;
        this.step = step;
    }

    public int getType() {
        return type;
    }

    public int getStep() {
        return step;
    }
}
