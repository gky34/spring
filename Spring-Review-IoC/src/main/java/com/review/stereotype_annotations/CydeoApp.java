package com.review.stereotype_annotations;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import stereotype_annotations.config.AppConfig;
import stereotype_annotations.model.DataStructure;
import stereotype_annotations.model.ExtraHours;
import stereotype_annotations.model.MicroServices;

public class CydeoApp {
    public static void main(String[] args) {

        ApplicationContext container = new AnnotationConfigApplicationContext(AppConfig.class);

        DataStructure dsa = container.getBean(DataStructure.class);
        dsa.getTotalHours();

        MicroServices ms = container.getBean(MicroServices.class);
        ms.getTotalHours();

        ExtraHours eh = container.getBean(ExtraHours.class);
        System.out.println(eh.getHours());
    }
}
