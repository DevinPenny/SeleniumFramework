package SeleniumTests;

import PageObjects.CommonObj;
import PageObjects.LoginPageObj;
import PageObjects.MainPageObj;


import TestDataManagement.ExcelManager;
import org.junit.*;


import org.junit.rules.TestWatcher;
import org.junit.runner.Description;

import java.util.ArrayList;
import java.util.List;


public class ExampleExcelTest extends AbstractWebDriver {


    CommonObj Navigate = new CommonObj(driver);
    LoginPageObj Login = new LoginPageObj(driver);
    MainPageObj MainPage = new MainPageObj(driver);

    //eventually get this from properties manager
    String excelPath = "src/test/java/TestDataManagement/ExcelData/automationExample.xlsx";

    TestDataManagement.ExcelManager excelFileHandler;

    @Before
    public void getTestData(){
        excelFileHandler = new ExcelManager();

    }

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
    public void workWithExcel(){
        List<List<String>> data = excelFileHandler.readFromFile(excelPath);

        List<String> results = new ArrayList<String>();
        results.add("Results");


        System.out.println("excel data: " + data);
        System.out.println(System.getProperty("os.name"));

        for (int i = 1; i < data.size(); i++ ){
            for (int j = 0; j < data.get(i).size(); j++){
                //System.out.println("excel data: i=" + i + " " + data.get(i) + " " + data.get(j));
                //System.out.println("excel data: " + data.get(2).get(2));
                //do data driven things from here
                //System.out.println("excel data: " + data);



            }
        }


    }
/*
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
    */
}
