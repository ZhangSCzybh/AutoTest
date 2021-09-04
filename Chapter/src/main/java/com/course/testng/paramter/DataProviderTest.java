package com.course.testng.paramter;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

/**
 * 注释 dataprovider参数化
 */
public class DataProviderTest {

    @Test(dataProvider = "data")
    public void testDataProvider(String name,int age){
        System.out.println("name="+name +"\n"+"age="+age);
    }

    @DataProvider(name = "data")
    public Object[] [] providerData(){
        Object[] [] objects=new Object[][]{

                {"zhangsan",10},
                {"lisi",20},
                {"wangwu",30}
        };
        return objects;
    }

    //多个


    @Test(dataProvider = "methodData")
    public void test1(String name,int age){
        System.out.println("test111方法 name="+name +"; age="+age);
    }

    @Test(dataProvider = "methodData")
    public void test2(String name,int age){
        System.out.println("test222方法 name="+name +"; age="+age);
    }

    @DataProvider(name="methodData")
    public Object[] [] methodDataTest(Method method){
        Object[] [] result =null;

        if (method.getName().equals("test1")){
            result = new Object[][]{
                    {"zhangsan",20},
                    {"lisi",25}
            };
        }else if (method.getName().equals("test2")){
            result = new  Object[][]{
                    {"wangwu",45},
                    {"zhaoliu",56}

            };
        }


        return result;
    }

}
