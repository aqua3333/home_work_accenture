
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.chrome.ChromeDriver;
import page.ProductPage;
import page.LoginPage;
import page.SearchPage;


public class WebDriverSettings {
    public ChromeDriver driver;
    public ProductPage productPage;
    public LoginPage loginPage;
    public SearchPage searchPage;


    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "/home/aantonovs/Documents/chromedriver");
        driver = new ChromeDriver();
        productPage = new ProductPage(driver);
        loginPage = new LoginPage(driver);
        searchPage = new SearchPage(driver);
    }

    @After
    public void endTest() {
        driver.quit();
    }
}
