package com.review.repository;

import com.review.entity.Employee;
import lombok.Data;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
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

    // Not Equal
    @Query("SELECT e FROM Employee e WHERE e.salary <> ?1 ")
    List<Employee> getEmployeeSalaryNotEqual(int salary);

    //like/contains/startsWith/endswith
    @Query("SELECT e FROM Employee e WHERE e.firstName LIKE ?1")
    List<Employee> getEmployeeFirstNameLike(String pattern);

    // less than
    @Query("SELECT e FROM Employee  e WHERE e.salary < ?1")
    List<Employee> getEmployeeSalaryLessThan(int salary);

    // greater than
    @Query("SELECT e FROM Employee e WHERE e.salary > ?1")
    List<Employee> getEmployeeSalaryGreaterThan(int salary);

    // before
    @Query("SELECT e FROM Employee e WHERE e.hireDate > ?1")
    List<Employee> getEmployeeHireDateBefore(LocalDate date);

    // between
    @Query("SELECT e FROM Employee  e WHERE e.salary BETWEEN ?1 AND ?2")
    List<Employee> getEmployeeSalaryBetween(int Salary1, int Salary2);

    // Null
    @Query("SELECT e from Employee  e WHERE e.email IS NULL ")
    List<Employee> getEmployeeEmailIsNull();

    // IS NOT Null
    @Query("SELECT e FROM Employee  e WHERE e.email IS NOT NULL ")
    List<Employee> getEmployeeEmailIsNotNull();

    // Sorting in ascending order
    @Query("SELECT e FROM Employee  e ORDER BY e.salary")
    List<Employee> getEmployeeSalaryOrderAsc();

    // Sorting in descending order
    @Query("SELECT e FROM Employee  e ORDER BY e.salary DESC")
    List<Employee> getEmployeeSalaryOrderDesc();

    @Query(value = "SELECT * FROM Employee WHERE salary ?1", nativeQuery = true)
    List<Employee> readEmployeeDetailsBySalary(int salary);

    @Query("SELECT e FROM Employee e WHERE e.salary = :salary")
    List<Employee> getEmployeeSalary(@Param("salary") int salary);

    @Modifying
    @Transactional
    @Query("UPDATE Employee e SET e.email = 'admin@email.com' WHERE e.id= :id")
    void  updateEmployeeJPQL(@Param("id") int id);

    @Modifying
    @Transactional
    @Query(value = "UPDATE employees SET email = 'admin@email.com' WHERE id=:id",nativeQuery = true)
    void  updateEmployeeNativeQuery(@Param("id") int id);

}
