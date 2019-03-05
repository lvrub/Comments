package Tests.ft;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

public class Draft {
    //    @Test()
    static WebDriver driver;

    public static void main(String[] arg) {
        driver = new ChromeDriver();
        Draft draft = new Draft();
        driver.get("https://www.google.com/");
        Actions action = new Actions(driver);
        final WebElement we = driver.findElement(By.xpath("//span[@class='MiYK0e']"));
        action.moveToElement(we).build().perform();
        String tooltip_msg = we.getAttribute("titlearia-label");
        System.out.println(tooltip_msg + "!!!");


        final WebElement element = driver.findElement(By.xpath("//input[contains(@class,'gLFyf gsfi')]"));
        element.sendKeys("Selenium");
        element.sendKeys(Keys.RETURN);
        draft.verifyDataCorrect("Результаты по запросу \"Selenium\"");
        driver.quit();

    }

    Draft verifyDataCorrect(String string) {
        String actual = driver.findElement(By.xpath("//h3")).getText().toString();
        Assert.assertEquals(actual, string, String.format("Not real data '%s'", actual));
        return this;
    }

}
