package com.hms.myspringdemo.dao;

import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import org.springframework.transaction.annotation.Transactional;

import com.hms.myspringdemo.entity.City;
import com.hms.myspringdemo.entity.HotelDetails;

@Component
@Repository
public class HotelDetailsDAOImpl implements HotelDetailsDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	@Transactional
	// public List<String> getHotels() {
	public Set<String> getHotels() {
		Session currentSession = sessionFactory.getCurrentSession();

		Query theQuery2 = currentSession.createQuery("Select h.hotelName from HotelDetails h");

		List<String> listHotels = theQuery2.list();

		// converting ArrayList to Hashset to avoid duplicate data
		Set<String> hotels = new HashSet<String>(listHotels);
		return hotels;
	}

	@Override
	@Transactional
	public int getAvailabilityStatus(int cityID, String hotelName, String cityName, String date) throws ParseException {
		Session currentSession = sessionFactory.getCurrentSession();
		
		//String jpql = "select c from City c join c.hotelDetails h where h.hotelName = :hotelName";
		//String jpql = "select c from HotelDetails h join h.city c where h.hotelName = :hotelName";
		String s = "select h.availableDate from HotelDetails h join h.city c where h.hotelName = :hotelName";
		s += " AND c.id=:id";
		Query q = currentSession.createQuery(s); 
		q.setParameter("hotelName", hotelName); 
		q.setParameter("id", cityID);
		System.out.println("type of query......"+q.getClass());
		//List<Date> listHotels = q.list();
		//System.out.println("\n\n\nafter,type of query......"+listHotels.getClass()+".... and size  "+listHotels.size()+ " element  "+listHotels.get(0));
		String d1 = q.uniqueResult().toString();
		//System.out.println(d1);
		SimpleDateFormat sdformat = new SimpleDateFormat("yyyy-MM-dd");
	      Date date1 = sdformat.parse(date);
	      Date date2 = sdformat.parse(d1);
	      System.out.println("The date 1 is: " + sdformat.format(date1));
	      System.out.println("The date 2 is: " + sdformat.format(date2));
	      if(date1.compareTo(date2) > 0 || date1.compareTo(date1) == 0) {
	    	  	System.out.println("selected date is more");
	    	  	String jpql = "select h.status from HotelDetails h join h.city c where h.hotelName = :hotelName";
	  			jpql += " AND c.id=:id";
	  			Query theQuery4 = currentSession.createQuery(jpql); 
	  			theQuery4.setParameter("hotelName", hotelName); 
	  			theQuery4.setParameter("id", cityID);
	  			int status = (int)theQuery4.uniqueResult();		
	  		
	  			return status;
	  			
	      } else  {
	    	  return 0;
	      }
		
		//String s1 = q.list().toString();
		//System.out.println("\n\n in getting date......."+s1);
		
		
	}
	
	@Override
	@Transactional
	public List<Object[]> getSelectedHotelDetails(int cityID,String hotelName, String cityName, int hotelStatus) {
		Session currentSession = sessionFactory.getCurrentSession();
		String jpql = "select h.price,h.gst,h.roomType from HotelDetails h join h.city c where h.hotelName = :hotelName";
		jpql += " AND c.id=:id AND h.status=:status";
		Query theQuery5 = currentSession.createQuery(jpql); 
		theQuery5.setParameter("hotelName", hotelName); 
		theQuery5.setParameter("id", cityID);
		theQuery5.setParameter("status", hotelStatus);
		List<Object[]> listHotelDetails= (List<Object[]>)theQuery5.list();
		/*
		 * for(Object[] employee: employees){ System.out.println(employee);
		 * System.out.println(employee[0].toString());
		 * System.out.println(employee[1].toString());
		 * System.out.println(employee[2].toString()); }
		 */
		//List<?> listHotelDetails = theQuery5.list();
		//System.out.println("Price" + listHotelDetails);
		//listHotelDetails.forEach((n) -> System.out.println(n));
		return listHotelDetails;
	}

}
