package systemtest.pint;

import org.junit.*;
import systemtest.pint.PageObjects.PintApplication;

import static org.junit.Assert.assertEquals;

public class LoginTest {
    static PintApplication pint = new PintApplication();

    @BeforeClass
    public static void fixtureSetUp() throws Exception {
        pint.launch();
    }

    @AfterClass
    public static void fixtureTearDown() throws Exception {
        pint.quit();
    }

    @Test
    public void testLogin() throws Exception {
        pint.loginPage()
                .setUserName("mhaki005@pint.edu")
                .setPassword("Pintpass123")
                .clickSignIn();

        pint.managerDashboard()
                .verifyRoleLabel("MANAGER")
                .verifyEmployeeExists("Greg");

    }
}