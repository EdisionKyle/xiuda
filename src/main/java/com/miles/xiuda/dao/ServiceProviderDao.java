package com.miles.xiuda.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.miles.xiuda.pojo.City;
import com.miles.xiuda.pojo.ServiceProvider;

@Repository
public interface ServiceProviderDao extends BaseDao<ServiceProvider>{

	public List<City> getAllCity();

	public City getCityById(String bianhao);

}
