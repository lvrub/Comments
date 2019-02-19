package Tests;

import net.commments.sample.selenium.CommentsDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import java.util.concurrent.TimeUnit;


public class BaseTestCase {

    protected final CommentsDriver driver = new CommentsDriver();

    @BeforeMethod
    public void createDriver() {
        this.driver.define1();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Parameters("browser")
    public void setup(String browser) {
        //Check if parameter passed from TestNG is 'firefox'
        if (browser.equalsIgnoreCase("firefox")) {
            //create firefox instance
            driver.define1();
        }
        //Check if parameter passed as 'chrome'
        else if (browser.equalsIgnoreCase("chrome")) {
            //create chrome instance
            driver.define();
        }
    }

    @AfterMethod
    public void closeDriver() {
        driver.close();
    }
}