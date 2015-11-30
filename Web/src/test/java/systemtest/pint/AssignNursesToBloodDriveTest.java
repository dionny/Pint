package systemtest.pint;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import systemtest.pint.PageObjects.PintApplication;

public class AssignNursesToBloodDriveTest {
    static PintApplication pint = new PintApplication();

    @BeforeClass
    public static void fixtureSetUp() throws Exception {
        pint.launch();
    }

    @AfterClass
    public static void fixtureTearDown() throws Exception {
        Thread.sleep(10000);
        pint.quit();
    }

    @Test
    public void assignNursesToBloodDriveTest() throws Exception {
        String [][]expected = new String[][]{
                {"Jennifer", "James", "jennifer@pint.edu", "1151438615"},
                {"Diana", "King", "diana@pint.edu", "7751488615"},
                {"Leonardo", "Bobadilla", "leonardo@pint.edu", "9451438615"}
        };
        pint.loginPage()
                .setUserName("Greg001@pint.edu")
                .setPassword("Greg123456")
                .clickSignIn();

        pint.coordinatorDashboard().clickBloodDrive("FIU-MMC Blood Drive")
                .clickAddNurses().verifyUnassignedNurseListEntry(expected, 3, 0, 1);
    }
}
