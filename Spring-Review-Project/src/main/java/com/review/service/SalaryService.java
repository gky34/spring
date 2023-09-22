package com.review.service;

import com.review.repository.EmployeeRepository;
import com.review.repository.HoursRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class SalaryService {

    HoursRepository hoursRepository;
    EmployeeRepository employeeRepository;

    public SalaryService(EmployeeRepository employeeRepository,@Qualifier("RH") HoursRepository hoursRepository) {
        this.hoursRepository = hoursRepository;
        this.employeeRepository = employeeRepository;
    }

    public void calculateRegularSalary(){

        System.out.println(employeeRepository.getHourlyRate() * hoursRepository.getHours());

    }
}
