package Pages;

import Locators.Locator;
import Xpaths.AddBookToBasketConstants;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;


public class AddBookToBasketPage extends Locator implements AddBookToBasketConstants {

    private WebDriverWait wait;
    private WebDriver driver;
    private WebElement webElement;


    public AddBookToBasketPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        wait = new WebDriverWait(driver, 30);
    }

    public void ClickCategories(){

        sleep(500);
        ClickByXpath(clickcategories);
    }

    public void SelectBookCategories(){

        sleep(500);
        ClickByXpath(selectBookCategories);
    }
    public void ClickBookCategories(){

        sleep(500);
        ClickByXpath(clickBookCategories);
    }

    public void ClickBook(){

        sleep(500);
        ClickByXpath(clickBook);
    }
    public void ClickAddToBasket(){

        sleep(500);
        ClickByXpath(addToBasket);
    }
    public void ClickGoToBasket(){

        sleep(500);
        ClickByXpath(goToBasket);
    }
    public void ClickFinishTrade(){
        sleep(500);
        ClickById(finishTrade);
    }
    public void ClickFinishTrade1(){
        sleep(500);
        ClickByXpath(finishTrade1);
    }

    public void ClickNewBooks(){
        sleep(500);
        ClickByCssSelector(newBooks);
    }
    public void SelectRandomBook(){
        sleep(500);
        ClickByCssSelector(selectRandomBook);
    }

    public InstantTransferPage ınstantTransferPage() {

        sleep(1000);
        return new InstantTransferPage(driver);
    }
}
