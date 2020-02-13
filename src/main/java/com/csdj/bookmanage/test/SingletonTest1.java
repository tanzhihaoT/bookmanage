package com.csdj.bookmanage.test;

public class SingletonTest1 {
    public static void main(String[] args) {
        SingletonTest singletonTest=SingletonTest.getInstance();
        SingletonTest singletonTest1=SingletonTest.getInstance();
        singletonTest.show();
        singletonTest1.show();
        //两个对象的表现形式一样
        if(singletonTest == singletonTest1){
            System.out.println("该对象的字符串表示形式:");
            System.out.println("singleton :"+singletonTest.toString());
            System.out.println("singleton2:"+singletonTest1.toString());
        }
    }
}
