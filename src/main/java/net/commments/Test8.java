package net.commments;

import org.hamcrest.MatcherAssert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

//import org.openqa.selenium.firefox.FirefoxDriver;

public class Test8 {

    private final WebDriver[] driver = new WebDriver[1];

    @Test
    public void test() {
        this.driver().get("http://commentssprintone.azurewebsites.net");
        this.driver().findElements(By.name("SelectedId")).get(0).click();
        Select SelectAnAction = new Select(this.driver().findElement(By.id("commandSelect")));
        SelectAnAction.selectByIndex(2);

        String table = this.driver().findElement(By.xpath("//*[@id=\"main\"]/div/div[5]/form/table/tbody/tr[1]/td[4]")).getText();
        assertEquals(table, "V");
//        System.out.println(table);

        Select Statuse = new Select(this.driver().findElement(By.id("SelectedStatus")));
        Statuse.selectByIndex(2);
        this.driver().findElements(By.id("applybutton")).get(0).click();
        final String page = this.driver().getPageSource();
        MatcherAssert.assertThat("Comment Text 0 is not present", page.contains("Comment Text 0"));

        Select Statuse1 = new Select(this.driver().findElement(By.id("SelectedStatus")));
        Statuse1.selectByIndex(1);
        this.driver().findElements(By.id("applybutton")).get(0).click();
        final String page1 = this.driver().getPageSource();
        MatcherAssert.assertThat("Comment Text 0 is present", !page1.contains("Comment Text 0"));

    }

    @BeforeMethod
    public void createDriver() {
//     driver[0] = new FirefoxDriver();
        driver[0] = new ChromeDriver();
    }

    @AfterMethod
    public void closeDriver() {
        driver[0].quit();
    }

    private WebDriver driver() {
        return this.driver[0];
    }
}
