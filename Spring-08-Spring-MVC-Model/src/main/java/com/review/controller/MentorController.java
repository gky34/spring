package com.review.controller;

import com.review.enums.Gender;
import com.review.model.Mentor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("mentor")
public class MentorController
{

    @RequestMapping("/list")
    public String showTable(Model module){

        List<Mentor> mentorList = new ArrayList<>();
        mentorList.add(new Mentor("Mike","Smith",45, Gender.MALE));
        mentorList.add(new Mentor("Tom","Hanks",65, Gender.MALE));
        mentorList.add(new Mentor("Ammy","Bryan",24, Gender.FEMALE));


        module.addAttribute("mentors", mentorList);

        return "/mentor/mentor-list.html";
    }
}
