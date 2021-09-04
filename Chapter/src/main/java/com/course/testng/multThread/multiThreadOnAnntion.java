package com.course.testng.multThread;

import org.testng.annotations.Test;

public class multiThreadOnAnntion {
    /**
     * invocationCount 执行次数
     * threadPoolSize 线程池内线程数量
     */

    @Test(invocationCount = 10,threadPoolSize = 3)
    public void test1(){
        System.out.println(1);
        System.out.printf("Thread Id : %s%n",Thread.currentThread().getId());
    }
}
