package com.review;

import com.review.model.Comment;
import com.review.service.CommentService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class DemoApp {

    public static void main(String[] args) {

        Comment comment = new Comment();
        comment.setAuthor("Johnson");
        comment.setText("Spring Framework");

        ConfigurableApplicationContext context = SpringApplication.run(DemoApp.class, args);
        CommentService cs = context.getBean(CommentService.class);
        cs.publishComment(comment);


    }

}
