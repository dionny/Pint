package systemtest.pint.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import systemtest.pint.Infrastructure.DbHelper;

import java.io.FileNotFoundException;
import java.util.concurrent.TimeUnit;

/**
 * Created by DionnyS on 11/28/2015.
 */

public class PintApplication {
    private WebDriver driver;

    public PintApplication() {
    }

    public void launch() throws FileNotFoundException {
        // Restore the database.
        new DbHelper().executeScript();

        driver = new ChromeDriver();
        driver.navigate().to("http://localhost:8080");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    public void quit() throws FileNotFoundException {
        // Restore the database.
        new DbHelper().executeScript();

        driver.quit();
    }

    public LoginPage loginPage() {
        return new LoginPage(driver);
    }

    public CoordinatorDashboard coordinatorDashboard() {
        return new CoordinatorDashboard(driver);
    }

    public ManagerDashboard managerDashboard() {
        return new ManagerDashboard(driver);
    }
}

