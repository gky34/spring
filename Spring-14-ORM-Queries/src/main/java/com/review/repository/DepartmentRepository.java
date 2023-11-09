package com.review.repository;

import com.review.entity.Department;
import com.review.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DepartmentRepository extends JpaRepository<Department, String>
{
    // Display all departments in the furniture department
    List<Department> findByDepartment(String department);

    // Display all departments in the Health Division
    List<Department> findByDivisionIs(String division);
    List<Department> findByDivisionEquals(String division);

    // Display top 3 departments with division name includes 'Hea', without duplicates
    List<Department> findDistinctTop3ByDivisionContains(String division);

    @Query("SELECT d FROM Department d WHERE d.division IN ?1")
    List<Department> getDepartmentDivision(List<String> division);

    List<Department> retrieveDepartmentByDivision(String division);

    @Query(value = "SELECT * FROM Department WHERE division LIKE concat('%',?1,'%') ",nativeQuery = true)
    List<Department> retrieveDepartmentByDivisionContain(String patter);

}
