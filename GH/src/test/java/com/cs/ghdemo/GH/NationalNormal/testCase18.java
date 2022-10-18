package com.cs.ghdemo.GH.NationalNormal;
import com.cs.ghdemo.entity.Baggage;
import com.cs.ghdemo.entity.Info;
import com.cs.ghdemo.entity.Ticket;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.*;

import static org.testng.Assert.assertEquals;

public class testCase18 {
    @DataProvider(name = "testCase18")
    public Info[][] testCase1() {
        Info[][] object;

        return object = new Info[][]{
                {new Info(new Ticket("国内航线", "0", "经济舱", "成人票", "无", 1000),
                        Collections.singletonList(new Baggage("普通行李", 99, 59, 39, 19)))
                }
        };
    }

    @Test(dataProvider = "testCase18")
    public void test01(Info info ) throws Exception{
        Assert.assertEquals(info.calculate(info),0,0.001);
    }
}
