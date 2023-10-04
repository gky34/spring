package com.review.proxy;

import com.review.model.Comment;

public interface CommentNotificationProxy
{
     void sendComment(Comment comment);
}
