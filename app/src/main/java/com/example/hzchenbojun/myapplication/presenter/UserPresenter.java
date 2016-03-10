package com.example.hzchenbojun.myapplication.presenter;

import com.example.hzchenbojun.myapplication.bean.Book;
import com.example.hzchenbojun.myapplication.model.IUserModel;
import com.example.hzchenbojun.myapplication.view.IUserView;

/**
 * Created by hzchenbojun on 2016/3/10.
 */
public class UserPresenter {
    private IUserView mUserView;
    private IUserModel mUserModel;
    public UserPresenter(IUserView view){
        mUserView = view;
        mUserModel = new IUserModel();
    }
    public void loadBook(){
        String id = mUserView.getBookid();
        Book book = mUserModel.getBook(id);
        mUserView.displayBook(book);
    }
}
