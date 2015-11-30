package systemtest.pint.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NurseDashboard  extends Dashboard<NurseDashboard> {
    public NurseDashboard(WebDriver driver) {
        super(driver);
    }

    /*public NurseDashboard clickBloodDrive(String bloodDrive) throws Exception{
        int index = this.locateGridRow(bloodDrive);
        String cssSelector = "table tbody tr:nth-child(" + (index + 1) + ") td:nth-child(1) a";

        driver.findElement(By.cssSelector(cssSelector)).click();
        return this;
    }*/

    public NurseDashboard clickInputDonor() throws Exception{
        driver.findElement(By.cssSelector("button[ng-click*=open]")).click();

        return this;
    }

    public NurseDashboard setEmail(String email){
        driver.findElement(By.cssSelector("input[ng-model*=email")).clear();
        driver.findElement(By.cssSelector("input[ng-model*=email")).sendKeys(email);
        return this;
    }

    public NurseDashboard clickAddEmployee(){
        driver.findElement(By.cssSelector("button[ng-click*=employeeForm")).click();

        return this;
    }
}