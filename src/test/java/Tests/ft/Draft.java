package Tests.ft;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

public class Draft {
    static WebDriver driver;
    Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
            .withTimeout(30, TimeUnit.SECONDS)
            .pollingEvery(5, TimeUnit.SECONDS)
            .ignoring(NoSuchElementException.class);

    @Test()

    public static void main(String[] arg) {
        driver = new ChromeDriver();
        Draft draft = new Draft();

        driver.get("https://www.google.com/");

        final WebElement element = driver.findElement(By.xpath("//input[contains(@class,'gLFyf gsfi')]"));
        element.sendKeys("Selenium");
        element.sendKeys(Keys.RETURN);
        draft.verifyTitleCorrect("Результаты по запросу \"Selenium\"");
        draft.findElememt(driver);
        draft.showToolTip();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        draft.verifyTootlTip("Приложения Google");
        driver.quit();
    }

    final Draft verifyTitleCorrect(String string) {
        String actual = driver.findElement(By.xpath("//h3")).getText().toString();
        Assert.assertEquals(actual, string, String.format("Not real data '%s'", actual));
        return this;
    }

    final Draft verifyTootlTip(String tooltip_msg) {
        Actions action = new Actions(driver);
        final WebElement we = driver.findElement(By.xpath("//a[@class='gb_x gb_Vb']"));
        action.moveToElement(we).build().perform();
        String tooltip = we.getAttribute("title");
        Assert.assertEquals(tooltip, tooltip_msg);
        return this;
    }

    final Draft showToolTip() {
        Actions action = new Actions(driver);
        final WebElement we = driver.findElement(By.xpath("//a[@class='gb_x gb_Vb']"));
        action.moveToElement(we).build().perform();
        boolean expected = we.isDisplayed();
        Assert.assertTrue(expected = true);
        return this;
    }

    public WebElement findElememt(WebDriver driver) {
        return driver.findElement(By.xpath("//div[@class='logo'])"));
    }

    public WebElement apply(WebDriver driver) {
        return driver.findElement(By.xpath("xpath"));
    }

}
