package PageObjects;

import org.openqa.selenium.WebDriver;

public class CommonObj {

    protected WebDriver driver;

    public CommonObj(WebDriver driver) {
        this.driver = driver;
    }

    public WebDriver getDriver() {
        return driver;
    }

    public CommonObj NavigateToPage() {
        driver.navigate().to("www.google.com");
        return new CommonObj(driver);
    }
}
