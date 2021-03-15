package page;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;
import com.codeborne.selenide.Selenide;
import org.openqa.selenium.chrome.ChromeDriver;

import static com.codeborne.selenide.Selenide.element;
import static com.codeborne.selenide.Selenide.open;

public class SearchPage {
    public ChromeDriver driver;

    private final By searchField = By.cssSelector(".form-control.input-lg");
    private final By searchBtn = By.cssSelector(".btn.btn-default.btn-lg");
    private final By productNameInSearchProductList = By.cssSelector("#content > div:nth-child(8) > div > div > div:nth-child(2) > div.caption > h4 > a");
    private final By productPriceBlock = By.cssSelector("#content > div:nth-child(8) > div > div > div:nth-child(2) > div.caption > p.price");
    private final By productTaxPriceBlock = By.cssSelector("#content > div:nth-child(8) > div > div > div:nth-child(2) > div.caption > p.price > span");
    private final By webShopTitleSelector = By.cssSelector("#logo > h1 > a");

    private static String mainPageUrl = "http://www.demoshop24.com";
    private static String webShopName = "Testing Demo Shop";

    public SearchPage(ChromeDriver driver) {
        this.driver = driver;
    }

    /**
     * SearchProductByName
     *
     * @param productName
     */
    public void SearchValidProductByFullName(String productName) {
        open(mainPageUrl);

        Selenide.$(searchField).setValue(productName);
        Selenide.$(webShopTitleSelector).shouldBe(Condition.visible).shouldHave(Condition.text(webShopName));
        Selenide.$(searchBtn).click();
        Selenide.$(element(productNameInSearchProductList).shouldBe(Condition.visible).shouldHave(Condition.text(productName)));
        String grabPriceFromProductBlock = Selenide.$(element(productPriceBlock)).getText();
        String grabTaxPriceFromProductBlock = Selenide.$(element(productTaxPriceBlock)).getText();
        grabPriceFromProductBlock = grabPriceFromProductBlock.replace(grabTaxPriceFromProductBlock, "");
        Selenide.$(element(productPriceBlock).shouldHave(Condition.text(grabPriceFromProductBlock)));
        Selenide.$(element("[value='" + productName + "']").shouldHave(Condition.visible));

    }

}
