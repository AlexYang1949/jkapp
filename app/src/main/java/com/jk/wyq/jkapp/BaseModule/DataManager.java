package com.jk.wyq.jkapp.BaseModule;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;

import com.jk.wyq.jkapp.HealthModule.AdvanceHealthActivity;
import com.jk.wyq.jkapp.HealthModule.HealthBean;
import com.jk.wyq.jkapp.StepModule.step.bean.StepBean;
import com.jk.wyq.jkapp.UserModule.LoginActivity;
import com.jk.wyq.jkapp.UserModule.UserBean;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by yangzhaoheng on 2018/4/8.
 */

public class DataManager {

    public static String currentUserName(Context context){
        SharedPreferencesUtils sp = new SharedPreferencesUtils(context,"loginInfo");
        String current_name = (String) sp.getParam("name","");
        return current_name;
    }

    public static void saveCurrentUserName(Context context,String name){
        SharedPreferencesUtils sp = new SharedPreferencesUtils(context,"loginInfo");
        sp.setParam("name",name);
    }

    public static UserBean currentUser(Context context){
        String name = DataManager.currentUserName(context);
        List<UserBean> list = DbUtils.getQueryByWhere(UserBean.class,"name",new String[]{name});
        Log.i("list", list.toString());
        if (list.size() == 1) {
            return list.get(0);
        } else {
            UserBean user = new UserBean();
            user.setName(name);
            user.setPoint("0");
            return user;
        }
    }

    public static void saveCurrentUser(Context context,UserBean user){
        List<UserBean> list = DbUtils.getQueryByWhere(UserBean.class,"name",new String[]{user.name});
        Log.i("list", list.toString());
        if (list.size() == 1) {
            DbUtils.update(user);
        } else {
            user.setPoint("0");
            DbUtils.insert(user);
        }
    }

    public static StepBean currentStep(Context context){
        String name = DataManager.currentUserName(context);
        Date date = new Date(System.currentTimeMillis());
        String CURRENT_DATE = new SimpleDateFormat("yyyy-MM-dd").format(date);
        List<StepBean> list = DbUtils.getQueryByWhere2(StepBean.class,"name" ,"date", new String[]{name,CURRENT_DATE});
        if (list.size() == 1) {
            return list.get(0);
        }else {
            StepBean data = new StepBean();
            data.date = CURRENT_DATE;
            data.name = name;
            data.step = "0";
            DbUtils.insert(data);
            return data;
        }
    }

    public static void setCurrentStep(Context context,int tempStep){
        String name = DataManager.currentUserName(context);
        Date date = new Date(System.currentTimeMillis());
        String CURRENT_DATE = new SimpleDateFormat("yyyy-MM-dd").format(date);
        List<StepBean> list = DbUtils.getQueryByWhere2(StepBean.class,"name" ,"date", new String[]{name,CURRENT_DATE});
        if (list.size() == 0 || list.isEmpty()) {
            StepBean data = new StepBean();
            data.date = CURRENT_DATE;
            data.step = tempStep + "";
            data.name = name;
            DbUtils.insert(data);
        } else if (list.size() == 1) {
            StepBean data = list.get(0);
            data.step = tempStep + "";
            DbUtils.update(data);
        }
    }

    public static HealthBean healthBean(Context context){
        String name = DataManager.currentUserName(context);
        List<HealthBean> list = DbUtils.getQueryByWhere(HealthBean.class,"name",new String[]{name});
        if (list.size() == 1) {
            return list.get(0);
        } else {
            HealthBean health = new HealthBean();
            health.name = name;
            return health;
        }
    }

    public static void saveHealthBean(Context context,HealthBean health){
        String name = DataManager.currentUserName(context);
        List<HealthBean> list = DbUtils.getQueryByWhere(HealthBean.class,"name",new String[]{name});
        if (list.size() == 1) {
            DbUtils.update(health);
        } else {
            health.name = name;
            DbUtils.insert(health);
        }
    }




    public static boolean isLogin(Context context){
        boolean login = DataManager.currentUserName(context) != "";
        Log.i("isLogin:", DataManager.currentUserName(context));
        if (login) return true;
        Intent intent = new Intent(context, LoginActivity.class);
        context.startActivity(intent);
        return login;
    }

    public static int healthIndex(){
        return 0;
    }

    public static void closeKeyboard(Window window,InputMethodManager manager) {
        View view = window.peekDecorView();
        if (view != null) {
            manager.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }

    public static String currentDate(){
        Date date = new Date(System.currentTimeMillis());
        return new SimpleDateFormat("yyyy-MM-dd HH:mm").format(date);
    }
}
