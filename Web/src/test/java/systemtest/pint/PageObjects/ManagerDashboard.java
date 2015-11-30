package systemtest.pint.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by DionnyS on 11/29/2015.
 */
public class ManagerDashboard extends Dashboard<ManagerDashboard> {
    public ManagerDashboard(WebDriver driver) {
        super(driver);
    }

    public void verifyEmployeeExists(String searchCriteria) throws Exception {
        int index = locateGridRow(searchCriteria);
        String cssSelector = "table tbody tr:nth-child(" + (index + 1) + ")";
        verifyElementExists(By.cssSelector(cssSelector));
    }
}
