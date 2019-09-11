package com.qa.restclient;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.apache.http.Header;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.HashMap;

public class RestClient {
    public void get(String url) throws ClassCastException, IOException{
        //创建一个可关闭的httpclient 对象
        CloseableHttpClient httpClient = HttpClients.createDefault();
        //创建一个httpget请求对象
        HttpGet httpget = new HttpGet(url);
        //执行请求
        CloseableHttpResponse httpResponse = httpClient.execute(httpget);
        //获取响应状态码
        int responseStatusCode = httpResponse.getStatusLine().getStatusCode();
        System.out.println("response status code -->" + responseStatusCode);

        //将响应内容存储到字符串对象
        String responseString = EntityUtils.toString(httpResponse.getEntity());

        //创建json对象，把上面字符串序列转化成Json对象
        JSONObject responseJson = JSON.parseObject(responseString);
        System.out.println("response json from API-->" + responseJson);

        //获取响应头信息，返回一个数组
        Header[] headerArray = httpResponse.getAllHeaders();
        //创建一个hashmap对象
        HashMap<String,String> hm = new HashMap<String, String>();
        //增强for循环遍历headerArray数组
        for(Header header : headerArray){
            hm.put(header.getName(), header.getValue());
        }
        System.out.println("response headers xiugaixiugai1-->"+hm);
    }


    }


