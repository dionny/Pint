package systemtest.pint;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import systemtest.pint.PageObjects.NurseDashboard;
import systemtest.pint.PageObjects.PintApplication;

public class InputDonorTest {
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
    public void testInputDonor() throws Exception {

        pint.loginPage()
                .setUserName("jenny@pint.edu")
                .setPassword("jennyPINTwhhh")
                .clickSignIn();

        pint.nurseDashboard().clickBloodDrive("FIU-MMC Blood Drive").clickInputDonor().setEmail("jliu005@fiu.edu").clickAddEmployee();
    }
}
