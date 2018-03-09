package Tests.object;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

public class BCommentListStatus implements CommentListStatus {
    public final WebDriver driver;

    public BCommentListStatus(WebDriver driver) {
        this.driver = driver;
    }

    public void selectStatus(String status) {
        new Select(this.driver.findElement(By.id("SelectedStatus"))).selectByVisibleText(status);
        this.driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

    public void clickApplyStatus() {
        this.driver.findElements(By.id("applybutton")).get(0).click();
    }
}
