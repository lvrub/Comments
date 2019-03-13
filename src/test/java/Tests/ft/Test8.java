package Tests.ft;

import Tests.object.BCommentListActions;
import Tests.object.BCommentListStatus;
import Tests.object.BCommentPage;
import Tests.object.BCommentTable;
import io.qameta.allure.*;
import org.hamcrest.MatcherAssert;
import org.testng.annotations.Test;

public class Test8 extends BaseTestCase {

    private final BCommentTable commentTable = new BCommentTable(this.driver);
    private final BCommentPage commentPage = new BCommentPage(this.driver /*,commentTable*/);
    private final BCommentListActions commentListActions = new BCommentListActions(this.driver);
    private final BCommentListStatus commentListStatus = new BCommentListStatus(this.driver);

    @Test(description = "Inactivation of selected comment")
    @Description("This test verifies inactivating of comments from table")
    @Severity(SeverityLevel.CRITICAL)
    @Epic("Regression Suit")
    @Feature("Comment Inactivation")
    public void test8() {
        commentPage.open()
                .returnPage(commentTable)
                .checkExistingComment(0) // numeration list starts from "0"
                .returnPage(commentListActions)
                .selectAction("Inactivate");
        MatcherAssert.assertThat("Comment is inactive", commentTable.isCommentInactive("V"));
        commentListStatus.selectStatus("Inactive")
                .clickApplyStatus();
        final String page = this.driver.getPageSource();
        MatcherAssert.assertThat("Comment Text 0 is not present", page.contains("Comment Text 0"));
        commentListStatus.selectStatus("Active")
                .clickApplyStatus();
        final String page1 = this.driver.getPageSource();
        MatcherAssert.assertThat("Comment Text 0 is present", !page1.contains("Comment Text 0"));
    }
}