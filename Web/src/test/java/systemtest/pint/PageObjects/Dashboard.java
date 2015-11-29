package systemtest.pint.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public abstract class Dashboard extends PageObject {

    public Dashboard(WebDriver driver) {
        super(driver);
    }

    public void verifyRoleLabel(String expected) throws Exception {
        verifyText(expected, By.cssSelector("#roleLabel > b"));
    }

    public String getUserName() {
        return driver.findElement(By.id("displayName")).getText();
    }

    public String getHospitalName() {
        return driver.findElement(By.id("hospitalName")).getText();
    }

    public Dashboard clickDashboardLink() {
        driver.findElement(By.id("dashboardLink")).click();
        return this;
    }

    public Dashboard clickLogoutButton() {
        driver.findElement(By.id("logoutBtn")).click();
        return this;
    }
}
