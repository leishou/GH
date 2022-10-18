package com.cs.ghdemo.GH.NationalNormal;
import com.cs.ghdemo.entity.Baggage;
import com.cs.ghdemo.entity.Info;
import com.cs.ghdemo.entity.Ticket;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.*;

import static org.testng.Assert.assertEquals;

public class testCase15 {
    @DataProvider(name = "testCase15")
    public Info[][] testCase15() {
        Info[][] object;

        return object = new Info[][]{

                {new Info(new Ticket("国内航线", "0", "经济舱", "成人票", "无", 1000),
                        Arrays.asList(new Baggage("普通行李", 100, 60, 40, 20),new Baggage("小型电器或仪器", 0, 0, 0, 10),new Baggage("可作为行李运输的枪支", 0, 0, 0, 5),new Baggage("可作为行李运输的弹药", 0, 0, 0, 5),new Baggage("小动物", 0, 0, 0, 5)))
                }
        };
    }

    @Test(dataProvider = "testCase15")
    public void test06(Info info ) throws Exception{
        Assert.assertEquals(info.calculate(info),375,0.001);
    }
}
