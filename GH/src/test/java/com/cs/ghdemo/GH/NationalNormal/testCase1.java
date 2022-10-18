package com.cs.ghdemo.GH.NationalNormal;
import com.cs.ghdemo.entity.Baggage;
import com.cs.ghdemo.entity.Info;
import com.cs.ghdemo.entity.Ticket;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.*;

import static org.testng.Assert.assertEquals;

public class testCase1 {
    @DataProvider(name = "testCase1")
    public Info[][] testCase1() {
        Info[][] object;

        return object = new Info[][]{
                {new Info(new Ticket("国内航线", "0", "头等舱", "成人票", "凤凰知音终身白金卡、白金卡", 1000),
                        Collections.singletonList(new Baggage("普通行李", 100, 60, 40, 71)))
                }
        };
    }

    @Test(dataProvider = "testCase1")
    public void test01(Info info ) throws Exception{
        Assert.assertEquals(info.calculate(info),15,0.001);
    }
}
