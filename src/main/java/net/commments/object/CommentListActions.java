package net.commments.object;

public interface CommentListActions {

    void activate(String comment);

    void inactivate(String comment);

    void removeFromCategory(String comment);

}
