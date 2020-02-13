package com.csdj.bookmanage.test;

public class SingletonTest {
    private SingletonTest(){};
    private static  SingletonTest single=null;
    public static SingletonTest getInstance(){
        if (single==null){
            single=new SingletonTest();
            System.out.println("创建一次");
        }
        return single;
    }
    public void show(){
        System.out.println("我是show");
    }
}
