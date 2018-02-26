package net.commments.object;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;

public class BCommentListStatus implements CommentListStatus {
    public final WebDriver driver;

    public BCommentListStatus(WebDriver driver) {
        this.driver = driver;
    }

    public void openStatusList() {
        List<WebElement> options = new Select(this.driver.findElement(By.id("SelectedStatus"))).getOptions();
        for (WebElement option : options) {
            String text1 = (options.get(0)).getText();
            String text2 = (options.get(1)).getText();
            String text3 = (options.get(2)).getText();
            assertEquals(text1, "All");
            assertEquals(text2, "Active");
            assertEquals(text3, "Inactive");

        }

    }

    public void selectStatus(String status) {
        new Select(this.driver.findElement(By.id("SelectedStatus"))).selectByVisibleText(status);
        this.driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

    }

    public void clickApplyStatus() {
        this.driver.findElements(By.id("applybutton")).get(0).click();
    }
}
