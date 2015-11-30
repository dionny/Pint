package systemtest.pint;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import systemtest.pint.PageObjects.PintApplication;

public class AssignNursesToBloodDriveTest {
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
    public void assignNursesToBloodDriveTest_SD01() throws Exception {
        pint.launch();

        String [][]expected = new String[][]{
                /*{"Jennifer", "James", "jennifer@pint.edu", "1151438615"},
                {"Diana", "King", "diana@pint.edu", "7751488615"},*/
                {"Leonardo", "Bobadilla", "leonardo@pint.edu", "9451438615"}
        };
        pint.loginPage()
                .setUserName("Greg001@pint.edu")
                .setPassword("Greg123456")
                .clickSignIn();

        pint.coordinatorDashboard()
                .clickBloodDrive("FIU-MMC Blood Drive")
                .clickAddNurses()
                .verifyUnassignedNurseListEntry(expected, 1, 0, 1)
                .selectNurse(1)
                .clickCancel();

        pint.quit();
        //pint.coordinatorDashboard().logout();
    }

    @Test
    public void assignNursesToBloodDriveTest2_SD02() throws Exception {
        pint.launch();

        String [][]expected = new String[][]{
                {"Dionny", "Santiago", "dionny@pint.edu", "4584484711"}
        };
        pint.loginPage()
                .setUserName("kperr@pint.edu")
                .setPassword("PIN897#RY")
                .clickSignIn();

        pint.coordinatorDashboard()
                .clickBloodDrive("Red Cross Blood Drive")
                .clickAddNurses()
                .verifyUnassignedNurseListEntry(expected, 1, 0, 1)
                .selectNurse(1)
                .clickAssign()
                .clickConfirm();
                //.verifyText("0", "span[class*=ng-binding]");

        //pint.coordinatorDashboard().logout();

        pint.quit();
    }

    @Test
    public void assignNursesToBloodDriveTest_RD01() throws Exception {
        pint.launch();

        String [][]expected = new String[][]{
                {"Dionny", "Santiago", "dionny@pint.edu", "4584484711"}
        };

        pint.loginPage()
                .setUserName("jlaw@pint.edu")
                .setPassword("!@@B#RY")
                .clickSignIn();

        pint.coordinatorDashboard()
                .clickBloodDrive("Index Blood Drive")
                .clickAddNurses()
                .verifyText("No nurses are currently available for this hospital.", "div[ng-show*=nurses] h4");

//        pint.coordinatorDashboard().clickButton("button[class*=warning]");
  //      pint.coordinatorDashboard().logout();

        pint.quit();
    }

    @Test
    public void assignNursesToBloodDriveTest_RD02() throws Exception {
        pint.launch();

        String [][]expected = new String[][]{
                {"Jennifer", "James", "jennifer@pint.edu", "1151438615"},
                {"Diana", "King", "diana@pint.edu", "7751488615"},
                {"Leonardo", "Bobadilla", "leonardo@pint.edu", "9451438615"}
        };
        pint.loginPage()
                .setUserName("Greg001@pint.edu")
                .setPassword("Greg123456")
                .clickSignIn();

        pint.coordinatorDashboard()
                .clickBloodDrive("FIU-MMC Blood Drive")
                .clickAddNurses()
                .verifyUnassignedNurseListEntry(expected, 3, 0, 1)
                .selectNurse(1)
                .selectNurse(2)
                .clickAssign();

        //pint.coordinatorDashboard().logout();

        pint.quit();
    }
}
