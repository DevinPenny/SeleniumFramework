package SeleniumTests;

import PageObjects.AbstractPage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.IOException;
import java.util.logging.*;

public class ExampleTest2 {

    WebDriver driver;

    private static final Logger logger = Logger.getLogger(ExampleTest2.class.getName());
    public Handler fileHandler = null;
    public Formatter formatter = null;

    public String FilePath = "./test.log";

    // Set up Logging and formatting for error handling
    // instantiate the web driver
    @Before
    public void TestSetUp(){

        driver = new FirefoxDriver();

       try {
           fileHandler = new FileHandler(FilePath);
       }catch (IOException e){
           logger.info("Caught IOException: " + e);
       }

        formatter = new SimpleFormatter();

        fileHandler.setLevel(Level.ALL);
        fileHandler.setFormatter(formatter);

        logger.addHandler(fileHandler);

        logger.info("@Before test setup complete");
    }


    @After
    public void testShutDown(){
        logger.info("@After test shut down");
        driver.close();
    }

    // Navigate to the web page, perform an action and verify the result
    @Test
    public void FirstTestToExecute() {
        logger.info("FirstTestToExecute");

        AbstractPage AbstractObject = new AbstractPage(driver);


        //MainPage MainPageObject = new MainPage(driver);
        //LoginPageObject LoginPageObject = new LoginPageObject(driver);


        //navigate to map view
        //MapViewAbstractObject.NavigateToMapView();

        //enter user credentials (username/password)
        //MapViewAbstractObject.EnterLoginCredentials1();

        //click the log in button
        //MapViewAbstractObject.ClickLogIn1();

        //create some sort of assert
        //Assert.assertTrue(MainPageObject.GetTextFromPage().contains("Some Message"));

    }

}