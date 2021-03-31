package com.codegym.baithmd4.repository;

import com.codegym.baithmd4.model.City;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICityRepo extends PagingAndSortingRepository<City, Long> {

}
