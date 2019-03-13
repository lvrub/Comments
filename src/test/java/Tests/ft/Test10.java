package Tests.ft;

import Tests.object.BCommentListStatus;
import Tests.object.BCommentPage;
import Tests.object.BCommentTable;
import io.qameta.allure.*;
import org.hamcrest.MatcherAssert;
import org.testng.annotations.Test;

public class Test10 extends BaseTestCase {
    private final BCommentListStatus commentListStatus = new BCommentListStatus(this.driver);
    private final BCommentPage commentPage = new BCommentPage(this.driver);
    private final BCommentTable commentTable = new BCommentTable(this.driver);

    @Test(description = "Filtration of comments with special category")
    @Severity(SeverityLevel.NORMAL)
    @Description("This test checks table filtration of comments which contains required category")
    @Epic("Regression Suit")
    @Feature("Check category filtration")

    public void test10() {
        commentPage.open();
        commentListStatus.selectCategoty("Cat4");
        commentListStatus.clickApplyStatus();
        MatcherAssert.assertThat("Categories contains needed category", commentTable.verifyCategories("Cat4"));
        commentTable.verifyCommentText("Comment Text 10", "Comment Text 10");
        commentTable.verifyCommentText("Comment Text 14", "Comment Text 14");
        commentTable.verifyCommentText("Comment Text 19", "Comment Text 19");
        commentTable.verifyCommentText("Comment Text 24", "Comment Text 24");
        commentTable.verifyCommentText("Comment Text 29", "Comment Text 29");
        commentListStatus.selectCategoty("Cat5");
        commentListStatus.clickApplyStatus();
        final String page1 = driver.getPageSource();
        MatcherAssert.assertThat("Comment Text 9 is not present", !page1.contains("Comment Text 9"));
        MatcherAssert.assertThat("Comment Text 14 is not present", !page1.contains("Comment Text 14"));
        MatcherAssert.assertThat("Comment Text 19 is not present", !page1.contains("Comment Text 19"));
        MatcherAssert.assertThat("Comment Text 24 is not present", !page1.contains("Comment Text 24"));
        MatcherAssert.assertThat("Comment Text 29 is not present", !page1.contains("Comment Text 29"));

    }
}