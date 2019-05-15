package com.example.lianxi5.mvp;

import com.example.lianxi5.net.HttpUtil;

/*
 *@Auther:田恒宇
 *@weichat: 15020451581
 *@Description:function
 */
public class IMainPresenterImpl implements IMainContract.IMainPresenter {
    private IMainContract.IMainModel model;
    private IMainContract.IMainView view;
    @Override
    public void attach(IMainContract.IMainView view) {
        this.view=view;
        model=new IMainModelImpl();
    }

    @Override
    public void deache() {
        if(view!=null){
            view=null;
        }
        if (model!=null) {
            model=null;
        }
    }


    @Override
    public void resultList(String url) {
        HttpUtil util = HttpUtil.getInstance();
        util.getASS("http://172.17.8.100/movieApi/cinema/v1/findRecommendCinemas?page=1&count=10", new HttpUtil.getAS() {
            @Override
            public void getS(String s) {
                view.showList(s);
            }
        });
    }
}
