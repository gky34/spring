package com.review.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
//@ComponentScan(basePackages = "com.review")
@ComponentScan(basePackages = {"com.review.proxy","com.review.service","com.review.repository"})
public class ProjectConfig {
}
