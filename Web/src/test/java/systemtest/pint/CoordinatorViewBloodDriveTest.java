package systemtest.pint;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import systemtest.pint.PageObjects.PintApplication;

public class CoordinatorViewBloodDriveTest {
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
    public void coordinatorViewBloodDriveTest() throws Exception {
        String [][]expected = new String[][]{
                {"Peter", "Clarke", "clarke@pint.edu", "8123911223"},
                {"Jenny", "Smith", "jenny@pint.edu", "7951738554"},
                {"Maritza", "Michaels", "maritza@pint.edu", "7756638615"}
        };
        pint.loginPage()
                .setUserName("Greg001@pint.edu")
                .setPassword("Greg123456")
                .clickSignIn();

        pint.coordinatorDashboard().clickBloodDrive("FIU-MMC Blood Drive").verifyNurseListEntry(expected, 3, 0, 1);

    }
}
