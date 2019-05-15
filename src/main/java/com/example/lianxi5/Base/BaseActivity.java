package com.example.lianxi5.Base;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.lianxi5.R;

/*
 *@Auther:田恒宇
 *@weichat: 15020451581
 *@Description:function
 */
public abstract class BaseActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getView());

        getById();
        getDate();
        getEvent();
    }
    public abstract int getView();

    public abstract void getById();

    public abstract void getDate();

    public abstract void getEvent();
}
