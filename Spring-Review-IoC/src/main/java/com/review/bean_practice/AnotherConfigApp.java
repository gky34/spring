package com.review.bean_practice;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class AnotherConfigApp {

    @Bean("String 1")
    public String str1(){
        return "Welcome to Cydeo App";
    }

    @Bean
    public String str2(){
        return "Spring Core Practice";
    }

}
