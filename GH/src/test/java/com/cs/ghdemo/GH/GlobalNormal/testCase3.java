package com.cs.ghdemo.GH.GlobalNormal;
import com.cs.ghdemo.entity.Baggage;
import com.cs.ghdemo.entity.Info;
import com.cs.ghdemo.entity.Ticket;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.*;

import static org.testng.Assert.assertEquals;

public class testCase3 {
    @DataProvider(name = "testCase3")
    public Info[][] testCase3() {
        Info[][] object;

        return object = new Info[][]{
                {new Info(new Ticket("国际、地区航线", "1", "悦享经济舱 超级经济舱", "成人票", "无", 1000),
                        Collections.singletonList(new Baggage("普通行李", 100, 60, 60, 33)))
                }
        };
    }

    @Test(dataProvider = "testCase3")
    public void test02(Info info ) throws Exception{
        Assert.assertEquals(info.calculate(info),1400,0.001);
    }
}

