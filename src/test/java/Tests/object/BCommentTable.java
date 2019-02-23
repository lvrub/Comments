package Tests.object;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

public class BCommentTable extends BasePages {
    private final WebDriver driver;

    public BCommentTable(WebDriver webDriver) {
        this.driver = webDriver;
    }

    @Step("Check comment check-box in table")
    public BCommentTable checkExistingComment(int numberComment) {
        this.driver.findElements(By.name("SelectedId")).get(numberComment).click();
        return this;
    }

    @Step("Check inactivate comment status in table")
    public String commentStatus() {
        return this.driver.findElement(By.xpath("//*[@id=\"main\"]/div/div[5]/form/table/tbody/tr[1]/td[4]")).getText();
    }

    @Step("Verify comment number in table")
    public BCommentTable isNewCommentNumberCorrect(String actualNumber, String expectedNumber) {
        try {
            String number = this.driver.findElement(By.xpath(String.format("//td[@class='numbercolumn'and contains(text(),'%s')]", actualNumber))).getText();
            Assert.assertFalse(number == null);
            Assert.assertEquals(number, expectedNumber, "Numbers are not equal:");
            return this;
        } catch (NoSuchElementException e) {
            return this;
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

    @Step("Verify comment name in table")
    public BCommentTable verifyCommentTextCorrect(String commentName) {
        try {
            String commentTextTable = this.driver.findElement(By.xpath("//td[@class='textcolumn']")).getText();
            Assert.assertEquals(commentName, commentTextTable);
            return this;
        } catch (NoSuchElementException e) {
            return this;
        }
    }


    @Step("Verify comment category in table")
    public BCommentTable isNewCommentCategoryCorrect(String actualCategory, String expectedCategory) {
        try {
            String category = this.driver.findElement(By.xpath(String.format("//*[@class='categorycolumn' and contains(text(), '%s')]", actualCategory))).getText();
            Assert.assertEquals(category, expectedCategory);
            return this;
        } catch (NoSuchElementException e) {
            return this;
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



}