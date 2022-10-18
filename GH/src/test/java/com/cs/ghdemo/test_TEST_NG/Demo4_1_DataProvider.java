package com.cs.ghdemo.test_TEST_NG;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Demo4_1_DataProvider {
    //定义二维数组，后续测试用@DataProvider实现关联
    @DataProvider(name = "testFunList")
    public Object[][] testFunList(){
        Object[][] object;
        return object = new Object[][]{
                {"test01",1,0,0},
                {"test02",0,1,0},
                {"test03",0,0,1}

        };
    }
    @Test(dataProvider = "testFunList")
    public void test01(String funName, int aNum, int bNum, int cNum) throws Exception{
        System.out.println("测试方法名1：" + funName + "，打印数字1：" + aNum);
        Thread.sleep(1000);
        System.out.println("测试方法名2：" + funName + "，打印数字2：" + bNum);
        Thread.sleep(1000);
        System.out.println("测试方法名3：" + funName + "，打印数字3：" + cNum);
        Thread.sleep(1000);

    }

}
