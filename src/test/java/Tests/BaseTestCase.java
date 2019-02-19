package Tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

public class BaseTestCase {

    protected final net.commments.sample.selenium.CommentsDriver driver = new net.commments.sample.selenium.CommentsDriver();

    @BeforeMethod
    public void createDriver() {
        this.driver.define();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @AfterMethod
    public void closeDriver() {
        driver.close();
    }
}
