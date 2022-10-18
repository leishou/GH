package com.cs.ghdemo.test_TEST_NG;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class testData {
    @DataProvider(name = "user")
    public Object[][] Users() {
        return new Object[][]{
                {"root", "password"},
                {"csdn.com", "zjkl"},
                {"python", "java"}
        };
    }

    @Test(dataProvider = "user")
    public void verifyUser(String userName,String password){
        System.out.println("Username:" + userName + "Password:" + password);
    }
}
