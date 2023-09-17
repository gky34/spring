package com.review;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class Java {

    // Field Injection which is not recommended
//    @Autowired
//    OfficeHours officeHours;


    OfficeHours officeHours;

//    @Autowired
//    public Java(OfficeHours officeHours) {
//        this.officeHours = officeHours;
//    }

    public void getTeachingHours(){
        System.out.println("Weekly teaching hours  : " + (15 + officeHours.getHours()));
    }
}
