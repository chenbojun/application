package com.example.hzchenbojun.myapplication.presenter;

import com.example.hzchenbojun.myapplication.bean.Book;

/**
 * Created by hzchenbojun on 2016/3/11.
 */
public interface OnBookListener {
    public void onSuccess(Book book);
    void onError(String errorMsg);
}
