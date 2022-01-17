package Pages;

import Locators.Locator;
import Xpaths.LoginConstants;
import Xpaths.AddBookToBasketConstants;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends Locator implements LoginConstants , AddBookToBasketConstants {


    private WebDriver driver;
    private WebDriverWait wait;


    public LoginPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        wait = new WebDriverWait(driver, 30);
    }
    public void Username(String name) {
        sleep(1000);
        SendById(usernameTextBox,name);
    }
    public void Password(String password) {
        sleep(1000);
        SendById(passwordTextBox,password);
    }
    public void ClickLoginButtonMail() {
        sleep(1000);
        ClickById(loginButtoMail);
    }
    public void ClickLoginButtonPassword() {
        sleep(1000);
        ClickById(loginButtonPassword);
    }
    public void ClickOrderMenu(){
        sleep(1000);
        ClickByXpath(orderMenu);
    }
    public String  AssertGetAccountName(){
        sleep(1000);

        return GetTextByCssSelector(controlName);
    }
    public AddBookToBasketPage addBookToBasketPage() {

        sleep(1000);
        return new AddBookToBasketPage(driver);
    }
}
