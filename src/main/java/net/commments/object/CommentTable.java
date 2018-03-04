package net.commments.object;

public interface CommentTable {

    void checkCommentInTable(int numberComment);

    boolean isCommentTextCorrect(String name);

    boolean isCommentNumberCorrect(String number);

    boolean isCommentCategoryCorrect(String category);

    String commentStatus();

    boolean isCommentInactive(String state);

}
