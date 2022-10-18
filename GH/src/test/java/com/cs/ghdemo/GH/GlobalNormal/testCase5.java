package com.cs.ghdemo.GH.GlobalNormal;
import com.cs.ghdemo.entity.Baggage;
import com.cs.ghdemo.entity.Info;
import com.cs.ghdemo.entity.Ticket;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.*;

import static org.testng.Assert.assertEquals;

public class testCase5 {
    @DataProvider(name = "testCase5")
    public Info[][] testCase5() {
        Info[][] object;

        return object = new Info[][]{
                {new Info(new Ticket("国际、地区航线", "1", "头等舱", "成人票", "无", 1000),
                        Arrays.asList(new Baggage("普通行李", 100, 60, 40, 32),new Baggage("普通行李", 55, 40, 20, 8)))
                }
        };
    }

    @Test(dataProvider = "testCase5")
    public void test05(Info info ) throws Exception{
        Assert.assertEquals(info.calculate(info),980,0.001);
    }
}

