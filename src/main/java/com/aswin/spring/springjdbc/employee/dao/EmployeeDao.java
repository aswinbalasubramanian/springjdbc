package com.aswin.spring.springjdbc.employee.dao;

import com.aswin.spring.springjdbc.employee.dto.Employee;

public interface EmployeeDao {

	int create( Employee employee );
	int update( Employee employee );
	int delete( int id );
}
