package systemtest.pint.PageObjects;

import com.google.common.base.Stopwatch;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

/**
 * Created by DionnyS on 11/28/2015.
 */
public class PageObject {

    protected WebDriver driver;

    public PageObject(WebDriver driver) {
        this.driver = driver;
    }

    protected int locateGridRow(String searchCriteria) throws Exception {
        Exception lastCaught = null;
        Stopwatch watch = Stopwatch.createStarted();
        while (watch.elapsed(TimeUnit.MILLISECONDS) < 15000) {
            try {
                Object ret = ((JavascriptExecutor) driver)
                        .executeScript("return $(\"table tbody tr:contains(" + searchCriteria + ")\").index()");

                int index = Integer.parseInt(ret.toString());

                if (index == -1) {
                    throw new Exception();
                }

                return index;
            } catch (Exception e) {
                lastCaught = e;
            }

            Thread.sleep(100);
        }

        throw lastCaught;
    }

    protected void verifyText(String expected, By selector) throws Exception {
        Exception lastCaught = null;
        Stopwatch watch = Stopwatch.createStarted();
        while (watch.elapsed(TimeUnit.MILLISECONDS) < 15000) {
            try {
                String actual = driver.findElement(selector).getText();
                if (!expected.equals(actual)) {
                    throw new Exception("Expected " + expected + " to equal: " + actual);
                }

                return;
            } catch (Exception e) {
                lastCaught = e;
            }

            Thread.sleep(100);
        }

        throw lastCaught;
    }

    protected void verifyElementExists(By selector) throws Exception {
        Exception lastCaught = null;
        Stopwatch watch = Stopwatch.createStarted();
        while (watch.elapsed(TimeUnit.MILLISECONDS) < 15000) {
            try {
                driver.findElement(selector);

                return;
            } catch (Exception e) {
                lastCaught = e;
            }

            Thread.sleep(100);
        }

        throw lastCaught;
    }
}
