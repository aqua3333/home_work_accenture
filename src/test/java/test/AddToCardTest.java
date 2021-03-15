package test;

import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import page.ProductPage;

public class AddToCardTest {


    public ChromeDriver driver;

    @Test
    public void AddToCardNikonD300Test() {
        ProductPage ProductPage = new ProductPage(driver);
        ProductPage.addToCardProduct();
    }
}