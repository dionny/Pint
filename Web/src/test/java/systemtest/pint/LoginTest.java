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
                .setUserName("Greg001@pint.edu")
                .setPassword("Greg123456")
                .clickSignIn();

        pint.coordinatorDashboard()
                .verifyRoleLabel("COORDINATOR");
    }
}