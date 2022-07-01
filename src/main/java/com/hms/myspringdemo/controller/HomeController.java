package com.hms.myspringdemo.controller;

import java.text.ParseException;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.hms.myspringdemo.dao.CityDAO;
import com.hms.myspringdemo.dao.HotelDetailsDAO;
import com.hms.myspringdemo.entity.City;
import com.hms.myspringdemo.entity.HotelDetails;
import com.sun.istack.logging.Logger;

@Controller
public class HomeController {
	
	//need a controller method to show the initial HTML form
	@Autowired(required=true)
	private CityDAO cityDAO;
	
	@Autowired(required=true)
	private HotelDetailsDAO hotelDetailsDAO;
	
	@RequestMapping("/")
	public String goToForm() {
		return "home-page";
	}
	
	  @RequestMapping("/showForm")  
	  public String showCheckAvailablityForm(Model theModel) { 
		
			//List<City> theCities = cityDAO.getCities();
			List<String> theCities = cityDAO.getCities();
				
			Set<String> theHotels = hotelDetailsDAO.getHotels();
			
			// add the customers to the model
			theModel.addAttribute("cities", theCities);
			theModel.addAttribute("hotels", theHotels);
			
			 
			//printing the data fetched
			System.out.println("In HomeController showCheckAvailability method where city name is being fetched from city table");
			theCities.forEach((n) -> System.out.println(n));
			
			System.out.println("printing hotels");
			for (String temp : theHotels) {
	            System.out.print(temp + " ");
	        }
					
		  return "checkAvailability-form"; 
	  }
	  
		
		  @RequestMapping("/search") 
		  public String searchResult(@RequestParam(value="cityName") String theCityName, @RequestParam(value="hotelName") String thehotelName, @RequestParam(value="date") String theDate, Model theModel) {
			//System.out.println(theDate.getClass());
			int i = cityDAO.getCityId(theCityName);
			/*
			 * List<?> theHotelStatus =
			 * hotelDetailsDAO.getAvailabilityStatus(i,thehotelName,theCityName);
			 * theHotelStatus.forEach((n) -> System.out.println(n));
			 */ 
			int theHotelStatus = 0;
			try {
				theHotelStatus = hotelDetailsDAO.getAvailabilityStatus(i,thehotelName,theCityName,theDate);
			} catch (ParseException e) {
				e.printStackTrace();
			}
				
			//System.out.println("here is staus: "+ hotelDetailsDAO.getAvailabilityStatus(i,thehotelName));
			 int total;
			if(theHotelStatus == 0) {
				return "hotel-nonAvailability";
			}else {
				List<Object[]> theHotelDetails = hotelDetailsDAO.getSelectedHotelDetails(i,thehotelName,theCityName,theHotelStatus);
				for(Object[] details: theHotelDetails){ System.out.println(details);
				  theModel.addAttribute("price", details[0].toString());
				  theModel.addAttribute("gst", details[1].toString());
				  theModel.addAttribute("roomtype", details[2].toString());
				  //theModel.addAttribute("hotelId", (int)details[3]);
				  total = (int)details[0]+((int)details[0]* (int)details[1])/100;
				  theModel.addAttribute("total", total);
				  theModel.addAttribute("hotelName", thehotelName);
				  }
				
				return "hotel-confirmation";
			}
		  }
		  
		  @RequestMapping("/register") 
			  public String registerCustomer(@RequestParam(value="hotelName") String thehotelName, Model theModel) {
			  theModel.addAttribute("hotelName", thehotelName);
				  return "registration-form";
			  }
		  
		  @RequestMapping("/reserveGuest")
		  	public String reservedGuest() {
			  return "reserved-guest";
		  }
}
