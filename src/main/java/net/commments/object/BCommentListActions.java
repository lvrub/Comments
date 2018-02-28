package net.commments.object;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;

public class BCommentListActions implements CommentListActions {
    public final WebDriver driver;

    public BCommentListActions(WebDriver driver) {
        this.driver = driver;
    }

    public void openActionList() {
        List<WebElement> options = new Select(this.driver.findElement(By.id("commandSelect"))).getOptions();
        for (WebElement option : options) {
            String text1 = (options.get(0)).getText();
            String text2 = (options.get(1)).getText();
            String text3 = (options.get(2)).getText();
            String text4 = (options.get(3)).getText();
            assertEquals(text1, "Select an Action");
            assertEquals(text2, "Activate");
            assertEquals(text3, "Inactivate");
            assertEquals(text4, "RemoveFromCategory");
        }

    }

    public void selectAction(String action) {
        new Select(this.driver.findElement(By.id("commandSelect"))).selectByVisibleText(action);
        this.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

}
