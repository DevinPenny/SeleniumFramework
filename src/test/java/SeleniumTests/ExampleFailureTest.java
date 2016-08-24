package SeleniumTests;

import PageObjects.CommonObj;
import PageObjects.LoginPageObj;
import PageObjects.MainPageObj;


import org.junit.*;


import org.junit.rules.TestWatcher;
import org.junit.runner.Description;


public class ExampleFailureTest extends AbstractWebDriver {

    CommonObj Navigate = new CommonObj(driver);
    LoginPageObj Login = new LoginPageObj(driver);
    MainPageObj MainPage = new MainPageObj(driver);

    @Rule
    public TestWatcher listen = new TestWatcher() {

        @Override
        public void failed (Throwable t, Description description){
            System.out.println("Test Failed!");
            System.out.println(description.getClassName() + ", " + description.getMethodName());
            //report error to test management tool here

        }
    };

    @Test
    public void FirstTestToExecute() {

        //navigate to page
        Navigate.NavigateToPage();

        //enter user credentials (username/password)
        Login.EnterLoginCredentials();

        //click the log in button
        Login.ClickLogIn();

        //Verify the result
        Assert.assertTrue(MainPage.GetTextFromPage().contains("Some Message"));

    }
}
