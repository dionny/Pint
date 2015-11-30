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

    public T clickBloodDrive(String bloodDrive) throws Exception{
        int index = this.locateGridRow(bloodDrive);
        String cssSelector = "table tbody tr:nth-child(" + (index + 1) + ") td:nth-child(1) a";

        driver.findElement(By.cssSelector(cssSelector)).click();
        return (T)this;
    }

    public T verifyNurseListEntry(String [][]expected, int listCount, int startRow, int startColumn) throws Exception {
        for (int i=0; i<expected.length; i++){
            for (int j=0; j<expected[i].length; j++){
                String cssSelector = "table tbody tr:nth-child(" + (startRow + i + 1) + ") td:nth-child(" + (startColumn + j + 1) + ")";
                String existing = driver.findElement(By.cssSelector(cssSelector)).getText();

                if (!existing.equals(expected[i][j]))
                    throw new Exception();
            }
        }

        return (T)this;
    }

    public T verifyUnassignedNurseListEntry(String [][]expected, int listCount, int startRow, int startColumn) throws Exception {
        for (int i=0; i<expected.length; i++){
            for (int j=0; j<expected[i].length; j++){
                String cssSelector = "div.modal-content table tbody tr:nth-child(" + (startRow + i + 1) + ") td:nth-child(" + (startColumn + j + 1) + ")";
                String existing = driver.findElement(By.cssSelector(cssSelector)).getText();

                if (!existing.equals(expected[i][j]))
                    throw new Exception();


            }
        }

        return (T)this;
    }
}
