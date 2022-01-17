package Pages;

import Locators.Locator;
import Xpaths.InstantTransferConstans;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import java.util.concurrent.TimeUnit;


public class InstantTransferPage extends Locator implements InstantTransferConstans {

    private WebDriverWait wait;
    private WebDriver driver;

    public InstantTransferPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        wait = new WebDriverWait(driver, 30);
    }
    public void controlUrlForPayScreen(){
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        Assert.assertEquals("https://checkout.hepsiburada.com/odeme", driver.getCurrentUrl());
    }
    public void SelectPayTypeAsInstantTransfer(){
        sleep(500);
        ClickByXpath(selectPayType);
    }
    public String chooseBank(String bankName){
        switch (bankName){
            case "Akbank":
                ClickByXpath(akbankAccount);
                break;
            case "Vakıfbank":
                ClickByXpath(ısBankAccount);
                break;
            case "İş Bankası":
                ClickByXpath(vakıfBankAccount);
                break;
            case "Kuveyt Türk":
                ClickByXpath(kuveytTurkAccount);
                break;
            case "AlBaraka Türk":
                ClickByXpath(albarakaTurkAccount);
                break;
        }
        return  bankName ;

    }
    public BasketControlPage basketControlPage() {
        sleep(1000);
        return new BasketControlPage(driver);
    }
}
