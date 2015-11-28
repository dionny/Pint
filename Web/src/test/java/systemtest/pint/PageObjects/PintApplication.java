package systemtest.pint.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

/**
 * Created by DionnyS on 11/28/2015.
 */

public class PintApplication {
    private WebDriver driver;

    public PintApplication() {
    }

    public void launch() {
        driver = new ChromeDriver();
        driver.navigate().to("http://localhost:8080");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    public void quit() {
        driver.quit();
    }

    public LoginPage loginPage() {
        return new LoginPage(driver);
    }

    public CoordinatorDashboard coordinatorDashboard() {
        return new CoordinatorDashboard(driver);
    }
}
