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
        //driver.findElement(By.cssSelector("button[ng-click*=open]")).click();
        clickElement(By.cssSelector("button[ng-click*=open]"));

        return this;
    }

    public CoordinatorDashboard clickAssign() throws Exception{
        clickElement(By.cssSelector("button[ng-click*=ok]"));

        return this;
    }

    public CoordinatorDashboard selectNurse(int row) throws Exception{
        clickElement(By.cssSelector("div.modal-content table tbody tr:nth-child(" + row + ") td:nth-child(1) input"));

        return this;
    }
}
