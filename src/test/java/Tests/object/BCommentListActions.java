package Tests.object;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class BCommentListActions extends BasePages {
    private final WebDriver driver;

    public BCommentListActions(WebDriver driver) throws IOException {
        this.driver = driver;
    }

    @Step("Select status for comment in table")
    public BCommentListActions selectAction(String action) {
        new Select(this.driver.findElement(By.id("commandSelect"))).selectByVisibleText(action);
        this.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return this;
    }

}
