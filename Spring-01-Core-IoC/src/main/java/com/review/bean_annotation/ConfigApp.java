package com.review.bean_annotation;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;

public class ConfigApp
{
    @Bean
    FullTimeMentor fullTimeMentor(){

        return new FullTimeMentor();
    }

    //    @Bean(name = "p1")
    @Bean
    @Primary
    PartTimeMentor partTimeMentor(){

        return new PartTimeMentor();
    }

    //    @Bean(name = "p2")
    @Bean
    PartTimeMentor partTimeMentor2(){

        return new PartTimeMentor();
    }
}
