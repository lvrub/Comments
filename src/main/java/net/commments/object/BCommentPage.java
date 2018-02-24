package net.commments.object;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class BCommentPage implements CommentPage {
    private final WebDriver driver;

    public BCommentPage(WebDriver webDriver) {
        this.driver = webDriver;
    }

    public void open() {
        this.driver.get("http://commentssprintone.azurewebsites.net/");
    }

    public void clickNewComment() {
        this.driver.findElement(By.id("newbutton")).click();
        this.driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }

    public int commentPagination() {
        throw new UnsupportedOperationException("Please implement");
    }
}
