package com.example.hzchenbojun.myapplication.model;

import android.widget.ImageView;
import android.widget.TextView;

import com.example.hzchenbojun.myapplication.R;
import com.example.hzchenbojun.myapplication.bean.Book;
import com.example.hzchenbojun.myapplication.network.DemoApi;
import com.example.hzchenbojun.myapplication.presenter.OnBookListener;
import com.squareup.picasso.Picasso;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by hzchenbojun on 2016/3/10.
 */
public class UserModel {
    private DemoApi demoApi;
    private OnBookListener onBookListener;

    public UserModel(OnBookListener onBookListener){
        this.onBookListener = onBookListener;
        Retrofit retrofit = new Retrofit.Builder()
                .client(new OkHttpClient())
                .baseUrl("https://api.douban.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        demoApi = retrofit.create(DemoApi.class);
    }
    public void getBook(String id){
        if(isSave(id)){

        } else {
            Call<Book> call = demoApi.getResult(id);
            call.enqueue(new Callback<Book>() {
                @Override
                public void onResponse(Call<Book> call, Response<Book> response) {
                    Book book = response.body();
                    onBookListener.onSuccess(book);
                }
                @Override
                public void onFailure(Call<Book> call, Throwable t) {
                    onBookListener.onError("网络异常！");
                }
            });
        }
    }
    private boolean isSave(String id){
        return false;
    }

    private void save(Book book){

    }
}
