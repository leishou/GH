package com.cs.ghdemo.GH.GlobalSpecial;
import com.cs.ghdemo.entity.Baggage;
import com.cs.ghdemo.entity.Info;
import com.cs.ghdemo.entity.Ticket;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.*;

import static org.testng.Assert.assertEquals;

public class testCase28_29 {
    @DataProvider(name = "testCase28")
    public Info[][] testCase5() {
        Info[][] object;

        return object = new Info[][]{
                {new Info(new Ticket("国际、地区航线", "1", "公务舱", "成人票", "无", 1000),
                        Arrays.asList(new Baggage("普通行李", 100, 60, 40, 32),new Baggage("婴儿车或摇篮", 0, 0, 0, 5)))
                }
        };
    }
    @DataProvider(name = "testCase29")
    public Info[][] testCase29() {
        Info[][] object;

        return object = new Info[][]{
                {new Info(new Ticket("国际、地区航线", "1", "经济舱", "成人票", "无", 1000),
                        Arrays.asList(new Baggage("普通行李", 100, 20, 20, 23),new Baggage("婴儿车或摇篮", 0, 0, 0, 5)))
                }
        };
    }
    @DataProvider(name = "testCase30")
    public Info[][] testCase30() {
        Info[][] object;

        return object = new Info[][]{
                {new Info(new Ticket("国际、地区航线", "1", "经济舱", "成人票", "无", 1000),
                        Arrays.asList(new Baggage("普通行李", 100, 60, 40, 32),new Baggage("普通行李", 100, 20, 20, 23)))
                }
        };
    }
    @Test(dataProvider = "testCase28")
    public void test01(Info info ) throws Exception{
        Assert.assertEquals(info.calculate(info),980,0.001);
    }
    @Test(dataProvider = "testCase29")
    public void test02(Info info ) throws Exception{
        Assert.assertEquals(info.calculate(info),1400,0.001);
    }
    @Test(dataProvider = "testCase30")
    public void test03(Info info ) throws Exception{
        Assert.assertEquals(info.calculate(info),2800,0.001);
    }
}

