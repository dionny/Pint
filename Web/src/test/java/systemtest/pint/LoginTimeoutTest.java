package systemtest.pint;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.*;
import systemtest.pint.PageObjects.PintApplication;

/**
 * Created by Sajib on 11/30/2015.
 */
public class LoginTimeoutTest {
    PintApplication pint = new PintApplication();

    @Before
    public void fixtureSetUp() throws Exception {
        pint.launch();
    }

    @After
    public void fixtureTearDown() throws Exception {
        pint.quit();
    }

    @Test
    public void testLoginTimeout_SD01() throws Exception {
        pint.loginPage()
                .setUserName("mhaki005@pint.edu")
                .setPassword("Pintpass12")
                .clickSignIn();
        Thread.sleep(500);

        pint.loginPage()
                .setUserName("mhaki005@pint.edu")
                .setPassword("Pintpass12")
                .clickSignIn();
        Thread.sleep(500);

        pint.loginPage()
                .setUserName("mhaki005@pint.edu")
                .setPassword("Pintpass12")
                .clickSignIn();
        Thread.sleep(500);

        pint.loginPage()
                .setUserName("mhaki005@pint.edu")
                .setPassword("Pintpass12")
                .clickSignIn();
        Thread.sleep(500);

        pint.loginPage()
                .setUserName("mhaki005@pint.edu")
                .setPassword("Pintpass123")
                .clickSignIn();
    }

    @Test
    public void testLoginTimeout_SD02() throws Exception {
        pint.loginPage()
                .setUserName("mhaki005@pint.edu")
                .setPassword("Pintpass12")
                .clickSignIn();
        Thread.sleep(500);

        pint.loginPage()
                .setUserName("mhaki005@pint.edu")
                .setPassword("Pintpass12")
                .clickSignIn();
        Thread.sleep(500);

        pint.loginPage()
                .setUserName("mhaki005@pint.edu")
                .setPassword("Pintpass12")
                .clickSignIn();
        Thread.sleep(500);

        pint.loginPage()
                .setUserName("mhaki005@pint.edu")
                .setPassword("Pintpass12")
                .clickSignIn();
        Thread.sleep(500);

        pint.loginPage()
                .setUserName("mhaki005@pint.edu")
                .setPassword("Pintpass123")
                .clickSignIn();
    }

    @Test
    public void testLoginTimeout_RD01() throws Exception {
        pint.loginPage()
                .setUserName("mhaki005@pint.edu")
                .setPassword("Pintpass12")
                .clickSignIn();
        Thread.sleep(500);

        pint.loginPage()
                .setUserName("mhaki005@pint.edu")
                .setPassword("Pintpass12")
                .clickSignIn();
        Thread.sleep(500);

        pint.loginPage()
                .setUserName("mhaki005@pint.edu")
                .setPassword("Pintpass12")
                .clickSignIn();
        Thread.sleep(500);

        pint.loginPage()
                .setUserName("mhaki005@pint.edu")
                .setPassword("Pintpass12")
                .clickSignIn();
        Thread.sleep(500);

        pint.loginPage()
                .setUserName("mhaki005@pint.edu")
                .setPassword("Pintpass123")
                .clickSignIn();
    }
}
