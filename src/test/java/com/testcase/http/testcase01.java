package com.testcase.http;

import com.tools.httprequest.GetHttp;
import com.tools.httprequest.PostHttp;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class testcase01 {

    @Test
    public void getHttpTest() {
        String url = "https://www.apiopen.top/weatherApi";
        String params = "city=%E4%B8%8A%E6%B5%B7";
        //调用GetHttp类中的get请求方法
        Response response = GetHttp.getHttp(url, params);
        //打印响应体
        response.print();
        //断言状态码是否为200
        Assert.assertEquals("200", response.getBody().jsonPath().get("code").toString());


    }

    @Test
    public void postHttpTest() {
        String url = "https://www.apiopen.top/addStatistics";
        String bodyString ="appKey=00d91e8e0cca2b76f515926a36db68f5&type=点击统计&typeId=1&count=2";
        //String bodyString = "key=00d91e8e0cca2b76f515926a36db68f5&phone=13594347817&passwd=123456";
        //调用PostHttp类中的post请求方法
        Response response = PostHttp.ptstHttp(url, bodyString);
        //打印响应体
        response.print();
        //断言状态码是否为200
        Assert.assertEquals("200", response.getBody().jsonPath().get("code").toString());

    }


}
