package net.commments.object;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BCommentPage implements CommentPage {
    private final WebDriver driver;

    public BCommentPage(WebDriver webDriver) {
        this.driver = webDriver;
    }

    public void open() {
        driver.get("http://commentssprintone.azurewebsites.net/");

    }

    public void newComment() {
        driver.findElements(By.id("newbutton")).get(0).click();

    }

    public int commentPagination() {
        throw new UnsupportedOperationException("Please implement");

    }
}
