package com.classes.dao;

import com.classes.model.City;

public interface ICityDAO {
    City getCityById(Long id);
    City getCityByName(String name);
}
