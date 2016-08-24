package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPageObj extends CommonObj {

    WebDriver driver;

    public String Str_loginName = "user";
    public String Str_passWord = "password";

    public String Sel_UserName = "username";
    public String Sel_PassWord = "password";
    public String Sel_Submit = "submit";

    public LoginPageObj(WebDriver driver){
        super(driver);
    }

    public void EnterLoginCredentials() {
        //enter user name and password
       driver.findElement(By.id(Sel_UserName)).sendKeys(Str_loginName);
       driver.findElement(By.id(Sel_PassWord)).sendKeys(Str_passWord);
    }

    public void ClickLogIn() {
       //click log in button
        driver.findElement(By.className(Sel_Submit)).click();
    }
}
