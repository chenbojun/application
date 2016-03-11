package com.example.hzchenbojun.myapplication.util;

/**
 * Created by hzchenbojun on 2016/3/11.
 */
import android.app.Application;

public class ContextUtil extends Application {
    private static ContextUtil instance;

    public static ContextUtil getInstance() {
        return instance;
    }

    @Override
    public void onCreate() {
        // TODO Auto-generated method stub
        super.onCreate();
        instance = this;
    }
}
