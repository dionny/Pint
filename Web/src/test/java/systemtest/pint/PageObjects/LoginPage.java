package systemtest.pint.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends PageObject {

    public LoginPage(WebDriver driver){
        super(driver);
    }

    public LoginPage setUserName(String username){
        driver.findElement(By.id("inputEmail")).clear();
        driver.findElement(By.id("inputEmail")).sendKeys(username);
        return this;
    }

    public LoginPage setPassword(String password){
        driver.findElement(By.id("inputPassword")).clear();
        driver.findElement(By.id("inputPassword")).sendKeys(password);
        return this;
    }

    public LoginPage clickSignIn() {
        driver.findElement(By.cssSelector("button[ng-click*=login]")).click();
        return this;
    }
}
