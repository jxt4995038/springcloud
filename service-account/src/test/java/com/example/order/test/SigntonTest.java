package com.example.order.test;

/**
 * @program: springcloud
 * @description:
 * @author: jiaxiaotong
 * @create: 2020-04-15 14:04
 */
public class SigntonTest {

    public volatile SigntonTest signtonTest = null;

    private SigntonTest() throws Exception{
        throw new Exception("单例不可以被构造");
    }


    public SigntonTest getInstance() throws Exception{
        if (signtonTest == null){
            synchronized (SigntonTest.class){
                if (signtonTest == null){
                    return new SigntonTest();
                }
            }
        }
        return signtonTest;
    }
}