package com.review.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Mentor
{
    private String firstName;
    private String lastName;
    private String email;
    private String gender;
    private String graduated;
    private String company;
    private String batch;

}
