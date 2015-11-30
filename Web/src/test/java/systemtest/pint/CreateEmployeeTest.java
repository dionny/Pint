package systemtest.pint;

import org.junit.*;
import systemtest.pint.PageObjects.PintApplication;

/**
 * Created by Sajib on 11/29/2015.
 */
public class CreateEmployeeTest {
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
    public void testCreateEmployee_SD01() throws Exception {

        pint.loginPage()
                .setUserName("mhaki005@pint.edu")
                .setPassword("Pintpass123")
                .clickSignIn();

        pint.managerDashboard()
                .clickCreateEmployee();
        
        pint.createEmployeePage()
                .setEmailAddress("sajib@gmail.com")
                .setPassword("Sajib")
                .setFirstName("Sajib")
                .setLastName("Talukder")
                .setPhoneNumber("+7864517703")
                .setRole("Nurse")
                .clickAdd();

        pint.managerDashboard()
                .verifyEmployeeExists("sajib@gmail.com");

    }

    @Test
    public void testCreateEmployee_SD02() throws Exception {

        pint.loginPage()
                .setUserName("mhaki005@pint.edu")
                .setPassword("Pintpass123")
                .clickSignIn();

        pint.managerDashboard()
                .clickCreateEmployee();

        pint.createEmployeePage()
                .setEmailAddress("sajib@gmail.com")
                .setPassword("Sajib")
                .setFirstName("Sajib")
                .setLastName("Talukder")
                .setPhoneNumber("+7864517703")
                .setRole("Nurse")
                .clickAdd();

        pint.managerDashboard()
                .verifyEmployeeExists("sajib@gmail.com");

    }

    @Test
    public void testCreateEmployee_RD01() throws Exception {

        pint.loginPage()
                .setUserName("mhaki005@pint.edu")
                .setPassword("Pintpass123")
                .clickSignIn();

        pint.managerDashboard()
                .clickCreateEmployee();

        pint.createEmployeePage()
                .setEmailAddress("sajib@gmail.com")
                .setPassword("Sajib")
                .setFirstName("Sajib")
                .setLastName("Talukder")
                .setPhoneNumber("+7864517703")
                .setRole("Nurse")
                .clickAdd();

        pint.managerDashboard()
                .verifyEmployeeExists("sajib@gmail.com");

    }
}
