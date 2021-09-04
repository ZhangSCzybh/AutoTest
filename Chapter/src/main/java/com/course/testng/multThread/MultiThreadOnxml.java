package com.course.testng.multThread;

import org.testng.annotations.Test;

public class MultiThreadOnxml {
    /**
     * mulitThread.xml多线程 并发
     */


    @Test
    public void test1(){
        System.out.printf("Thread Id : %s%n",Thread.currentThread().getId());
    }

    @Test
    public void test2(){
        System.out.printf("Thread Id : %s%n",Thread.currentThread().getId());
    }

    @Test
    public void test3(){
        System.out.printf("Thread Id : %s%n",Thread.currentThread().getId());
    }

    @Test
    public void test4(){
        System.out.printf("Thread Id : %s%n",Thread.currentThread().getId());
    }

    @Test
    public void test5(){
        System.out.printf("Thread Id : %s%n",Thread.currentThread().getId());
    }

    @Test
    public void test6(){
        System.out.printf("Thread Id : %s%n",Thread.currentThread().getId());
    }

    @Test
    public void test7(){
        System.out.printf("Thread Id : %s%n",Thread.currentThread().getId());
    }

    @Test
    public void test8(){
        System.out.printf("Thread Id : %s%n",Thread.currentThread().getId());
    }
}
