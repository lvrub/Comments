package Tests.object;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

public class BCommentWindow extends BasePages {
    private final WebDriver driver;

    public BCommentWindow(WebDriver webDriver) {
        this.driver = webDriver;
    }

    @Step("Fill name for comment")
    public void fillCommentTextField(String commentText) {
        this.driver.findElement(By.id("Text")).clear();
        this.driver.findElement(By.id("Text")).sendKeys(commentText);
        this.driver.findElement(By.id("Number")).click(); //in order to change fous from the field
        this.driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @Step("Fill number for comment")
    public BCommentWindow fillCommentNumber(String commentNumber) {
        this.driver.findElement(By.id("Number")).clear();
        this.driver.findElement(By.id("Number")).sendKeys(commentNumber);
        return this;
    }

    @Step("Save a comment")
    public void saveComment() {
        this.driver.findElement(By.xpath("//*[@id=\"editor-navigation\"]/input[1]")).click();
    }

    @Step("Navigate to table")
    public BCommentWindow saveCommentReturnInTable() {
        this.driver.findElement(By.xpath("//*[@class=\"buttonAsLink\" and @value ='Save & Return']")).click();
        return this;
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

    @Step("Check name length for new comment")
    public boolean isErrorMessageShown(String message) {
        try {
            this.driver.findElement(By.xpath(String.format("//span[@htmlfor='Text' and contains(text(), '%s')]", message))).getText();
            return true;
        } catch (NoSuchElementException e) {
            System.out.println(e);
            return false;
        }
    }

    @Step("Check max length of comment number")
    public boolean showErrorMessageForNumberLength(String lengthMessage) {
        System.out.println(lengthMessage + " went from tests111 ");
        String lengthMessage1 = (this.driver.findElement(By.id("errorfield")).getText());
        System.out.println(lengthMessage1 + " went from tests222 ");
        if (lengthMessage1.equals(lengthMessage1)) {
            System.out.println(lengthMessage + " went from tests ");
            System.out.println(lengthMessage1 + " recieved here");
            return true;
        }
        return false;
    }

    @Step("Get comment name")
    public String commentText() {
        return this.driver.findElement(By.xpath("*//input[@id='Text']")).getAttribute("value");
    }

    @Step("Check comment name")
    public BCommentWindow verifyCommentText(String commentName) {
        String commentExistingName = driver.findElement(By.xpath("*//input[@id='Text']")).getAttribute("value");
        Assert.assertEquals(commentExistingName, commentName, "Expected comment name doesn't meet existing ");
        return this;
    }

    @Step("Get comment number")
    public String commentNumber() {
        return this.driver.findElement(By.xpath("*//input[@id='Number']")).getAttribute("value");
    }

    @Step("Check comment number")
    public BCommentWindow verifyCommentNumber(String commentNumber) {
        String commentExistingNumber = driver.findElement(By.xpath("*//input[@id='Number']")).getAttribute("value");
        Assert.assertEquals(commentExistingNumber, commentNumber, "Expected comment number doesn't meet existing ");
        return this;
    }

    @Step("Check comment category")
    public String selectedCategory() {
        return this.driver.findElement(By.xpath("//span[contains(text(),'Cat0')]")).getText();
    }

    @Step("Check comment number")
    public BCommentWindow verifyCommentCategory(String commentCategory) {
        String commentExistingCategory = driver.findElement(By.xpath("//span[contains(text(),'Cat0')]")).getText();
        Assert.assertEquals(commentExistingCategory, commentCategory, "Expected comment number doesn't meet existing ");
        return this;
    }

}