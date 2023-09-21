package com.review.stereotype_annotations.model;

import org.springframework.stereotype.Component;

@Component
public class MicroServices {

    public void getTotalHours(){
        System.out.println("Total hours: "+25);
    }
}
