package com.cs.ghdemo.GH.GlobalNormal;
import com.cs.ghdemo.entity.Baggage;
import com.cs.ghdemo.entity.Info;
import com.cs.ghdemo.entity.Ticket;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.*;

import static org.testng.Assert.assertEquals;

public class testCase30_32 {

    @DataProvider(name = "testCase30")
    public Info[][] testCase30() {
        Info[][] object;

        return object = new Info[][]{
                {new Info(new Ticket("国际、地区航线", "1", "经济舱", "成人票", "无", 1000),
                        Arrays.asList(new Baggage("普通行李", 100, 60, 40, 32),new Baggage("普通行李", 100, 20, 20, 23)))
                }
        };
    }
    @DataProvider(name = "testCase31")
    public Info[][] testCase31() {
        Info[][] object;

        return object = new Info[][]{
                {new Info(new Ticket("国际、地区航线", "1", "经济舱", "儿童票", "无", 1000),
                        Arrays.asList(new Baggage("普通行李", 100, 60, 40, 32),new Baggage("普通行李", 100, 60, 40, 32),new Baggage("普通行李", 100, 60, 40, 32)))
                }
        };
    }
    @DataProvider(name = "testCase32")
    public Info[][] testCase32() {
        Info[][] object;

        return object = new Info[][]{
                {new Info(new Ticket("国际、地区航线", "1", "经济舱", "婴儿票", "无", 1000),
                        Arrays.asList(new Baggage("普通行李", 100, 60, 40, 32),new Baggage("普通行李", 100, 60, 40, 32),new Baggage("普通行李", 100, 60, 40, 32)))
                }
        };
    }
    @Test(dataProvider = "testCase30")
    public void test01(Info info ) throws Exception{
        Assert.assertEquals(info.calculate(info),2800,0.001);
    }
    @Test(dataProvider = "testCase31")
    //b 50
    public void test02(Info info ) throws Exception{
        Assert.assertEquals(info.calculate(info),7600,0.001);
    }
    @Test(dataProvider = "testCase32")
    public void test03(Info info ) throws Exception{
        Assert.assertEquals(info.calculate(info),7600,0.001);
    }
}

