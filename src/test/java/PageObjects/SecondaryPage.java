package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SecondaryPage extends AbstractPage {


    public static final String ClickButton = "SecondarySelector";
    public static final String EnterTextInField = "SecondarySelector";
    public static final String GetTextFromPage = "SecondarySelector";

    public SecondaryPage(WebDriver driver){
        super(driver);

    }

    public SecondaryPage ClickSecondaryButton(){

        try {
            driver.findElement(By.id(ClickButton)).click();
        } catch (Exception e) {
            Logger.log(Level.SEVERE, "Failed to find element ", e);
        }

        return new SecondaryPage(driver);
    }

    public SecondaryPage EnterTextInSecondaryField() {
        driver.findElement(By.id(EnterTextInField)).sendKeys("SecondaryText");
        return new SecondaryPage(driver);
    }

    public String GetTextFromSecondaryPage() {

        return driver.findElement(By.id(GetTextFromPage)).getText();

    }

}
