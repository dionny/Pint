package systemtest.pint.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by DionnyS on 11/28/2015.
 */
public class CoordinatorDashboard extends Dashboard<CoordinatorDashboard> {
    public CoordinatorDashboard(WebDriver driver) {
        super(driver);
    }

    public CoordinatorDashboard clickAddNurses() throws Exception{
        driver.findElement(By.cssSelector("button[ng-click*=open]")).click();

        return this;
    }
}
