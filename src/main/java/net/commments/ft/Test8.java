package net.commments.ft;

import net.commments.object.BCommentPage;
import net.commments.object.CommentPage;
import net.commments.selenium.CommentsDriver;
import org.hamcrest.MatcherAssert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class Test8 {
    protected final CommentsDriver driver;
    private final CommentPage commentPage;

    public Test8() {
        this.driver = new CommentsDriver();
        this.commentPage = new BCommentPage(this.driver);
    }

    @Test
    public void test() {
        commentPage.open();
        this.driver().findElement(By.name("SelectedId")).click();
        Select SelectAnAction = new Select(this.driver().findElement(By.id("commandSelect")));
        SelectAnAction.selectByIndex(2);

        String table = this.driver().findElement(By.xpath("//*[@id=\"main\"]/div/div[5]/form/table/tbody/tr[1]/td[4]")).getText();
        assertEquals(table, "V");

        Select Statuse = new Select(this.driver().findElement(By.id("SelectedStatus")));
        Statuse.selectByIndex(2);
        this.driver().findElements(By.id("applybutton")).get(0).click();
        final String page = this.driver().getPageSource();
        MatcherAssert.assertThat("Comment Text 0 is not present", page.contains("Comment Text 0"));

        Select Statuse1 = new Select(this.driver().findElement(By.id("SelectedStatus")));
        Statuse1.selectByIndex(1);
        this.driver().findElements(By.id("applybutton")).get(0).click();
        final String page1 = this.driver().getPageSource();
        MatcherAssert.assertThat("Comment Text 0 is present", !page1.contains("Comment Text 0"));

    }

    @BeforeMethod
    public void createDriver() {
        this.driver.define();
    }

    @AfterMethod
    public void closeDriver() {
        driver.quit();
    }

    private WebDriver driver() {
        return this.driver;
    }

}
