package Tests.object;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

public class BCommentTable implements CommentTable {
    private final WebDriver driver;

    public BCommentTable(WebDriver webDriver) {
        this.driver = webDriver;
    }

    BCommentTable bCommentTable;

    @Step("Check comment check-box in table")
    public void checkExistingComment(int numberComment) {
        this.driver.findElements(By.name("SelectedId")).get(numberComment).click();
    }

    @Step("Check inactivate comment status in table")
    public String commentStatus() {
        return this.driver.findElement(By.xpath("//*[@id=\"main\"]/div/div[5]/form/table/tbody/tr[1]/td[4]")).getText();
    }

    @Step("Verify comment number in table")
    public boolean isNewCommentNumberCorrect(String number) {
        try {
            this.driver.findElement(By.xpath(String.format("//td[@class='numbercolumn'and contains(text(),'%s')]", number))).getText();
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    @Step("Verify comment name in table")
    public boolean isNewCommentTextCorrect(String name) {
        try {
            this.driver.findElement(By.xpath(String.format("//*[@class='textcolumn'][contains(text(),\"%s\")]", name)));
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    @Step("Verify comment category in table")
    public boolean isNewCommentCategoryCorrect(String category) {
        try {
            String s = this.driver.findElement(By.xpath(String.format("//*[@class='categorycolumn' and contains(text(), '%s')]", category))).getText();
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    @Step("Verify comment inactivation in table")
    public boolean isCommentInactive(String state) {
        try {
            this.driver.findElement(By.xpath(String.format("//tr[1]/td[@class='inactivecolumn' and contains(text(), \"%s\")]", state)));
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    @Step("Verify presence of the category in comment categories ")
    public boolean verifyCategories(String expected) throws NoSuchElementException {
        try {
            for (WebElement row : this.driver.findElements(By.xpath("//*[@class='categorycolumn']"))) {
                if (!row.getText().contains(expected)) {
                    return false;
                }
            }
            return true;

        } catch (NoSuchElementException e) {
            return false;
        }
    }

    @Step("Verify correct comments ID")
    public String verifyCommentId(String id) {
        List<WebElement> row = this.driver.findElements(By.xpath("//*[@class='numbercolumn']"));
        for (WebElement e : row) {
            id = row.get(row.size() - 1).getText();
        }
        return id;
    }

    @Step("Verify correct name for Deleting popup")
    public boolean verifyDeletingWindowName() {
        this.driver.findElement(By.xpath("//*[@value='Delete']")).click();
        String deleteWindowName = driver.findElement(By.id("ui-dialog-title-dialog")).getText();
        Assert.assertEquals("Comments Application", deleteWindowName);
        return true;
    }

    @Step("Verify deleting of comment")
    public boolean verifyDeletingComment() {
        this.driver.findElement(By.xpath("//*[@value=\'Delete\']")).click();
        this.driver.findElement(By.xpath("//span[contains(text(),'Yes')]")).click();
        String existComment = driver.findElement(By.xpath("//td[contains(text(),'Comment Text')][1]")).getText();
        Assert.assertEquals(existComment, "Comment Text 1");
        return true;
    }

    @Step("Verify closing of Delete popup")
    public boolean verifyDeletingCommentWindowClosed() {
        String window = this.driver.findElement(By.xpath("//*[contains(@class,'ui-draggable')]")).getText();
        Assert.assertFalse(false, window);
        return true;
    }

    public boolean verifyCancelDeleteComment() {
        this.driver.findElement(By.xpath("//span[contains(text(),'No')]")).click();
        String existComment = driver.findElement(By.xpath("//td[contains(text(),'Comment Text')][1]")).getText();
        Assert.assertEquals("Comment Text 0", existComment);
        return true;
    }

    public boolean verifyDeletingWindowMessage() {
        String deleteWindowMessage = driver.findElement(By.xpath("//p[@id='msgText']")).getText();
        Assert.assertEquals("Delete?", deleteWindowMessage);
        return true;
    }

    public boolean verifyDeletingNotification() {
        try {
            String deleteMessage = driver.findElement(By.xpath("//div[@id='infoField']")).getText();
            Assert.assertEquals(deleteMessage, "Selected comments deleted successfull");
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

}