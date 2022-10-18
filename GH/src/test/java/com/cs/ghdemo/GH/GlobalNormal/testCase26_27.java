package com.cs.ghdemo.GH.GlobalNormal;
import com.cs.ghdemo.entity.Baggage;
import com.cs.ghdemo.entity.Info;
import com.cs.ghdemo.entity.Ticket;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.*;

import static org.testng.Assert.assertEquals;

public class testCase26_27 {
    @DataProvider(name = "testCase26")
    public Info[][] testCase5() {
        Info[][] object;

        return object = new Info[][]{
                {new Info(new Ticket("国际、地区航线", "1", "经济舱", "成人票", "无", 1000),
                        Arrays.asList(new Baggage("普通行李", 55, 40, 20, 5)))
                }
        };
    }
    @DataProvider(name = "testCase27")
    public Info[][] testCase27() {
        Info[][] object;

        return object = new Info[][]{
                {new Info(new Ticket("国际、地区航线", "1", "经济舱", "婴儿票", "无", 1000),
                        Arrays.asList(new Baggage("普通行李", 55, 40, 20, 8)))
                }
        };
    }

    @Test(dataProvider = "testCase26")
    public void test01(Info info ) throws Exception{
        Assert.assertEquals(info.calculate(info),0,0.001);
    }
    @Test(dataProvider = "testCase27")
    public void test02(Info info ) throws Exception{
        Assert.assertEquals(info.calculate(info),0,0.001);
    }

}

