package com.codegym.baithmd4.service.country;


import com.codegym.baithmd4.model.Country;
import com.codegym.baithmd4.repository.ICountryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryService implements ICountryService {

    @Autowired
    private ICountryRepo countryRepo;

    @Override
    public List<Country> findAll() {
        return (List<Country>) countryRepo.findAll();
    }

    @Override
    public Country findById(Long id) {
        return null;
    }

    @Override
    public Country save(Country country) {
        return countryRepo.save(country);
    }

    @Override
    public void deleteById(Long id) {

    }
}
