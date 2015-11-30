package systemtest.pint.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by Sajib on 11/29/2015.
 */
public class CreateEmployeePage  extends PageObject {

    public CreateEmployeePage(WebDriver driver){
        super(driver);
    }

    public CreateEmployeePage setEmailAddress(String emailaddress){
        driver.findElement(By.id("username")).clear();
        driver.findElement(By.id("username")).sendKeys(emailaddress);
        return this;
    }

    public CreateEmployeePage setPassword(String password){
        driver.findElement(By.id("password")).clear();
        driver.findElement(By.id("password")).sendKeys(password);
        return this;
    }

    public CreateEmployeePage setFirstName(String firstname){
        driver.findElement(By.id("firstName")).clear();
        driver.findElement(By.id("firstName")).sendKeys(firstname);
        return this;
    }

    public CreateEmployeePage setLastName(String lastname){
        driver.findElement(By.id("lastName")).clear();
        driver.findElement(By.id("lastName")).sendKeys(lastname);
        return this;
    }

    public CreateEmployeePage setPhoneNumber(String phonenumber){
        driver.findElement(By.id("phoneNumber")).clear();
        driver.findElement(By.id("phoneNumber")).sendKeys(phonenumber);
        return this;
    }

    public CreateEmployeePage setRole(String role){
        driver.findElement(By.id("role")).sendKeys(role);
        return this;
    }

    public CreateEmployeePage clickAdd() {
        driver.findElement(By.cssSelector("button[ng-click*=employeeForm]")).click();
        return this;
    }

    public CreateEmployeePage clickCancel() {
        driver.findElement(By.cssSelector("button[ng-click*=cancel]")).click();
        return this;
    }
}