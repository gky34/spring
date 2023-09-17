package com.review.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"com.review.proxy","com.review.repository","com.review.service"})
public class ProjectConfig {
}
