package Pages;

import Locators.Locator;
import Xpaths.HomeConstants;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends Locator implements HomeConstants {

    private WebDriverWait wait;
    private WebDriver driver;

    public HomePage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        wait = new WebDriverWait(driver, 30);
    }
    public void AccountSıgnIn(){
        sleep(1000);
        driver.get(accountSıgnIn);
    }
    public LoginPage loginPage() {

        sleep(1000);
        return new LoginPage(driver);
    }
}
