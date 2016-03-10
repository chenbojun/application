package com.example.hzchenbojun.myapplication.Network;

import com.example.hzchenbojun.myapplication.Models.Book;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by hzchenbojun on 2016/3/9.
 */
public interface DemoApi {
    @GET("/v2/book/{book_id}")
    Call<Book> getResult(@Path("book_id") String book_id);
}
