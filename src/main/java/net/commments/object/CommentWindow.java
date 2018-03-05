package net.commments.object;

public interface CommentWindow {

    void fillCommentTextField(String commentText);

    void fillCommentNumber(String commentNumber);

    void saveComment();

    void saveCommentReturnInTable();

    String showErrorMessage();

    void addCategory();

    boolean isErrorMessageShown(String errorMessage);

    String commentText();

    String commentNumber();

    String selectedCategory();
}
