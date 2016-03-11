package com.example.hzchenbojun.myapplication.presenter;

import com.example.hzchenbojun.myapplication.bean.Book;
import com.example.hzchenbojun.myapplication.model.UserModel;
import com.example.hzchenbojun.myapplication.view.IUserView;

/**
 * Created by hzchenbojun on 2016/3/10.
 */
public class UserPresenter implements OnBookListener{
    private IUserView mUserView;
    private UserModel mUserModel;
    public UserPresenter(IUserView view){
        mUserView = view;
        mUserModel = new UserModel(this);
    }
    public void loadBook(){
        String id = mUserView.getBookid();
        mUserModel.getBook(id);
    }

    @Override
    public void onSuccess(Book book) {
        mUserView.displayBook(book);
    }

    @Override
    public void onError(String errorMsg) {
        mUserView.displayError(errorMsg);
    }
}
