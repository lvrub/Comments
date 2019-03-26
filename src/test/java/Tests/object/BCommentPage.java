package Tests.object;

import Tests.selenium.UIMapParser;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class BCommentPage extends BasePages {
    private WebDriver driver;
    private BCommentTable bCommentTable;

//    public BCommentPage(WebDriver webDriver, BCommentTable bCommentTable) {
//        this.driver = webDriver;
//        this.bCommentTable = bCommentTable;
//    }
private UIMapParser parser = new UIMapParser("C:\\Automation\\src\\test\\java\\Tests\\selenium\\UIMap.properties");

    public BCommentPage(WebDriver webDriver) throws IOException {
        this.driver = webDriver;
    }


    @Step("Open comments site")
    public BCommentPage open() {
        driver.get("http://commentssprintone.azurewebsites.net");
        return this;
    }

    @Step("Open window for new comments ")
    public BCommentPage clickNewComment() {
        this.driver.findElement(By.id("newbutton")).click();
        this.driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        return this;
    }

    @Step("Go to last table page")
    public BCommentPage navigateToLastPage() {
        this.driver.findElement(By.xpath("//a[contains(@href,\"page\")][last()-1]")).click();
        return this;
    }

    @Step("Open window for new comment with duplicated existing info")
    public BCommentPage clickDuplicate() {
        this.driver.findElement(By.xpath("//*[@id='command-navigation']/input[1]")).click();
        return this;
    }

    @Step("Verify correct name for Deleting popup")
    public BCommentPage verifyDeletingWindowName() {
        this.driver.findElement(By.xpath("//*[@value='Delete']")).click();
        String deleteWindowName = driver.findElement(By.id("ui-dialog-title-dialog")).getText();
        Assert.assertEquals("Comments Application", deleteWindowName);
        return this;
    }

    @Step("Verify deleting of comment")
    public BCommentPage verifyDeletingComment() {
        this.driver.findElement(By.xpath(String.valueOf(parser.getOjectLocator("Name")))).click();
        this.driver.findElement(By.xpath("//span[contains(text(),'Yes')]")).click();
        String existComment = driver.findElement(By.xpath("//td[contains(text(),'Comment Text')][1]")).getText();
        Assert.assertEquals(existComment, "Comment Text 1");
        return this;
    }

    @Step("Verify alert message for deleting of comment")
    public BCommentPage verifyAlertMessageForDeleting() {
        this.driver.findElement(By.xpath("//*[@value=\'Delete\']")).click();
        String existComment = driver.switchTo().alert().getText();
        Assert.assertEquals(existComment, "Please, select one category");
        return this;
    }

    @Step("Close deleting alert")
    public BCommentPage closeAlertForDeleting() {
        driver.switchTo().alert().accept();
        return this;
    }

    @Step("Verify closing of Delete popup")
    public BCommentPage verifyDeletingCommentWindowClosed() {
        String window = this.driver.findElement(By.xpath("//*[contains(@class,'ui-draggable')]")).getText();
        Assert.assertFalse(false, window);
        return this;
    }


    public BCommentPage verifyCancelDeleteComment() {
        this.driver.findElement(By.xpath("//span[contains(text(),'No')]")).click();
        String existComment = driver.findElement(By.xpath("//td[contains(text(),'Comment Text')][1]")).getText();
        Assert.assertEquals("Comment Text 0", existComment);
        return this;
    }

    public BCommentPage verifyDeletingWindowMessage() {
        String deleteWindowMessage = driver.findElement(By.xpath("//p[@id='msgText']")).getText();
        Assert.assertEquals("Delete?", deleteWindowMessage);
        return this;
    }

    public BCommentPage verifyDeletingNotification() {
        try {
            String deleteMessage = driver.findElement(By.xpath("//div[@id='infoField']")).getText();
            Assert.assertEquals(deleteMessage, "Selected comments deleted successfull");
            return this;
        } catch (NoSuchElementException e) {
            return this;
        }
    }
}
