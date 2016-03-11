package com.example.hzchenbojun.myapplication.view;

import com.example.hzchenbojun.myapplication.bean.Book;

/**
 * Created by hzchenbojun on 2016/3/10.
 */
public interface IUserView {
    public String getBookid();
    public void displayBook(Book book);
    public void displayError(String errorMsg);
}
