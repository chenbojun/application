package com.example.hzchenbojun.myapplication;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.hzchenbojun.myapplication.ViewModel.BookManager;
import com.example.hzchenbojun.myapplication.databinding.TestBinding;

public class MainActivity extends AppCompatActivity {
    private EditText bookidTextView;
    private Button checkButton;

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

}
