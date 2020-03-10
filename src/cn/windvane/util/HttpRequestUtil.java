package cn.windvane.util;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import com.alibaba.fastjson.JSON;

import cn.windvane.bean.Result;

public class HttpRequestUtil {
	
	public static String doGet(String url){
		String resultJson = "";
        try {
       	 URL realUrl = new URL(url);
            //得到connection对象。
            HttpURLConnection connection = (HttpURLConnection) realUrl.openConnection();
            //设置请求方式
            connection.setRequestMethod("GET");
            //连接
            connection.connect();
            //得到响应码
            int responseCode = connection.getResponseCode();
            if(responseCode == HttpURLConnection.HTTP_OK){
                //得到响应流
                InputStream inputStream = connection.getInputStream();
                //将响应流转换成字符串
                byte[] bytes = new byte[0];
                bytes = new byte[inputStream.available()];
                inputStream.read(bytes);
                resultJson = new String(bytes);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
		
       return resultJson;
	}

}
