package com.hms.myspringdemo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import org.springframework.transaction.annotation.Transactional;

import com.hms.myspringdemo.entity.City;

@Component
@Repository
public class CityDAOImpl implements CityDAO {
	
	// need to inject the session factory
		@Autowired
		private SessionFactory sessionFactory;
		
		@Override
		@Transactional
		public List<String> getCities() {
			// get the current hibernate session
			Session currentSession = sessionFactory.getCurrentSession();
			
			//create a query
			Query theQuery1 = currentSession.createQuery("Select c.cityName from City c");
			
			List<String> cities = theQuery1.list();
			
			return cities;
		}
		
		@Override
		@Transactional
		public int getCityId(String city) {
			Session currentSession = sessionFactory.getCurrentSession();
			Query theQuery3 = currentSession.createQuery("Select id from City where cityName= :cityName");
			theQuery3.setParameter("cityName", city);
			int cityID = (int) theQuery3.uniqueResult();
			return cityID;
		}
		
		/*
		 * public List<City> getCities() {
		 * 
		 * // get the current hibernate session Session currentSession =
		 * sessionFactory.getCurrentSession();
		 * 
		 * // create a query
		 * 
		 * Query<City> theQuery = currentSession.createQuery("from City", City.class);
		 * 
		 * 
		 * // execute query and get result list List<City> cities =
		 * theQuery.getResultList();
		 * 
		 * // return the results return cities; }
		 */

}
