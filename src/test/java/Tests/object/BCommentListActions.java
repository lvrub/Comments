package Tests.object;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

public class BCommentListActions implements CommentListActions {
    public final WebDriver driver;

    public BCommentListActions(WebDriver driver) {
        this.driver = driver;
    }

    public void selectAction(String action) {
        new Select(this.driver.findElement(By.id("commandSelect"))).selectByVisibleText(action);
        this.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

}
