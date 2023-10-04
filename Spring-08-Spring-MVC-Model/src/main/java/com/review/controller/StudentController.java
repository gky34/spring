package com.review.controller;

import com.review.model.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Controller
public class StudentController
{
    @RequestMapping("/welcome")
    public String homePage(Model model){

        model.addAttribute("name","DemoApp");
        model.addAttribute("course","MVC");

        String subject = "Collection";
        model.addAttribute("subject",subject);

        //create some random studentId(0- 1000) and show it in your UI

        int studentId = new Random().nextInt(1000);
        model.addAttribute("studentID",studentId);

        List<Integer> numbers = new ArrayList<>();
        numbers.add(4);
        numbers.add(5);
        numbers.add(7);
        numbers.add(10);
        numbers.add(16);

        model.addAttribute("numbers",numbers);

        Student student = new Student(1,"Mike","Smith");
        model.addAttribute("student",student);

        return "student/welcome";
    }

}
