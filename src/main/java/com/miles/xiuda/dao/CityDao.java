package com.miles.xiuda.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.miles.xiuda.pojo.City;

@Repository
public interface CityDao {

	public List<City> getAllCity();

	public City getCityById(String bianhao);

}
