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
        //pint.launch();
    }

    @AfterClass
    public static void fixtureTearDown() throws Exception {
        //pint.quit();
    }

    @Test
    public void testInputDonor_SD01() throws Exception {
        pint.launch();

        pint.loginPage()
                .setUserName("jenny@pint.edu")
                .setPassword("jennyPINTwhhh")
                .clickSignIn();

        pint.nurseDashboard()
                .clickBloodDrive("FIU-MMC Blood Drive")
                .verifyText("FIU-MMC Blood Drive","strong[class*=ng-binding]")
                .verifyText("We need blood due to the high frequency of accidents in the area.","p[class*=ng-binding]")
                .clickInputDonor()
                .setEmail("jliu005@fiu.edu")
                .clickAddEmployee();//.verifyDonorCount("Total Donor Count: 3");

        pint.quit();
    }

    @Test
    public void testInputDonor_SD02() throws Exception {
        pint.launch();

        pint.loginPage()
                .setUserName("linda@pint.edu")
                .setPassword("lindaPINTwhhh")
                .clickSignIn();

        pint.nurseDashboard()
                .clickBloodDrive("FIU-BBC Blood Drive")
                .verifyText("FIU-BBC Blood Drive","strong[class*=ng-binding]")
                .verifyText("We need blood and we need it now.","p[class*=ng-binding]")
                .clickInputDonor()
                .setEmail("accha004@fiu.edu")
                .clickAddEmployee();

        pint.quit();
    }

    @Test
    public void testInputDonor_RD02() throws Exception {
        pint.launch();

        pint.loginPage()
                .setUserName("jenny@pint.edu")
                .setPassword("jennyPINTwhhh")
                .clickSignIn();

        pint.nurseDashboard()
                .clickBloodDrive("FIU-MMC Blood Drive")
                .verifyText("FIU-MMC Blood Drive","strong[class*=ng-binding]")
                .verifyText("We need blood due to the high frequency of accidents in the area.","p[class*=ng-binding]")
                .clickInputDonor()
                .setEmail("agobind@fiu.edu")
                .clickAddEmployee()
                .verifyText("Donor with provided email address does not exist.","div.modal-content label[id*=error]");

        pint.quit();
    }
}
