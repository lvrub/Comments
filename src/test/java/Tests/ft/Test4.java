package Tests.ft;

import io.qameta.allure.*;
import org.hamcrest.MatcherAssert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
//import org.openqa.selenium.firefox.FirefoxDriver;

public class Test4 {

    private final WebDriver[] driver = new WebDriver[1];

    @Test(description = "Deleting of a comments")
    @Description("This test verifies deleting a comments from table")
    @Severity(SeverityLevel.BLOCKER)
    @Epic("Regression Suit")
    @Feature("Comment deletion")
    public void test() {
        this.driver().get("http://commentssprintone.azurewebsites.net");
        this.driver().findElements(By.name("SelectedId")).get(0).click();
        this.driver().findElement(By.xpath("//*[@value=\"Delete\"]")).click();
        this.driver().findElement(By.xpath("//span[text()=\"Yes\"]")).click();
        final String page = this.driver().getPageSource();
        MatcherAssert.assertThat("Comment Text 0 is present", !page.contains("Comment Text 0"));
    }

    @BeforeMethod
    public void createDriver() {
//     driver[0] = new FirefoxDriver();
        driver[0] = new ChromeDriver();
    }

    @AfterMethod
    public void closeDriver() {
        driver[0].close();
    }

    private WebDriver driver() {
        return this.driver[0];
    }
}
