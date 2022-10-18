package com.cs.ghdemo.GH.GlobalNormal;
import com.cs.ghdemo.entity.Baggage;
import com.cs.ghdemo.entity.Info;
import com.cs.ghdemo.entity.Ticket;
import org.springframework.boot.test.context.SpringBootTest;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.*;

import static org.testng.Assert.assertEquals;
@SpringBootTest
public class testCase2 {
    @DataProvider(name = "testCase2")
    public Info[][] testCase2() {
        Info[][] object;

        return object = new Info[][]{
                {new Info(new Ticket("国际、地区航线", "1", "头等舱", "成人票", "无", 1000),
                        Collections.singletonList(new Baggage("普通行李", 55, 40, 20, 8)))
                }
        };
    }

    @Test(dataProvider = "testCase2")
    public void test02(Info info ) throws Exception{
        Assert.assertEquals(info.calculate(info),0,0.001);
    }
}

