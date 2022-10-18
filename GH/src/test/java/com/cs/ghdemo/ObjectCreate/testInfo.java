package com.cs.ghdemo.ObjectCreate;


import com.cs.ghdemo.entity.Baggage;
import com.cs.ghdemo.entity.BaggageList;
import com.cs.ghdemo.entity.Info;
import com.cs.ghdemo.entity.Ticket;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

import java.util.*;

import static org.testng.Assert.assertEquals;

public class testInfo {
    @DataProvider(name = "testInfo")
    public Info[][] testInfo() {
        Info[][] object;

        return object = new Info[][]{
                {new Info(new Ticket("国内航线", "0", "头等舱", "儿童票", "无", 100),
                        Collections.singletonList(new Baggage("普通行李", 10, 5, 2, 1)))
                }
        };
    }

    @Test(dataProvider = "testInfo")
    public void test01(Info info ) throws Exception{
        assertEquals(info.getTicket().getFlightType(),"国内航线");
        assertEquals(info.getTicket().getFlightArea(),"0");
        assertEquals(info.getTicket().getSeatType(),"头等舱");
        assertEquals(info.getTicket().getPeopleType(),"儿童票");
        assertEquals(info.getTicket().getVipType(),"无");
        assertEquals(info.getTicket().getTicketPrice(),100,0.001);

        assertEquals(info.getBaggageList().toString(),"[Baggage(baggageType=普通行李, a=10.0, b=5.0, h=2.0, w=1.0)]");
    }
}
