package PageObjects;

import org.openqa.selenium.WebDriver;


public class AbstractPage {

    protected WebDriver driver;

    public AbstractPage (WebDriver driver) {
        this.driver = driver;
    }

    public WebDriver getDriver() {
        return driver;
    }

    public AbstractPage NavigateToPage() {
        driver.navigate().to("www.google.com");
        return new AbstractPage(driver);
    }
}
