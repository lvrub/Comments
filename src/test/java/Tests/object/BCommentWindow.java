package Tests.object;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class BCommentWindow implements CommentWindow {
    private final WebDriver driver;

    public BCommentWindow(WebDriver webDriver) {
        this.driver = webDriver;
    }

    @Step("Fill name for comment")
    public void fillCommentTextField(String commentText) {
        this.driver.findElement(By.id("Text")).sendKeys(commentText);
        this.driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @Step("Fill number for comment")
    public void fillCommentNumber(String commentNumber) {
        this.driver.findElement(By.id("Number")).clear();
        this.driver.findElement(By.id("Number")).sendKeys(commentNumber);
    }

    @Step("Save a comment")
    public void saveComment() {
        this.driver.findElement(By.xpath("//*[@id=\"editor-navigation\"]/input[1]")).click();
    }

    @Step("Navigate to table")
    public void saveCommentReturnInTable() {
        this.driver.findElement(By.xpath("//*[@class=\"buttonAsLink\" and @value ='Save & Return']")).click();
    }

    @Step("Show error message")
    public String showErrorMessage() {
        return this.driver.findElement(By.id("errorfield")).getText();
    }

    @Step("Add category for comment")
    public void addCategory() {
        this.driver.findElement(By.xpath("//*[@id='categoryselector']//div[1]/input[1]")).click();
        this.driver.findElement(By.name("CurSelect")).click();
    }

    @Step("Fill name for comment")
    public boolean isErrorMessageShown(String errorMessage) {
        try {
            this.driver.findElement(By.xpath(String.format("//*[@id='errorfield' and contains(text(), \"%s\")]", errorMessage)));
            System.out.println(errorMessage);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    @Step("Check comment name")
    public String commentText() {
        return this.driver.findElement(By.xpath("*//input[@id='Text']")).getAttribute("value");
    }

    @Step("Check comment number")
    public String commentNumber() {
        return this.driver.findElement(By.xpath("*//input[@id='Number']")).getAttribute("value");
    }

    @Step("Check comment category")
    public String selectedCategory() {
        return this.driver.findElement(By.xpath("//span[contains(text(),'Cat0')]")).getText();
    }

}



