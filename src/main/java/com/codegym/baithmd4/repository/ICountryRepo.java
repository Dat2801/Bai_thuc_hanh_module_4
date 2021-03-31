package com.codegym.baithmd4.repository;


import com.codegym.baithmd4.model.Country;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICountryRepo extends PagingAndSortingRepository<Country, Long> {
}
