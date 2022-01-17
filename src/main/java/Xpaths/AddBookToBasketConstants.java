package Xpaths;

public interface AddBookToBasketConstants {

    public String clickcategories= "//*[text()[contains(.,'Kategoriler')]]";
    public String selectBookCategories = "//img[@src='https://images.hepsiburada.net/assets/storefront/navigation/1722_18-04-2019_1555564254467.png']";
    public String clickBookCategories = "//img[@alt='kitaplar']";
    public String clickBook = "//ul[@id='1']//child::li[@id='i0']";
    public String newBooks = ".categoryBanner:nth-child(2) > a";
    public String selectRandomBook = ".search-item:nth-child(2)";
    public String addToBasket = "//span[@class='addToCartButton']";
    public String goToBasket = "//a[@href='https://checkout.hepsiburada.com/sepetim']";
    public String finishTrade = "continue_step_btn";
    public String finishTrade1 = "//a[normalize-space()='Ödeme']";
}
