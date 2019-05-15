package com.example.lianxi5.net;

import android.os.AsyncTask;
import android.support.v4.widget.DrawerLayout;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/*
 *@Auther:田恒宇
 *@weichat: 15020451581
 *@Description:function
 */
public class HttpUtil {
    private static HttpUtil util=new HttpUtil();
    private HttpUtil(){

    }
    public static HttpUtil getInstance(){
        return util;
    }
    public String getString(String surl){
        try {
            URL url = new URL(surl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setReadTimeout(5000);
            connection.setConnectTimeout(5000);
            if (connection.getResponseCode()==200) {
                BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                StringBuffer buffer = new StringBuffer();
                String str="";
                while ((str=reader.readLine())!=null){
                    buffer.append(str);
                    reader.close();
                    connection.disconnect();
                    return buffer.toString();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    public interface getAS{
        void getS(String s);
    }
    public void getASS(String surl, final getAS as){
        new AsyncTask<String, Integer, String>() {
            @Override
            protected String doInBackground(String... strings) {
                return getString(strings[0]);
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                as.getS(s);
            }
        }.execute(surl);
    }
}
