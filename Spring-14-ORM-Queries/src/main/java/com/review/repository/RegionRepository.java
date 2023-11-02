package com.review.repository;

import com.review.entity.Region;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Set;

public interface RegionRepository extends JpaRepository<Region, Long>
{
    // Display all region in Canada
    List<Region> findByCountry(String country);

    // Display all region in Canada, without duplicates

    List<Region> findDistinctByCountry(String country);

    // Display all region with country name includes 'United'
    List<Region> findByCountryContaining(String country);

    // Display all regions with country name include 'United' in order
    List<Region> findByCountryContainingOrderByCountry(String country);

    // Display top 2 region in Canada
    List<Region> findTop2ByCountry(String country);




}
