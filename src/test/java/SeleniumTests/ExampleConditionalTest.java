package SeleniumTests;


import PageObjects.CommonObj;
import PageObjects.LoginPageObj;
import PageObjects.MainPageObj;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;


//this is a method to create a test that will check if it needs to run or not beforehand

public class ExampleConditionalTest extends AbstractWebDriver {


    //set up excel reader
    String excelPath = "src/test/java/TestDataManagement/ExcelData/automationExample.xlsx";
    TestDataManagement.ExcelManager excelFileHandler;



    CommonObj Navigate = new CommonObj(driver);
    LoginPageObj Login = new LoginPageObj(driver);
    MainPageObj MainPage = new MainPageObj(driver);


    @Rule
    public ConditionalIgnoreRule rule = new ConditionalIgnoreRule();

    @Test
    @ConditionalIgnoreRule.ConditionalIgnore(condition = workWithExcel.class)
    public void testThatCanBeFilteredOut() {

        System.out.println("The test has executed!");

        //put your test steps here like normal
    }


    public class workWithExcel implements ConditionalIgnoreRule.IgnoreCondition {

        public boolean isSatisfied() {


            //work with excel here
            List<List<String>> data = excelFileHandler.readFromFile(excelPath);

            List<String> results = new ArrayList<String>();
            results.add("Results");


            System.out.println("excel data: " + data);
            System.out.println(System.getProperty("os.name"));


            return !System.getProperty("os.name").startsWith("Windows");

        }
    }

}

