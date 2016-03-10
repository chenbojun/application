package com.example.hzchenbojun.myapplication.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.hzchenbojun.myapplication.R;
import com.example.hzchenbojun.myapplication.bean.Book;
import com.example.hzchenbojun.myapplication.presenter.BookManager;
import com.squareup.picasso.Picasso;

public class MainActivity extends AppCompatActivity implements IUserView{
    private EditText bookidTextView;
    private Button checkButton;
    private ImageView imageView;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();

    }

    private void initView() {
        bookidTextView = (EditText) findViewById(R.id.bookID);
        checkButton = (Button)findViewById(R.id.button);
        checkButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String bookID = bookidTextView.getText().toString();
                BookManager bookManager = BookManager.getInstance(MainActivity.this);
                bookManager.getBookById(bookID);
            }
        });
    }
    @Override
    public String getBookid(){
        return bookidTextView.getText().toString();
    }
    @Override
    public void  displayBook(Book book){
        if (book == null) {
            textView.setText("查询不到与此id对应的信息！");
        } else {
            Picasso.with(this).load(book.getImage()).into(imageView);
            textView.setText("书名：" + book.getTitle() +
                    "\n作者：" + book.getAuthor().toString() +
                    "\n出版社：" + book.getPublisher() +
                    "\n出版时间：" + book.getPubdate() +
                    "\n简介：" + book.getSummary()
            );
        }
    }


}
