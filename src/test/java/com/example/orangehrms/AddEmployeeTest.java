package com.example.orangehrms;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class AddEmployeeTest extends LoginPageTest {

    public Add_Employee addEmployee;
    public WebDriver driver;

    @BeforeClass
    public void setup(){

        this.driver = super.setUp();
        super.login();
    }

    @Test
    public void addEmployee(){

        addEmployee = new Add_Employee(driver);
        addEmployee.click_pim_button();
        addEmployee.click_addEmployee();
        addEmployee.setFirst_Name("Dwayne");
        addEmployee.setMiddle_Name("Cody");
        addEmployee.setLast_Name("Johnson");
        addEmployee.clickSaveButton();
    }
}
