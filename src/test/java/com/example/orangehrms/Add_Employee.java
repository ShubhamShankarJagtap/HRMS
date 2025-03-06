package com.example.orangehrms;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.List;

public class Add_Employee {

    @FindBy(xpath = "//span[text()='PIM']")
    public WebElement Pim;

    @FindBy(linkText = "Add Employee")
    public WebElement addEmployee;

    @FindBy(name = "firstName")
    public WebElement first_Name;

    @FindBy(name = "middleName")
    public WebElement middle_Name;

    @FindBy(name = "lastName")
    public WebElement last_Name;

    @FindBy(xpath = "//*[@type='submit']")
    public WebElement save_Button;

    public Add_Employee(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
    
    public void click_pim_button(){

        Pim.click();
    }

    public void click_addEmployee(){

        addEmployee.click();
    }

    public void setFirst_Name(String firstName) {
        first_Name.sendKeys(firstName);
    }

    public void setMiddle_Name(String middleName){

        middle_Name.sendKeys(middleName);
    }

    public void setLast_Name(String LastName) {
        last_Name.sendKeys(LastName);
    }

    public void clickSaveButton(){

        save_Button.click();
    }
}