package com.hms.myspringdemo.dao;

import java.util.List;

import com.hms.myspringdemo.entity.City;

public interface CityDAO {
	
	public List<String> getCities();
//	public List<City> getCities();
	public int getCityId(String city);

}

