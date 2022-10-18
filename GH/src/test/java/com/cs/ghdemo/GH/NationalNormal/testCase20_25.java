package com.cs.ghdemo.GH.NationalNormal;

import com.cs.ghdemo.entity.Baggage;
import com.cs.ghdemo.entity.Info;
import com.cs.ghdemo.entity.Ticket;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.Collections;

public class testCase20_25 {
    @DataProvider(name = "testCase20")
    public Info[][] testCase20() {
        Info[][] object;

        return object = new Info[][]{
                {new Info(new Ticket("国内航线", "0", "头等舱", "婴儿票", "星空联盟金卡", 1000),
                        Collections.singletonList(new Baggage("普通行李", 100, 60, 40, 40)))
                }
        };
    }
    @DataProvider(name = "testCase21")
    public Info[][] testCase21() {
        Info[][] object;

        return object = new Info[][]{
                {new Info(new Ticket("国内航线", "0", "头等舱", "成人票", "无", 1000),
                        Collections.singletonList(new Baggage("普通行李", 55, 20, 40, 8)))
                }
        };
    }
    @DataProvider(name = "testCase22")
    public Info[][] testCase22() {
        Info[][] object;

        return object = new Info[][]{
                {new Info(new Ticket("国内航线", "0", "公务舱", "成人票", "无", 1000),
                        Arrays.asList(new Baggage("普通行李", 100, 60, 40, 30),new Baggage("普通行李", 55, 40, 20, 8)))
                }
        };
    }
    @DataProvider(name = "testCase23")
    public Info[][] testCase23() {
        Info[][] object;

        return object = new Info[][]{
                {new Info(new Ticket("国内航线", "0", "经济舱", "成人票", "无", 1000),
                        Arrays.asList(new Baggage("普通行李", 100, 60, 40, 20),new Baggage("普通行李", 55, 40, 20, 8)))
                }
        };
    }
    @DataProvider(name = "testCase24")
    public Info[][] testCase24() {
        Info[][] object;

        return object = new Info[][]{
                {new Info(new Ticket("国内航线", "0", "经济舱", "成人票", "无", 1000),
                        Arrays.asList(new Baggage("普通行李", 100, 60, 40, 20),new Baggage("普通行李", 55, 40, 20, 5)))
                }
        };
    }
    @DataProvider(name = "testCase25")
    public Info[][] testCase25() {
        Info[][] object;

        return object = new Info[][]{
                {new Info(new Ticket("国内航线", "0", "经济舱", "成人票", "无", 1000),
                        Arrays.asList(new Baggage("普通行李", 100, 60, 40, 20),new Baggage("普通行李", 55, 40, 20, 5),new Baggage("普通行李", 55, 40, 20, 5)))
                }
        };
    }
    @Test(dataProvider = "testCase20")
    public void test01(Info info ) throws Exception{
        Assert.assertEquals(info.calculate(info),150,0.001);
    }
    @Test(dataProvider = "testCase21")
    public void test02(Info info ) throws Exception{
        Assert.assertEquals(info.calculate(info),0,0.001);
    }
    @Test(dataProvider = "testCase22")
    public void test03(Info info ) throws Exception{
        Assert.assertEquals(info.calculate(info),0,0.001);
    }
    @Test(dataProvider = "testCase23")
    public void test04(Info info ) throws Exception{
        Assert.assertEquals(info.calculate(info),120,0.001);
    }
    @Test(dataProvider = "testCase24")
    public void test05(Info info ) throws Exception{
        Assert.assertEquals(info.calculate(info),0,0.001);
    }
    @Test(dataProvider = "testCase25")
    public void test06(Info info ) throws Exception{
        Assert.assertEquals(info.calculate(info),75,0.001);
    }
}
