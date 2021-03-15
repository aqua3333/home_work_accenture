package test;

import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import page.SearchPage;


public class SearchTest {

    public ChromeDriver driver;

    @Test
    public void searchNikonCamera() {
        SearchPage SearchPage = new SearchPage(driver);
        SearchPage.SearchValidProductByFullName("Nikon D300");
    }

    @Test
    public void searchMacBookPro() {
        SearchPage SearchPage = new SearchPage(driver);
        SearchPage.SearchValidProductByFullName("MacBook Pro");
    }
}










