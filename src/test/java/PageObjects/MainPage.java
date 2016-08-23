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

    public MainPage ClickButton(){
        driver.findElement(By.id(ClickButtonSelector)).click();
        return new MainPage(driver);
    }

    public MainPage EnterTextInField() {
        driver.findElement(By.id(EnterTextInFieldSelector)).sendKeys("SomeText");
        return new MainPage(driver);
    }

    public String GetTextFromPage() {

        return driver.findElement(By.id(GetTextFromPageSelector)).getText();

    }

}
