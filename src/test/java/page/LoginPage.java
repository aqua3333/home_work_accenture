package page;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;
import com.codeborne.selenide.Selenide;

import static com.codeborne.selenide.Selenide.element;
import static com.codeborne.selenide.Selenide.open;

import org.openqa.selenium.chrome.ChromeDriver;

public class LoginPage {
    public ChromeDriver driver;

    private final By usernameField = By.cssSelector("#input-email");
    private final By passwordField = By.cssSelector(("#input-password"));
    private final By loginInBtn = By.cssSelector("[type='submit']");
    private final By myAccountSection = By.cssSelector("#content > h2:nth-child(1)");
    private final By webShopTitleSelector = By.cssSelector("#logo > h1 > a");

    private static String myAccountSectionName = "My Account";
    private static String loginPageUrl = "http://www.demoshop24.com/index.php?route=account/login";
    private static String webShopName = "Testing Demo Shop";

    public LoginPage(ChromeDriver driver) {
        this.driver = driver;
    }

    /**
     * Login as valid use
     *
     * @param userName
     * @param password
     */
    public void loginValidUser(String userName, String password) {
        open(loginPageUrl);
        Selenide.$(webShopTitleSelector).shouldBe(Condition.visible).shouldHave(Condition.text(webShopName));
        Selenide.$(usernameField).setValue(userName);
        Selenide.$(passwordField).setValue(password);
        Selenide.$(loginInBtn).click();
        Selenide.$(element(myAccountSection).shouldBe(Condition.visible).shouldHave(Condition.text(myAccountSectionName)));
    }

}
