package net.commments.object;

public interface CommentWindow {

    void fillCommentTextField(String commentText);

    void saveComment();

    String showErrorMessage();

    void addCategory();

    boolean isErrorMessageShown(String errorMessage);
}
