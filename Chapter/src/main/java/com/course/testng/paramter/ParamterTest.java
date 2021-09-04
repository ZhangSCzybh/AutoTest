package com.course.testng.paramter;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

/**
 * 文件参数化
 * Paramter.xml
 */
public class ParamterTest {

    @Test
    @Parameters({"name","age"})
    public void paramTest1(String name,int age){
        System.out.println("name="+name +"\n"+"age="+age);
    }
}
