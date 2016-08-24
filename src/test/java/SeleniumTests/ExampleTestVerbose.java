package SeleniumTests;

import PageObjects.CommonObj;
import PageObjects.MainPageObj;
import org.junit.*;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


import java.io.IOException;
import java.util.logging.*;

public class ExampleTestVerbose {

WebDriver driver;

private static final Logger logger = Logger.getLogger(ExampleTestVerbose.class.getName());
public Handler fileHandler = null;
public Formatter formatter = null;

public String FilePath = "./test.log";

// Set up Logging and formatting for error handling
// instantiate the web driver
@Before
public void TestSetUp() {

    try {
        fileHandler = new FileHandler(FilePath);
    } catch (IOException e) {
        logger.info("Caught IOException: " + e);
    }

    formatter = new SimpleFormatter();

    fileHandler.setLevel(Level.ALL);
    fileHandler.setFormatter(formatter);

    logger.addHandler(fileHandler);

    driver = new FirefoxDriver();

    logger.info("@Before test setup complete");
}


@After
public void testShutDown() {
    logger.info("@After test shut down");
    driver.close();
}

@Rule
public TestWatcher listen = new TestWatcher() {

    @Override
    public void failed(Throwable t, Description description) {
        System.out.println("Test Failed!");
        System.out.println(description.getClassName() + ", " + description.getMethodName());
    }

};
    // Navigate to the web page, perform an action and verify the result
    @Test
    public void FirstTestToExecute() {
        logger.info("FirstTestToExecute");

        CommonObj Navigation = new CommonObj(driver);
        MainPageObj MainPage = new MainPageObj(driver);

        //Navigate to page
        Navigation.NavigateToPage();


        //Do something on the page
        MainPage.EnterTextInField();

        MainPage.ClickButton();


        //create some sort of assert
        Assert.assertTrue(MainPage.GetTextFromPage().contains("Some Message"));

    }

}
