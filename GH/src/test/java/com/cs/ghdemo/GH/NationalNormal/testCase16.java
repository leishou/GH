package com.cs.ghdemo.GH.NationalNormal;
import com.cs.ghdemo.entity.Baggage;
import com.cs.ghdemo.entity.Info;
import com.cs.ghdemo.entity.Ticket;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.*;

import static org.testng.Assert.assertEquals;

public class testCase16 {
    @DataProvider(name = "testCase16")
    public Info[][] testCase1() {
        Info[][] object;

        return object = new Info[][]{
                {new Info(new Ticket("国内航线", "0", "头等舱", "成人票", "无", 1000),
                        Collections.singletonList(new Baggage("普通行李", 101, 61, 41, 41)))
                }
        };
    }

    @Test(dataProvider = "testCase16")
    public void test01(Info info ) throws Exception{
        Assert.assertEquals(info.calculate(info),15,0.001);
    }
}
