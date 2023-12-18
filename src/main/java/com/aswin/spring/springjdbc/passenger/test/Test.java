package com.aswin.spring.springjdbc.passenger.test;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.aswin.spring.springjdbc.passenger.dao.PassengerDao;
import com.aswin.spring.springjdbc.passenger.dto.Passenger;

public class Test {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"com/aswin/spring/springjdbc/passenger/test/config2.xml");
		PassengerDao passengerDao = (PassengerDao) context.getBean("passengerDao");
		Passenger passenger = new Passenger();
		passenger.setId(5);
		passenger.setFirstName("Kutty");
		passenger.setLastName("Puli");
		//int result = passengerDao.create(passenger);
		// int result = passengerDao.update(passenger);
		// int result = passengerDao.delete(1);
		// Passenger record = passengerDao.read(5);
		 List<Passenger> result = passengerDao.read();
		//System.out.println("Passenger records :" + record);
		System.out.println("Passenger records :" + result);
	}
}
