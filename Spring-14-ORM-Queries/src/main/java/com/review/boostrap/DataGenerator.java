package com.review.boostrap;

import com.review.entity.Employee;
import com.review.repository.CourseRepository;
import com.review.repository.DepartmentRepository;
import com.review.repository.EmployeeRepository;
import com.review.repository.RegionRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataGenerator implements CommandLineRunner
{
    private final RegionRepository regionRepository;
    private final DepartmentRepository departmentRepository;
    private final EmployeeRepository employeeRepository;
    private final CourseRepository courseRepository;

    public DataGenerator(RegionRepository regionRepository, DepartmentRepository departmentRepository, EmployeeRepository employeeRepository, CourseRepository courseRepository) {
        this.regionRepository = regionRepository;
        this.departmentRepository = departmentRepository;
        this.employeeRepository = employeeRepository;
        this.courseRepository = courseRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        System.out.println("------------REGION START  ----------------");

        System.out.println(regionRepository.findByCountry("Canada"));
        System.out.println(regionRepository.findDistinctByCountry("Canada"));
        System.out.println(regionRepository.findByCountryContaining("United"));
        System.out.println(regionRepository.findByCountryContainingOrderByCountry("United"));
        System.out.println(regionRepository.findTop2ByCountry("Canada"));

        System.out.println("------------REGION END  ----------------");

        System.out.println("------------DEPARTMENT START  ----------------");

        System.out.println(departmentRepository.findByDepartment("Toys"));
        System.out.println(departmentRepository.findByDivisionIs("Outdoors"));
        System.out.println(departmentRepository.findDistinctTop3ByDivisionContains("Hea"));


        System.out.println("------------DEPARTMENT END  ----------------");

        System.out.println("------------EMPLOYEE START  ----------------");

        System.out.println(employeeRepository.getEmployeeDetails());
        System.out.println(employeeRepository.getEmployeeSalary());

        System.out.println("------------EMPLOYEE END  ----------------");


        System.out.println("------------COURSE START  ----------------");

        System.out.println(" ---------------------------------------------");
        courseRepository.findByCategory("Spring").forEach(System.out::println);

        System.out.println(" ---------------------------------------------");
        courseRepository.findByCategoryOrderByName("Spring").forEach(System.out::println);

        System.out.println(" ---------------------------------------------");
        System.out.println(courseRepository.existsByName("Spring"));

        System.out.println(" ---------------------------------------------");
        System.out.println(courseRepository.countByCategory("Spring"));

        System.out.println(" ---------------------------------------------");
        courseRepository.findByNameStartsWith("Scalable").forEach(System.out::println);

        System.out.println(" ---------------------------------------------");
        courseRepository.streamByCategory("Spring").forEach(System.out::println);


        System.out.println("------------COURSE END  ----------------");
    }
}
