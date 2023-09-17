package com.review.repository;

import com.review.model.Comment;

public interface CommentRepository
{
    void storeComment(Comment comment);
}
