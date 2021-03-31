package com.codegym.baithmd4.service.city;


import com.codegym.baithmd4.model.City;
import com.codegym.baithmd4.repository.ICityRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityService implements ICityService {

    @Autowired
    public ICityRepo cityRepo;


    @Override
    public List<City> findAll() {
        return (List<City>) cityRepo.findAll();
    }

    @Override
    public City findById(Long id) {
        return cityRepo.findById(id).get();
    }

    @Override
    public City save(City city) {
        return cityRepo.save(city);
    }

    @Override
    public void deleteById(Long id) {
        cityRepo.deleteById(id);
    }
}
