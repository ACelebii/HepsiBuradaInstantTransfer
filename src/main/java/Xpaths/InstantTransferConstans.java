package Xpaths;

public interface InstantTransferConstans {

    public String selectPayType ="//*[text()='Anında Havale']//ancestor::div[1]";
    public String akbankAccount = "//div[@id='payment-money-transfer']//child::div[2]//child::*[text()[contains(.,'Akbank')]]";
    public String ısBankAccount ="//img[@src=\"https://images.hepsiburada.net/assets/sardes/paymenttype/instantmoney/64.svg\"]";
    public String vakıfBankAccount ="//div[@id='payment-money-transfer']//child::div[3]//child::*[text()[contains(.,'Vakıfbank')]]";
    public String kuveytTurkAccount="//div[@id='payment-money-transfer']//child::div[4]//child::*[text()[contains(.,'Kuveyt Türk')]]";
    public String albarakaTurkAccount="//div[@id='payment-money-transfer']//child::div[5]//child::*[text()[contains(.,'AlBaraka Türk')]]";
}
