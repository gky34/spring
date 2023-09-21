package com.review.repository;

import com.review.model.Employee;
import org.springframework.stereotype.Component;

@Component
public class DBEmployeeRepository implements EmployeeRepository
{
    @Override
    public int getHourlyRate() {
        Employee employee = new Employee("Harold Finch","IT",75);

        return employee.getHourlyRate();
    }
}
