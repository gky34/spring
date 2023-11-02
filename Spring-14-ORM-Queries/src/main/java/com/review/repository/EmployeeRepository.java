package com.review.repository;

import com.review.entity.Employee;
import lombok.Data;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee, Long>
{
    // Display all employees with email address ' '
    List<Employee> findByEmail(String email);

    // Display all employees with firsName ' ' + lastName ' ' + also show all employees with a email address
    List<Employee> findByFirstNameAndLastNameOrEmail(String firstName, String lastName, String email);

    // Display all employees first name is not ' '
    List<Employee> findByFirstNameIsNot(String firstName);

    // Display all employees where last name starts with
    List<Employee> findByLastNameStartingWith(String firstName);

    // Display all employees with salaries higher than ' '
    List<Employee> findBySalaryGreaterThan(Integer salary);

    // Display all employees with salaries less than equal ' '
    List<Employee> findBySalaryLessThanEqual(Integer salary);

    // Display all employees that has been hired between '' and ''
    List<Employee> findByHireDateBetween(LocalDate startDate, LocalDate endDate);

    // Display all employees salary greater and equal to ' ' in order
    List<Employee> findBySalaryIsGreaterThanEqualOrderBySalaryDesc(Integer salary);

    // Display top unique 3 employees that is making less than
    List<Employee> findDistinctTop3BySalaryLessThan(Integer salary);

    // Display all employees that do not have email address
    List<Employee> findByEmailIsNull(String email);


    // Jpa Query

    @Query("Select e FROM Employee e WHERE e.email = 'sdubber7@t-online.de'")
    Employee getEmployeeDetails();

    @Query("Select e.salary FROM Employee e WHERE e.email='sdubber7@t-online.de'")
    Integer getEmployeeSalary();


    @Query("SELECT e FROM Employee e WHERE e.email=?1")
    Optional<Employee> getEmployeeDetails(String email);

    @Query("SELECT e FROM Employee  e WHERE e.email=?1 AND e.salary=?2")
    Optional<Employee> getEmployeeDetails(String email, int salary);

}
