package com.review.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name="departments")
@Data
@NoArgsConstructor
public class Department extends BaseEntity{

    private String department;
    private String division;

    // department name has to match whatever we define in employee class
    // we don't want to own this relationship so  mappedBy = "department"
    // employee table has the foreignerkey and owns the relationship
    @OneToOne(mappedBy = "department")
    private Employee employee;

    public Department(String department, String division) {
        this.department = department;
        this.division = division;
    }
}
