package SeleniumTests;

import PageObjects.CommonObj;
import PageObjects.LoginPageObj;
import PageObjects.MainPageObj;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class ExampleTestClean extends AbstractWebDriver {

    CommonObj Navigate = new CommonObj(driver);
    LoginPageObj Login = new LoginPageObj(driver);
    MainPageObj MainPage = new MainPageObj(driver);

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
