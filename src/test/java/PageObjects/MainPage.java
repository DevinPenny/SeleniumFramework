package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage extends AbstractPage {


    public static final String ClickButtonSelector = "SomeSelector";
    public static final String EnterTextInFieldSelector = "SomeSelector";
    public static final String GetTextFromPageSelector = "SomeSelector";

    public MainPage(WebDriver driver){
        super(driver);

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
