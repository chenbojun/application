package com.example.hzchenbojun.myapplication.ViewModel;

import android.app.Activity;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.hzchenbojun.myapplication.Models.Book;
import com.example.hzchenbojun.myapplication.Network.DemoApi;
import com.example.hzchenbojun.myapplication.R;
import com.example.hzchenbojun.myapplication.Util.NetUtil;
import com.squareup.picasso.Picasso;

import java.io.File;
import java.io.IOException;

import okhttp3.Cache;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by hzchenbojun on 2016/3/9.
 */
public class BookManager {
    private static BookManager instance;
    private static Activity activity;
    private DemoApi demoApi;

    public BookManager(Activity activity) {
        this.activity = activity;
        init();
    }

    public static BookManager getInstance(Activity activity) {
        if (instance == null) {
            instance = new BookManager(activity);
        }
        return instance;
    }

    public void getBookById(String book_id) {
        ImageView imageView = (ImageView)activity.findViewById(R.id.imageView);
        imageView.setImageBitmap(null);
        Call<Book> call = demoApi.getResult(book_id);
        call.enqueue(new Callback<Book>() {
            @Override
            public void onResponse(Call<Book> call, Response<Book> response) {
                Book book = response.body();
                TextView textView = (TextView) activity.findViewById(R.id.textview);
                ImageView imageView = (ImageView) activity.findViewById(R.id.imageView);
                if (book == null) {
                    textView.setText("查询不到与此id对应的信息！");
                } else {
                    Picasso.with(activity).load(book.getImage()).into(imageView);
                    textView.setText("书名：" + book.getTitle() +
                            "\n作者：" + book.getAuthor().toString() +
                            "\n出版社：" + book.getPublisher() +
                            "\n出版时间：" + book.getPubdate() +
                            "\n简介：" + book.getSummary()
                    );
                }
            }

            @Override
            public void onFailure(Call<Book> call, Throwable t) {
                TextView textView = (TextView) activity.findViewById(R.id.textview);
                textView.setText("网络问题");
            }
        });
    }

    private void init() {
        // Create Interceptor
        Interceptor REWRITE_CACHE_CONTROL_INTERCEPTOR = new Interceptor() {
            @Override
            public okhttp3.Response intercept(Chain chain) throws IOException {
                okhttp3.Response originalResponse = chain.proceed(chain.request());
                if (NetUtil.isNetworkReachable(activity)) {
                    int maxAge = 60; // 在线缓存在1分钟内可读取
                    return originalResponse.newBuilder()
                            .header("Cache-Control", "public, max-age=" + maxAge)
                            .build();
                } else {
                    int maxStale = 60 * 60 * 24 * 28; // 离线时缓存保存4周
                    return originalResponse.newBuilder()
                            .header("Cache-Control", "public, only-if-cached, max-stale=" + maxStale)
                            .build();
                }
            }
        };

        //setup cache
        File httpCacheDirectory = new File(activity.getCacheDir(), "responses");
        int cacheSize = 10 * 1024 * 1024;
        Cache cache = new Cache(httpCacheDirectory, cacheSize);
        //Setup client
        OkHttpClient client = new OkHttpClient();
        //client.newBuilder().cache(cache);
        //client.networkInterceptors().add(REWRITE_CACHE_CONTROL_INTERCEPTOR);

        Retrofit retrofit = new Retrofit.Builder()
                .client(client)
                .baseUrl("https://api.douban.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        demoApi = retrofit.create(DemoApi.class);
    }


}