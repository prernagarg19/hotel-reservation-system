package com.hms.myspringdemo.dao;

import java.text.ParseException;
import java.util.List;
import java.util.Set;

import com.hms.myspringdemo.entity.City;
import com.hms.myspringdemo.entity.HotelDetails;

public interface HotelDetailsDAO {
	
	public Set<String> getHotels();
	
	// public List<?> getAvailabilityStatus(int cityID,String hotelName, String cityName);
	public int getAvailabilityStatus(int cityID,String hotelName, String cityName, String date) throws ParseException;
	
	public List<Object[]> getSelectedHotelDetails(int cityID,String hotelName, String cityName, int hotelStatus);
}

