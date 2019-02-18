package Tests.ft;

import Tests.object.*;
import io.qameta.allure.*;
import net.commments.sample.selenium.CommentsDriver;
import org.hamcrest.MatcherAssert;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Test8 {
    protected final CommentsDriver driver = new CommentsDriver();
    private final CommentPage commentPage = new BCommentPage(this.driver);
    private final CommentTable commentTable = new BCommentTable(this.driver);
    private final CommentListActions commentListActions = new BCommentListActions(this.driver);
    private final CommentListStatus commentListStatus = new BCommentListStatus(this.driver);

    @Test(description = "Inactivation of selected comment")
    @Description("This test verifies inactivating of comments from table")
    @Severity(SeverityLevel.CRITICAL)
    @Epic("Regression Suit")
    @Feature("Comment Inactivation")
    public void test8() {
        commentPage.open();
        commentTable.checkExistingComment(0); // numeration list starts from "0"
        commentListActions.selectAction("Inactivate");
        MatcherAssert.assertThat("Comment is inactive", commentTable.isCommentInactive("V"));
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
