package net.commments.object;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class BCommentWindow implements CommentWindow {
    private final WebDriver driver;

    public BCommentWindow(WebDriver webDriver) {
        this.driver = webDriver;
    }

    public void fillCommentTextField(String commentText) {
        this.driver.findElement(By.id("Text")).sendKeys(commentText);
        this.driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    public void saveComment() {
        this.driver.findElement(By.xpath("//*[@id=\"editor-navigation\"]/input[1]")).click();
    }

    public String showErrorMessage() {
        return this.driver.findElement(By.id("errorfield")).getText();
    }


    public void addCategory() {
        this.driver.findElement(By.xpath("//*[@id='categoryselector']//div[1]/input[1]")).click();
        this.driver.findElement(By.name("CurSelect")).click();
    }

    public boolean isErrorMessageShown(String errorMessage) {
        try {
            this.driver.findElement(By.xpath(String.format("//*[@id='errorfield' and contains(text(), \"%s\")]", errorMessage)));
            System.out.println(errorMessage);
            return true;
        } catch (NoSuchElementException e) {
            System.out.println(e);
            return false;
        }
    }
}
