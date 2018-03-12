package Tests.ft;

import Tests.object.*;
import io.qameta.allure.*;
import net.commments.sample.selenium.CommentsDriver;
import org.hamcrest.MatcherAssert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Test10 {
    protected final CommentsDriver driver;
    private final CommentListStatus commentListStatus;
    private final CommentPage commentPage;
    private final CommentTable commentTable;

    public Test10() {
        this.driver = new CommentsDriver();
        this.commentListStatus = new BCommentListStatus(this.driver);
        this.commentPage = new BCommentPage(this.driver);
        this.commentTable = new BCommentTable(this.driver);


    }

    @Test(description = "Filtration of comments with special category")
    @Severity(SeverityLevel.NORMAL)
    @Description("This test checks table filtration of comments which contains required category")
    @Epic("Regression Suit")
    @Feature("Check category filtration")
    public void test() {
        commentPage.open();
        commentListStatus.selectCategoty("Cat4");
        commentListStatus.clickApplyStatus();
        MatcherAssert.assertThat("Comment Text 9 is present", commentTable.isNewCommentTextCorrect("Comment Text 9"));
        MatcherAssert.assertThat("Comment Text 14 is present", commentTable.isNewCommentTextCorrect("Comment Text 14"));
        MatcherAssert.assertThat("Comment Text 19 is present", commentTable.isNewCommentTextCorrect("Comment Text 19"));
        MatcherAssert.assertThat("Comment Text 24 is present", commentTable.isNewCommentTextCorrect("Comment Text 24"));
        MatcherAssert.assertThat("Comment Text 19 is present", commentTable.isNewCommentTextCorrect("Comment Text 29"));
        commentListStatus.selectCategoty("Cat5");
        commentListStatus.clickApplyStatus();
        final String page1 = driver.getPageSource();
        MatcherAssert.assertThat("Comment Text 9 is not present", !page1.contains("Comment Text 9"));
        MatcherAssert.assertThat("Comment Text 14 is not present", !page1.contains("Comment Text 14"));
        MatcherAssert.assertThat("Comment Text 19 is not present", !page1.contains("Comment Text 19"));
        MatcherAssert.assertThat("Comment Text 24 is not present", !page1.contains("Comment Text 24"));
        MatcherAssert.assertThat("Comment Text 29 is not present", !page1.contains("Comment Text 29"));

    }

    @BeforeMethod
    public void createDriver() {
        this.driver.define();
    }

    @AfterMethod
    public void closeDriver() {
        this.driver.close();
    }
}
