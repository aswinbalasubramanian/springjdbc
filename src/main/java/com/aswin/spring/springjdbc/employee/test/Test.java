package com.aswin.spring.springjdbc.employee.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.aswin.spring.springjdbc.employee.dao.EmployeeDao;
import com.aswin.spring.springjdbc.employee.dto.Employee;

public class Test {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"com/aswin/spring/springjdbc/employee/test/config.xml");
		EmployeeDao employeeDao = (EmployeeDao) context.getBean("employeeDao");
		Employee employee = new Employee();
		employee.setId(2);
		employee.setFirstName("Antony");
		employee.setLastName("Ginting");
		// int result = employeeDao.create(employee);
		// int result = employeeDao.update(employee);
		// int result = employeeDao.delete(2);
		Employee record = employeeDao.read(1);
		System.out.println("Employee with id 1 :" + record);
	}

}
