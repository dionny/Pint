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

    public T clickDashboardLink() throws Exception {
        clickElement(By.id("dashboardLink"));
        return (T)this;
    }

    public T clickCreateEmployee() throws Exception {
        clickElement(By.id("add-employee-button"));
        return (T)this;
    }

    public T clickLogoutButton() throws Exception {
        clickElement(By.id("logoutBtn"));
        return (T)this;
    }
}
