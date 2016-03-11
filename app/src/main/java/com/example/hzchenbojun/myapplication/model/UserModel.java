package com.example.hzchenbojun.myapplication.model;

import android.widget.Toast;

import com.example.hzchenbojun.myapplication.bean.Book;
import com.example.hzchenbojun.myapplication.network.DemoApi;
import com.example.hzchenbojun.myapplication.presenter.OnBookListener;
import com.example.hzchenbojun.myapplication.simplecache.ACache;
import com.example.hzchenbojun.myapplication.util.ContextUtil;

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
            ACache mCache = ACache.get(ContextUtil.getInstance());
            Book book = (Book) mCache.getAsObject(id);
            onBookListener.onSuccess(book);
        } else {
            Call<Book> call = demoApi.getResult(id);
            call.enqueue(new Callback<Book>() {
                @Override
                public void onResponse(Call<Book> call, Response<Book> response) {
                    Book book = response.body();
                    save(book);
                    onBookListener.onSuccess(book);
                }
                @Override
                public void onFailure(Call<Book> call, Throwable t) {
                    onBookListener.onError("网络异常！");
                }
            });
        }
    }

    //判断对应id的book信息是否在缓存中
    private boolean isSave(String id){
        ACache mCache = ACache.get(ContextUtil.getInstance());
        Book book = (Book) mCache.getAsObject(id);
        if(book == null){
            return false;
        } else {
            return true;
        }
    }

   //保存book到缓存中（缓存时间=1hour）
    private void save(Book book){
        ACache mCache = ACache.get(ContextUtil.getInstance());
        mCache.put(book.getId(),book,ACache.TIME_HOUR);
    }
}
