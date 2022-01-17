package Tests;

import ErrorDictionary.errorReport;
import Pages.*;
import Users.AccountInformation;
import Users.UserPool;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;


public class MainTest extends InitialTest implements errorReport {

    WebDriverWait wait;
    WebDriver driver;

    @Test
    public void T01_Instant_Transfer_Steps_HepsiBurada(){

        setUp("chrome");
        logger.info("Case 1 : Enter Login Hepsi Burada");
        logger.info("Go To Hepsi Burada Login Screen");
        homePage.AccountSıgnIn();
        LoginPage loginPage = homePage.loginPage();

        logger.info("Set Mail and Password in Login Screen");
        AccountInformation accountInformation = UserPool.getUserFirst();
        loginPage.Username(accountInformation.getEmail());
        loginPage.ClickLoginButtonMail();
        loginPage.Password(accountInformation.getPassword());
        loginPage.ClickLoginButtonPassword();

        logger.info("Check Successful login Control");
        loginPage.ClickOrderMenu();
        String accountName = loginPage.AssertGetAccountName();
        Assert.assertEquals( accountName ,"ahmet celebi");
        AddBookToBasketPage addBookToBasketPage = loginPage.addBookToBasketPage();

        logger.info("Go To Books Page");
        addBookToBasketPage.ClickCategories();
        addBookToBasketPage.SelectBookCategories();
        addBookToBasketPage.ClickBookCategories();

        logger.info("Add Book to Basket ");
        addBookToBasketPage.ClickNewBooks();
        addBookToBasketPage.SelectRandomBook();
        addBookToBasketPage.ClickAddToBasket();
        addBookToBasketPage.ClickGoToBasket();
        addBookToBasketPage.ClickFinishTrade();
        addBookToBasketPage.ClickFinishTrade1();

        InstantTransferPage ınstantTransferPage = addBookToBasketPage.ınstantTransferPage();

        logger.info("Select Bank for Instant Transfer");
        ınstantTransferPage.controlUrlForPayScreen();
        ınstantTransferPage.SelectPayTypeAsInstantTransfer();
        String bankName = ınstantTransferPage.chooseBank("Akbank");
        addBookToBasketPage.ClickFinishTrade();

        logger.info("Control Back Account Name in Summary Screen");
        BasketControlPage basketControlPage = ınstantTransferPage.basketControlPage();
        basketControlPage.ControlAccountName(bankName);

    }
}
