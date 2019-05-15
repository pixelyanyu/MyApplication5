package com.example.lianxi5.mvp;

import com.example.lianxi5.net.HttpUtil;

/*
 *@Auther:田恒宇
 *@weichat: 15020451581
 *@Description:function
 */
public interface IMainContract {
    public interface IMainModel {
        void resultList(String url, HttpUtil.getAS as);
    }
    public interface IMainView {
        void showList(String url);
    }
    public interface IMainPresenter {
        void attach(IMainView view);
        void deache();
        void resultList(String url);
    }
}
