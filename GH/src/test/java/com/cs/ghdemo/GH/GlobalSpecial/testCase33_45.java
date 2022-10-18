package com.cs.ghdemo.GH.GlobalSpecial;
import com.cs.ghdemo.entity.Baggage;
import com.cs.ghdemo.entity.Info;
import com.cs.ghdemo.entity.Ticket;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.*;

import static org.testng.Assert.assertEquals;

public class testCase33_45 {
    @DataProvider(name = "testCase33")
    public Info[][] testCase5() {
        Info[][] object;

        return object = new Info[][]{
                {new Info(new Ticket("国际、地区航线", "1", "公务舱", "成人票", "无", 1000),
                        Arrays.asList(new Baggage("手动轮椅", 0, 0, 0, 5),new Baggage("电动轮椅", 0, 0, 0, 5)))
                }
        };
    }
    @DataProvider(name = "testCase34")
    public Info[][] testCase29() {
        Info[][] object;

        return object = new Info[][]{
                {new Info(new Ticket("国际、地区航线", "1", "经济舱", "成人票", "无", 1000),
                        Arrays.asList(new Baggage("手动轮椅", 0, 0, 0, 23),new Baggage("电动轮椅", 0, 0, 0, 23)))
                }
        };
    }
    @DataProvider(name = "testCase35")
    public Info[][] testCase30() {
        Info[][] object;

        return object = new Info[][]{
                {new Info(new Ticket("国际、地区航线", "1", "经济舱", "成人票", "无", 1000),
                        Arrays.asList(new Baggage("婴儿车或摇篮", 0, 0, 0, 32)))
                }
        };
    }
    @DataProvider(name = "testCase36")
    public Info[][] testCase36() {
        Info[][] object;

        return object = new Info[][]{
                {new Info(new Ticket("国际、地区航线", "1", "经济舱", "成人票", "无", 1000),
                        Arrays.asList(new Baggage("导盲犬", 0, 0, 0, 20),new Baggage("骨灰", 0, 0, 0, 10)))
                }
        };
    }

    @Test(dataProvider = "testCase33")
    public void test01(Info info ) throws Exception{
        Assert.assertEquals(info.calculate(info),0,0.001);
    }
    @Test(dataProvider = "testCase34")
    public void test02(Info info ) throws Exception{
        Assert.assertEquals(info.calculate(info),1400,0.001);
    }
    @Test(dataProvider = "testCase35")
    public void test03(Info info ) throws Exception{
        Assert.assertEquals(info.calculate(info),980,0.001);
    }
    @Test(dataProvider = "testCase36")
    public void test04(Info info ) throws Exception{
        Assert.assertEquals(info.calculate(info),0,0.001);
    }
    @DataProvider(name = "testCase37")
    public Info[][] testCase37() {
        Info[][] object;

        return object = new Info[][]{
                {new Info(new Ticket("国际、地区航线", "1", "公务舱", "成人票", "无", 1000),
                        Arrays.asList(new Baggage("普通行李", 100, 20, 20, 32),new Baggage("普通行李", 100, 20, 20, 32),new Baggage("自行车", 0, 0, 0, 5)))
                }
        };
    }
    @Test(dataProvider = "testCase37")
    public void test05(Info info ) throws Exception{
        Assert.assertEquals(info.calculate(info),1400,0.001);
    }
    @DataProvider(name = "testCase38")
    public Info[][] testCase38() {
        Info[][] object;

        return object = new Info[][]{
                {new Info(new Ticket("国际、地区航线", "1", "公务舱", "成人票", "无", 1000),
                        Arrays.asList(new Baggage("皮划艇", 0, 0, 0, 32)))
                }
        };
    }
    @Test(dataProvider = "testCase38")
    public void test06(Info info ) throws Exception{
        Assert.assertEquals(info.calculate(info),3900,0.001);
    }
    @DataProvider(name = "testCase39")
    public Info[][] testCase39() {
        Info[][] object;

        return object = new Info[][]{
                {new Info(new Ticket("国际、地区航线", "1", "公务舱", "成人票", "无", 1000),
                        Arrays.asList(new Baggage("撑杆", 0, 0, 0, 23)))
                }
        };
    }
    @Test(dataProvider = "testCase39")
    public void test07(Info info ) throws Exception{
        Assert.assertEquals(info.calculate(info),1300,0.001);
    }
    @DataProvider(name = "testCase40")
    public Info[][] testCase40() {
        Info[][] object;

        return object = new Info[][]{
                {new Info(new Ticket("国际、地区航线", "1", "经济舱", "成人票", "无", 1000),
                        Arrays.asList(new Baggage("睡袋", 0, 0, 0, 32)))
                }
        };
    }
    @Test(dataProvider = "testCase40")
    public void test08(Info info ) throws Exception{
        Assert.assertEquals(info.calculate(info),980,0.001);
    }
    @DataProvider(name = "testCase41")
    public Info[][] testCase41() {
        Info[][] object;

        return object = new Info[][]{
                {new Info(new Ticket("国际、地区航线", "1", "公务舱", "成人票", "无", 1000),
                        Arrays.asList(new Baggage("小型电器或仪器", 0, 0, 0, 32)))
                }
        };
    }
    @Test(dataProvider = "testCase41")
    public void test09(Info info ) throws Exception{
        Assert.assertEquals(info.calculate(info),3900,0.001);
    }
    @DataProvider(name = "testCase42")
    public Info[][] testCase42() {
        Info[][] object;

        return object = new Info[][]{
                {new Info(new Ticket("国际、地区航线", "1", "公务舱", "成人票", "无", 1000),
                        Arrays.asList(new Baggage("可作为行李运输的枪支", 0, 0, 0, 23)))
                }
        };
    }
    @Test(dataProvider = "testCase42")
    public void test10(Info info ) throws Exception{
        Assert.assertEquals(info.calculate(info),1300,0.001);
    }
    @DataProvider(name = "testCase43")
    public Info[][] testCase43() {
        Info[][] object;

        return object = new Info[][]{
                {new Info(new Ticket("国际、地区航线", "1", "公务舱", "成人票", "无", 1000),
                        Arrays.asList(new Baggage("可作为行李运输的枪支", 0, 0, 0, 23)))
                }
        };
    }
    @Test(dataProvider = "testCase43")
    public void test11(Info info ) throws Exception{
        Assert.assertEquals(info.calculate(info),1300,0.001);
    }
    @DataProvider(name = "testCase44")
    public Info[][] testCase44() {
        Info[][] object;

        return object = new Info[][]{
                {new Info(new Ticket("国际、地区航线", "1", "公务舱", "成人票", "无", 1000),
                        Arrays.asList(new Baggage("可作为行李运输的弹药", 0, 0, 0, 6)))
                }
        };
    }
    @Test(dataProvider = "testCase44")
    public void test12(Info info ) throws Exception{
        Assert.assertEquals(info.calculate(info),1300,0.001);
    }
    @DataProvider(name = "testCase45")
    public Info[][] testCase45() {
        Info[][] object;

        return object = new Info[][]{
                {new Info(new Ticket("国际、地区航线", "1", "公务舱", "成人票", "无", 1000),
                        Arrays.asList(new Baggage("小动物", 0, 0, 0, 8)))
                }
        };
    }
    @Test(dataProvider = "testCase45")
    public void test13(Info info ) throws Exception{
        Assert.assertEquals(info.calculate(info),3900,0.001);
    }
}

