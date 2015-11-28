package systemtest.pint;

import org.junit.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import systemtest.pint.PageObjects.PintApplication;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.net.URL;
import java.util.concurrent.TimeUnit;

/**
 * Created by Dionny on 11/28/2015.
 */
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

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void testLogin() throws Exception {
        pint.loginPage()
                .setUserName("coordinator")
                .setPassword("coordinator")
                .clickSignIn();

        assertEquals("coordinator",
                pint.coordinatorDashboard()
                        .getRoleLabel());
    }
}
