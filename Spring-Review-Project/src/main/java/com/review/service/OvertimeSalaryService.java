package com.review.service;

import com.review.repository.EmployeeRepository;
import com.review.repository.HoursRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class OvertimeSalaryService
{
    EmployeeRepository employeeRepository;
    HoursRepository hoursRepository;

    public OvertimeSalaryService(EmployeeRepository employeeRepository,@Qualifier("overtimeHours") HoursRepository hoursRepository) {
        this.employeeRepository = employeeRepository;
        this.hoursRepository = hoursRepository;
    }

    public void calculateOverTimeSalary(){
        System.out.println(employeeRepository.getHourlyRate() * hoursRepository.getHours());
    }
}
