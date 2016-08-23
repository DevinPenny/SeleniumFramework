package SeleniumTests;

import PageObjects.AbstractPage;
import PageObjects.MainPage;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


import java.io.IOException;
import java.util.logging.*;

public class ExampleTest {

    WebDriver driver;

    private static final Logger logger = Logger.getLogger(ExampleTest.class.getName());
    Handler fileHandler = null;
    Formatter formatter = null;

    public String FilePath = "./test.log";

   // Set up Logging and formatting for error handling
   // instantiate the web driver
    @Before
    public void TestSetUp(){

        try {
            fileHandler = new FileHandler(FilePath);
        }catch (IOException e){
            logger.info("Caught IOException: " + e);
        }

        formatter = new SimpleFormatter();

        fileHandler.setLevel(Level.ALL);
        fileHandler.setFormatter(formatter);

        logger.addHandler(fileHandler);
        logger.info("@Before Begin Test");

        driver = new FirefoxDriver();
    }


    @After
    public void testShutDown(){
        logger.info("@After Exit Test");
        driver.close();
    }

    // Navigate to the web page, perform an action and verify the result
    @Test
    public void FirstTestToExecute() {
        logger.info("FirstTestToExecute");

        AbstractPage AbstractPageObject = new AbstractPage(driver);

        AbstractPageObject.NavigateToPage();

       // MainPageObject.EnterTextInField();
       // MainPageObject.ClickButton();
       // MainPageObject.GetTextFromPage();

        //Assert.assertTrue(MainPageObject.GetTextFromPage().contains("Some Message"));

    }
}
