package com.review;

import com.review.config.ProjectConfig;
import com.review.model.Comment;
import com.review.service.CommentService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class CydeoApp {
    public static void main(String[] args)
    {
        Comment comment = new Comment();
        comment.setAuthor("Johnson");
        comment.setText("Spring Framework");

        ApplicationContext container = new AnnotationConfigApplicationContext(ProjectConfig.class);
        CommentService commentService = container.getBean(CommentService.class);
        commentService.publishComment(comment);
    }
}
