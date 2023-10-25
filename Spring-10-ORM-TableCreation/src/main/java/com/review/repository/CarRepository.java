package com.review.repository;

import com.review.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarRepository extends JpaRepository<Car,Long>
{

}

// Repository work with Entity, so we need to define as class entity name and ID type
// custom method we can add it as well
// sql code we can add it as well
// we can implement any logic and using the JPA methods