package com.review.stereotype_annotations;

import com.review.bean_practice.AppConfig;
import com.review.stereotype_annotations.model.DataStructure;
import com.review.stereotype_annotations.model.ExtraHours;
import com.review.stereotype_annotations.model.MicroServices;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


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
