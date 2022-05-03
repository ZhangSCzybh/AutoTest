package com.yolocast.qa.zsc.ApiTest.ActivityListTest;

import cn.hutool.http.HttpUtil;
import com.yolocast.qa.zsc.Constant.Common;
import com.yolocast.qa.zsc.utils.LoginUtil;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

public class ActivityTest {

    private static String cookie = "";



    @BeforeClass
    public static void setUp() {
        System.out.println("执行登录获取cookie操作");
        cookie = LoginUtil.loginCookie(Common.yolocastUrl + Common.loginUri, Common.loginYolocastEmail, Common.loginYolocastPassword);
    }


    /**
     *
     * @author zhangsc
     * @date 2022/5/1 下午12:52
     * 获取预约活动列表
     */
    @Test  //@Test(dependsOnMethods = {"loginYolocast"})
    public void getScheduleEventsList(){

        //拼接最终的测试地址
        //String uri = bundle.getString("ScheduleEventsList.uri");
        //String ScheduleEventsListUrl = this.yolocastUrl + uri;
        Map<String, Object> map = new HashMap<>();//存放参数
        map.put("pageNo", 1);
        map.put("pageSize", 10);
        map.put("status", 3);
        HashMap<String, String> headers = new HashMap<>();//存放请求头，可以存放多个请求头
        headers.put("cast-auth", cookie);
        //发送get请求并接收响应数据
        String result= HttpUtil.createGet(Common.yolocastUrl+Common.scheduleEventsListuri).addHeaders(headers).form(map).execute().body();
        //发送post请求并接收响应数据
        //String result= HttpUtil.createPost(url).addHeaders(headers).form(map).execute().body();
        System.out.println(result);
        cn.hutool.json.JSONObject resultJson = new cn.hutool.json.JSONObject(result);
        String message = (String) resultJson.get("message");
        //具体的判断返回结果的值
        Assert.assertEquals("successful",message);
    }




}
