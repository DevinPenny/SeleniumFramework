package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPageObj {

    WebDriver driver;

    public static final String ClickButtonSelector = "SomeSelector";
    public static final String EnterTextInFieldSelector = "SomeSelector";
    public static final String GetTextFromPageSelector = "SomeSelector";

    public MainPageObj(WebDriver driver) {
        this.driver = driver;
    }


    public void ClickButton(){
        driver.findElement(By.id(ClickButtonSelector)).click();

    }

    public void EnterTextInField() {
        driver.findElement(By.id(EnterTextInFieldSelector)).sendKeys("SomeText");
    }

    public String GetTextFromPage() {

        return driver.findElement(By.id(GetTextFromPageSelector)).getText();

    }

}
