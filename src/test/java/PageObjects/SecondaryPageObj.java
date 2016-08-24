package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SecondaryPageObj extends CommonObj {


    public static final String ClickButton = "SecondarySelector";
    public static final String EnterTextInField = "SecondarySelector";
    public static final String GetTextFromPage = "SecondarySelector";

    public SecondaryPageObj(WebDriver driver){
        super(driver);

    }

    public SecondaryPageObj ClickSecondaryButton(){

        try {
            driver.findElement(By.id(ClickButton)).click();
        } catch (Exception e) {
           System.out.println ("Failed to find element");
        }

        return new SecondaryPageObj(driver);
    }

    public SecondaryPageObj EnterTextInSecondaryField() {
        driver.findElement(By.id(EnterTextInField)).sendKeys("SecondaryText");
        return new SecondaryPageObj(driver);
    }

    public String GetTextFromSecondaryPage() {

        return driver.findElement(By.id(GetTextFromPage)).getText();

    }

}
