package systemtest.pint.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public abstract class Dashboard<T> extends PageObject {

    public Dashboard(WebDriver driver) {
        super(driver);
    }

    public T verifyRoleLabel(String expected) throws Exception {
        verifyText(expected, By.cssSelector("#roleLabel > b"));
        return (T)this;
    }

    public T clickDashboardLink() {
        driver.findElement(By.id("dashboardLink")).click();
        return (T)this;
    }

    public T clickLogoutButton() {
        driver.findElement(By.id("logoutBtn")).click();
        return (T)this;
    }
}
