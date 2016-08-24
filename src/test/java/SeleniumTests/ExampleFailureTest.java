package SeleniumTests;

import PageObjects.CommonObj;
import PageObjects.LoginPageObj;
import PageObjects.MainPageObj;


import org.junit.*;


import org.junit.rules.TestWatcher;
import org.junit.runner.Description;


public class ExampleFailureTest extends AbstractWebDriver {


    @Test
    public void FirstTestToExecute() {

        //navigate to page
        CommonObj.NavigateToPage();

        //enter user credentials (username/password)
        LoginPageObj.EnterLoginCredentials();

        //click the log in button
        LoginPageObj.ClickLogIn();

        //Verify the result
        Assert.assertTrue(MainPageObj.GetTextFromPage().contains("Some Message"));

    }


    @Rule
    public TestWatcher listen = new TestWatcher() {

        @Override
        public void failed (Throwable t, Description description){
          System.out.println("Test Failed!");
          System.out.println(description.getClassName() + ", " + description.getMethodName());
        }
    };




}
