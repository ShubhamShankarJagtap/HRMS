package com.example.orangehrms;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

// page_url = https://www.jetbrains.com/
public class LoginPage {

    WebDriver driver;

    LoginPage(WebDriver driver){

        this.driver=driver;
    }

    By user_name = By.xpath("//input[@name='username']");
    By pass_word = By.xpath("//input[@type='password']");
    By login_button = By.xpath("//button[@type='submit']");

    public void setUser_name(String username) {
        driver.findElement(user_name).sendKeys(username);
    }

    public void setPass_word(String password) {
        driver.findElement(pass_word).sendKeys(password);
    }

    public void click_Login_button() {
        driver.findElement(login_button).click();
    }
}
