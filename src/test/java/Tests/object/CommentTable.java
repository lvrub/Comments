package Tests.object;

public interface CommentTable {

    void checkExistingComment(int numberComment);

    boolean isNewCommentTextCorrect(String name);

    boolean isNewCommentNumberCorrect(String number);

    boolean isNewCommentCategoryCorrect(String category);

    String commentStatus();

    boolean isCommentInactive(String state);

    boolean verifyCategories(String expected);

    String verifyCommentId(String id);
}
