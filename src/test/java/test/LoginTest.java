package test;

import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import page.LoginPage;


public class LoginTest {
    public ChromeDriver driver;

    @Test
    public void SuccessLoginTest() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginValidUser("andrew.antonovs@gmail.com", "password");
    }

}

