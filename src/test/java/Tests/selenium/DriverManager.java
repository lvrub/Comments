package Tests.selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.config.DriverManagerType;
import net.commments.sample.selenium.CommentsDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;


public class DriverManager {
    protected final CommentsDriver driver = new CommentsDriver();

    @BeforeClass
    @Parameters("browser")
    public static void driverManager(String browser) {
        WebDriverManager.getInstance(DriverManagerType.valueOf(browser)).setup();
    }

    public WebDriver getDriver() {
        return this.driver;
    }

    @Parameters("browser")
    @BeforeClass
    public void setDriver(String browser) {
        if (browser.equalsIgnoreCase("chrome")) {
            driver.define(new ChromeDriver());
        } else {
            driver.define(new FirefoxDriver());
        }

    }

    @AfterMethod
    public void closeDriver() {
        driver.quit();
    }
}