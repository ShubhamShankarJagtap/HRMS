package com.example.orangehrms;

import org.testng.Assert;
import org.testng.annotations.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;

public class LoginPageTest {
    private WebDriver driver;
    private LoginPage mainPage;

    @BeforeClass
    public void setUp() {

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void login() {

        mainPage = new LoginPage(driver);
        mainPage.setUser_name("Admin");
        mainPage.setPass_word("admin123");
        mainPage.click_Login_button();
        Assert.assertEquals(driver.getTitle(), "OrangeHRM");
    }
}
