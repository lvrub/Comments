package net.commments.ft;

import net.commments.object.*;
import net.commments.selenium.CommentsDriver;
import org.hamcrest.MatcherAssert;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Test8 {
    protected final CommentsDriver driver;
    private final CommentPage commentPage;
    private final CommentTable commentTable;
    private final CommentListActions commentListActions;
    private final CommentListStatus commentListStatus;

    public Test8() {
        this.driver = new CommentsDriver();
        this.commentPage = new BCommentPage(this.driver);
        this.commentTable = new BCommentTable(this.driver);
        this.commentListActions = new BCommentListActions(this.driver);
        this.commentListStatus = new BCommentListStatus(this.driver);

    }

    @Test
    public void test() {
        commentPage.open();
        commentTable.checkCommentInTable(0); // numeration list starts from "0"
        commentListActions.openActionList();
        commentListActions.selectAction("Inactivate");
        MatcherAssert.assertThat("Comment is inactive", commentTable.isCommentInactive("V1"));
//                String activationStatusInTable = commentTable.commentStatus ();
//              assertEquals(activationStatusInTable, "V1");
        commentListStatus.selectStatus("Inactive");
        commentListStatus.clickApplyStatus();
        final String page = this.driver().getPageSource();
        MatcherAssert.assertThat("Comment Text 0 is not present", page.contains("Comment Text 0"));
        commentListStatus.selectStatus("Active");
        commentListStatus.clickApplyStatus();
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
