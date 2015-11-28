package systemtest.pint;

import org.junit.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.net.URL;
import java.util.concurrent.TimeUnit;

/**
 * Created by Dionny on 11/28/2015.
 */
public class LoginTest {
    static ChromeDriver driver;

    @BeforeClass
    public static void fixtureSetUp() throws Exception {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.navigate().to("http://localhost:8080/");
    }

    @AfterClass
    public static void fixtureTearDown() throws Exception {
        driver.quit();
    }

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void testGetCoordinator() throws Exception {
    }
}
