package systemtest.pint.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public abstract class Dashboard {
    private WebDriver driver;

    public Dashboard(WebDriver driver){
        this.driver = driver;
    }

    public String getRoleLabel(){
        return driver.findElement(By.id("roleLabel")).getText();
    }

    public String getUserName(){
        return driver.findElement(By.id("displayName")).getText();
    }

    public String getHospitalName(){
        return driver.findElement(By.id("hospitalName")).getText();
    }

    public Dashboard clickDashboardLink(){
        driver.findElement(By.id("dashboardLink")).click();
        return this;
    }

    public Dashboard clickLogoutButton(){
        driver.findElement(By.id("logoutBtn")).click();
        return this;
    }
}
