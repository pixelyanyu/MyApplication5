package com.example.lianxi5;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.example.lianxi5.Base.BaseActivity;
import com.example.lianxi5.bean.ListBean;
import com.example.lianxi5.mvp.IMainContract;
import com.example.lianxi5.mvp.IMainPresenterImpl;
import com.stx.xhb.xbanner.XBanner;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends BaseActivity implements IMainContract.IMainView {
    private IMainContract.IMainPresenter presenter;
    private ArrayList<ListBean> list;
    private ViewPager vp;
    private TabLayout tab;


    @Override
    public int getView() {
        return R.layout.activity_main;
    }

    @Override
    public void getById() {
        vp = findViewById(R.id.vp);
        tab = findViewById(R.id.tab);
        presenter=new IMainPresenterImpl();
        presenter.attach(this);
    }

    @Override
    public void getDate() {
        presenter.resultList("http://172.17.8.100/movieApi/cinema/v1/findRecommendCinemas?page=1&count=10");
    }

    @Override
    public void getEvent() {
        tab.addTab(tab.newTab().setText("首页"));
        tab.addTab(tab.newTab().setText("2页"));
        tab.addTab(tab.newTab().setText("3页"));
        tab.addTab(tab.newTab().setText("4页"));
        tab.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                vp.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        vp.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {

            }

            @Override
            public void onPageSelected(int i) {
                tab.setScrollPosition(vp.getCurrentItem(),0,false);
            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });
    }
    @Override
    public void showList(String url) {
        try {
            list = new ArrayList<>();
            JSONObject object = new JSONObject(url);
            JSONArray result = object.getJSONArray("result");
            for (int i = 0; i < result.length(); i++) {
                JSONObject o = (JSONObject) result.get(i);
                String logo    = o.getString("logo");
                String name    = o.getString("name");
                String address = o.getString("address");
                list.add(new ListBean(logo,name,address));

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.deache();
    }
}
