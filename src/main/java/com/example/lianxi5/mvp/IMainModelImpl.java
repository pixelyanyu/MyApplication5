package com.example.lianxi5.mvp;

import com.example.lianxi5.net.HttpUtil;

/*
 *@Auther:田恒宇
 *@weichat: 15020451581
 *@Description:function
 */
public class IMainModelImpl implements IMainContract.IMainModel {
    private HttpUtil util;
    public IMainModelImpl(){
        util=HttpUtil.getInstance();
    }
    @Override
    public void resultList(String url, HttpUtil.getAS as) {
        util.getASS(url,as);
    }
}
