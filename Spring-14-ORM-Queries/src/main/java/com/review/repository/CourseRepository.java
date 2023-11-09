package com.review.repository;

import com.review.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Stream;

public interface CourseRepository extends JpaRepository<Course,Long>
{
    // find all course by category
    List<Course> findByCategory(String category);

    // find all courses by category and order the entity by name
    List<Course> findByCategoryOrderByName(String category);

    // checks if a course with the provided name exist, return true if the course exist, false otherwise
    boolean existsByName(String name);

    // return the count of courses for the provided category
    int countByCategory(String category);

    // find all courses that start with the provided course name
    List<Course> findByNameStartsWith(String name);

    // find all courses by category and return a stream
    Stream<Course> streamByCategory(String name);

    @Query("SELECT c From Course c WHERE c.category = :category AND c.rating > :rating")
    List<Course> findAllByCategoryAndRatingGreaterThan(@Param("category") String category, @Param("rating") int rating);

}
