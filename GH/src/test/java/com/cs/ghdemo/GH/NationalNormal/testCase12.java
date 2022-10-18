package com.cs.ghdemo.GH.NationalNormal;
import com.cs.ghdemo.entity.Baggage;
import com.cs.ghdemo.entity.Info;
import com.cs.ghdemo.entity.Ticket;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.*;

import static org.testng.Assert.assertEquals;

public class testCase12 {
    @DataProvider(name = "testCase12")
    public Info[][] testCase12() {
        Info[][] object;

        return object = new Info[][]{

                {new Info(new Ticket("国内航线", "0", "经济舱", "成人票", "无", 1000),
                        Arrays.asList(new Baggage("普通行李", 100, 60, 40, 10),new Baggage("普通行李", 100, 60, 40, 5),new Baggage("皮划艇", 0, 0, 0, 5),new Baggage("撑杆", 0, 0, 0, 5)))
                }
        };
    }

    @Test(dataProvider = "testCase12")
    public void test06(Info info ) throws Exception{
        Assert.assertEquals(info.calculate(info),150,0.001);
    }
}
