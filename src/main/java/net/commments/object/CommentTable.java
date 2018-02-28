package net.commments.object;

public interface CommentTable {

    void checkCommentInTable(int numberComment);

    String commentStatus();

    boolean isCommentInactive(String state);

}
