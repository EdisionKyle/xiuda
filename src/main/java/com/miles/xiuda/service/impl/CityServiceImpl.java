package com.miles.xiuda.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.miles.xiuda.dao.CityDao;
import com.miles.xiuda.pojo.City;
import com.miles.xiuda.service.CityService;

@Service
public class CityServiceImpl implements CityService {

	@Resource
	private CityDao cityDao;

	public List<City> getAllCity() {
		return cityDao.getAllCity();
	}

	public City getCityById(String bianhao) {
		return cityDao.getCityById(bianhao);
	}

}
