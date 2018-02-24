package net.commments.object;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BCommentWindow implements CommentWindow {
    private final WebDriver driver;

    public BCommentWindow(WebDriver webDriver) {
        this.driver = webDriver;
    }

    public void fillCommentTextField(String commentText) {
        this.driver.findElement(By.id("Text")).sendKeys(commentText);
    }

    public void saveComment() {
        this.driver.findElement(By.xpath("//*[@id=\"editor-navigation\"]/input[1]")).click();
    }

    public String showErrorMessage() {
        String errorText = this.driver.findElement(By.id("errorfield")).getText();
        return errorText;

    }
}
