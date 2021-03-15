package page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.element;
import static com.codeborne.selenide.Selenide.open;

import org.junit.Assert;
import org.openqa.selenium.chrome.ChromeDriver;

public class ProductPage {
    public ChromeDriver driver;

    private final By camerasProductNameInNavBar = By.cssSelector(".collapse.navbar-collapse.navbar-ex1-collapse > ul > li:nth-child(7) > a");
    private final By productNameTitle = By.cssSelector("#content > div:nth-child(3) > div:nth-child(2) > div > div:nth-child(2) > div.caption > h4 > a");
    private final By addToCardBtn = By.cssSelector("#content > div:nth-child(3) > div:nth-child(2) > div > div:nth-child(2) > div.button-group > button:nth-child(1)");
    private final By alertMessage = By.cssSelector(".alert-dismissible");
    private final By productFullPriceInBlock = By.cssSelector("#content > div:nth-child(3) > div:nth-child(2) > div > div:nth-child(2) > div.caption > p.price");
    private final By productTaxPriceInBlock = By.cssSelector("#content > div:nth-child(3) > div:nth-child(2) > div > div:nth-child(2) > div.caption > p.price > span");
    private final By shoppingCartBtn = By.cssSelector(".btn-lg.dropdown-toggle");
    private final By productQuantityField = By.cssSelector("#cart > ul > li:nth-child(1) > table > tbody > tr > td:nth-child(3)");
    private final By priceProductField = By.cssSelector("#cart > ul > li:nth-child(1) > table > tbody > tr > td:nth-child(4)");
    private final By productNameField = By.cssSelector("#cart > ul > li:nth-child(1) > table > tbody > tr > td.text-left > a");
    private final By totalPriceField = By.cssSelector("#cart > ul > li:nth-child(2) > div > table > tbody > tr:nth-child(4) > td:nth-child(2)");
    private final By webShopTitleSelector = By.cssSelector("#logo > h1 > a");

    private static String alertMessageText = "Success: You have added Nikon D300 to your shopping cart!";
    private static String productName = "Nikon D300";
    private static String productQuantity = "x 1";
    private static String mainPageUrl = "http://www.demoshop24.com";
    private static String webShopName = "Testing Demo Shop";


    public ProductPage(ChromeDriver driver) {
        this.driver = driver;
    }

    public void addToCardProduct() {

        open(mainPageUrl);
        Selenide.$(webShopTitleSelector).shouldBe(Condition.visible).shouldHave(Condition.text(webShopName));
        Selenide.element(camerasProductNameInNavBar).click();
        Selenide.$(element(productNameTitle).shouldBe(Condition.visible).shouldHave(Condition.text(productName)));
        Selenide.element(addToCardBtn).click();
        Selenide.$(element(alertMessage).shouldBe(Condition.visible).shouldHave(Condition.text(alertMessageText)));
        String grabPriceFromElement = Selenide.element(productFullPriceInBlock).getText();
        String grabTaxPriceFromProductBlock = Selenide.$(element(productTaxPriceInBlock)).getText();
        String priceWithoutTax = grabPriceFromElement.replace(grabTaxPriceFromProductBlock, "");

        Selenide.element(shoppingCartBtn).click();
        String grabProductName = Selenide.$(element(productNameField)).getText();
        Assert.assertEquals("Verify that product name in title are equal with product", grabProductName, productName);

        Selenide.$(element(productQuantityField)).shouldHave(Condition.text(productQuantity));
        Selenide.$(element(priceProductField).shouldHave(Condition.text(priceWithoutTax)));
        Selenide.$(element(productNameField)).shouldHave(Condition.text(productName));
        Selenide.$(element(totalPriceField)).shouldHave(Condition.text(priceWithoutTax));

    }
}
