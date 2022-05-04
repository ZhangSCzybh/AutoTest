package com.yolocast.qa.zsc.Constant;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Properties;


public class Common {
    private static final Properties STATIC_PROPERTIES = new Properties();

    static {
        try {
            InputStream in = Common.class.getClassLoader().getResourceAsStream("test.properties");
            //字节流是无法读取中文的，否则会乱码。所以采取reader把inputStream转换成reader用字符流来读取中文
            BufferedReader bf = new BufferedReader(new InputStreamReader(in));
            if (null != bf) {
                STATIC_PROPERTIES.load(bf);
            }
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }


    //yolocast-b端平台
    public static String profiesEnv = STATIC_PROPERTIES.getProperty("profiles.active");//不同环境切换****测试环境：profiles.active1、预发环境：profiles.active2、生产环境：profiles.active2
    public static String yolocastUrl = STATIC_PROPERTIES.getProperty("yolocast.url");//不同环境切换不同域名就好 测试环境：yolocast.test.url、测试环境：yolocast.pre.url、生产环境：yolocast.prod.url

    public static String loginYolocastEmail = STATIC_PROPERTIES.getProperty("login.Yolocast.email");
    public static String loginYolocastPassword = STATIC_PROPERTIES.getProperty("login.Yolocast.password");

    public static String loginUri = STATIC_PROPERTIES.getProperty("login.uri");

    public static String scheduleEventsListuri = STATIC_PROPERTIES.getProperty("schedule.events.List.uri");
    public static String sourceListuri = STATIC_PROPERTIES.getProperty("source.uri");
    public static String sourceResetKeyuri = STATIC_PROPERTIES.getProperty("source.reset.key.uri");

    public static String activityCreateuri = STATIC_PROPERTIES.getProperty("create.activity.uri");




    //dingding
    public static String privateDingtalkUrl = STATIC_PROPERTIES.getProperty("private.dingtalk.alert.url");
    public static String dingTalkUrlSecret = STATIC_PROPERTIES.getProperty("dingding,url.secret");

        //用来存储cookies的变量
    public static String Cookies;




    //yolocast-c端平台
    //TODO c端 apitest


    //yolocast-dashboard
    //TODO dashboard apitest
}
