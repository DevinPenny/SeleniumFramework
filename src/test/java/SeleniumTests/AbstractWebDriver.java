package SeleniumTests;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import PageObjects.CommonObj;

public class AbstractWebDriver {

    protected WebDriver driver;
    protected  CommonObj SelCommonElements;

    @Before
    public void TestSetUp() {
        driver = new FirefoxDriver();
        SelCommonElements = new CommonObj(driver);
        System.out.print("Driver loaded before test");
    }

    @After
    public void testShutDown(){
        driver.close();
        System.out.print("Driver closed after test");
    }

}
