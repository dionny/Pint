package systemtest.pint;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import systemtest.pint.PageObjects.PintApplication;

public class CoordinatorViewBloodDriveTest {
    static PintApplication pint = new PintApplication();

    @BeforeClass
    public static void fixtureSetUp() throws Exception {
        //pint.launch();
    }

    @AfterClass
    public static void fixtureTearDown() throws Exception {
        //pint.quit();
    }

    @Test
    public void coordinatorViewBloodDriveTest_SD01() throws Exception {
        pint.launch();

        String [][]expected = new String[][]{
                {"Peter", "Clarke", "clarke@pint.edu", "8123911223"},
                {"Jenny", "Smith", "jenny@pint.edu", "7951738554"},
                {"Jennifer", "James", "jennifer@pint.edu", "1151438615"},
                {"Maritza", "Michaels", "maritza@pint.edu", "7756638615"},
                {"Diana", "King", "diana@pint.edu", "7751488615"}
        };
        pint.loginPage()
                .setUserName("Greg001@pint.edu")
                .setPassword("Greg123456")
                .clickSignIn();

        pint.coordinatorDashboard().clickBloodDrive("FIU-MMC Blood Drive").verifyNurseListEntry(expected, 3, 0, 1);

        pint.quit();
    }

    @Test
    public void coordinatorViewBloodDriveTest_SD02() throws Exception {
        pint.launch();

        String [][]expected = new String[][]{};
        pint.loginPage()
                .setUserName("kperr@pint.edu")
                .setPassword("PIN897#RY")
                .clickSignIn();

        pint.coordinatorDashboard()
                .clickBloodDrive("Red Cross Blood Drive")
                .verifyNurseListEntry(expected, 3, 0, 1);

        pint.quit();
    }

    @Test
    public void coordinatorViewBloodDriveTest_RD01() throws Exception {
        pint.launch();

        pint.loginPage()
                .setUserName("dpatel@pint.edu")
                .setPassword("dpatepoq123456")
                .clickSignIn();

        pint.coordinatorDashboard()
                .verifyRowCount(0, "table>tbody>tr");

        pint.quit();
    }
}
