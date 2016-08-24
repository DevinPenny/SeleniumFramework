package SeleniumTests;

import PageObjects.LoginPageObj;
import PageObjects.MainPageObj;
import PageObjects.CommonObj;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;


public class ExampleTestClean extends AbstractWebDriver {

    @Before
    public void TestSetUp(){
       //Navigate to application before executing test
        CommonObj.NavigateToPage();
    }


    @After
    public void testShutDown(){
    //clean up is performed in AbstractWebDriver class
        System.out.println("Test Complete!");
    }


    @Test
    public void FirstTestToExecute() {

        //enter user credentials (username/password)
        LoginPageObj.EnterLoginCredentials();
        //click the log in button
        LoginPageObj.ClickLogIn();
        //Verify the result
        Assert.assertTrue(MainPageObj.GetTextFromPage().contains("Some Message"));

    }
}
