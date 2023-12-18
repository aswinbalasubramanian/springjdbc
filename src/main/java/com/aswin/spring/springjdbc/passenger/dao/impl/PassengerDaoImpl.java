package com.aswin.spring.springjdbc.passenger.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.aswin.spring.springjdbc.passenger.dao.PassengerDao;
import com.aswin.spring.springjdbc.passenger.dao.rowmapper.PassengerRowMapper;
import com.aswin.spring.springjdbc.passenger.dto.Passenger;

@Component("passengerDao")
public class PassengerDaoImpl implements PassengerDao {

	@Autowired
	private JdbcTemplate jdbctemplate;

	@Override
	public int create(Passenger passenger) {
		String sql = "insert into passenger values(?,?,?)";
		int result = jdbctemplate.update(sql, passenger.getId(), passenger.getFirstName(), passenger.getLastName());

		return result;
	}

	@Override
	public int update(Passenger passenger) {
		String sql = "update passenger set firstname=?,lastname=? where id=?";
		int result = jdbctemplate.update(sql, passenger.getFirstName(), passenger.getLastName(), passenger.getId());

		return result;
	}

	@Override
	public int delete(int id) {
		String sql = "delete from passenger where id=?";
		int result = jdbctemplate.update(sql, id);
		return result;
	}

	@Override
	public Passenger read(int id) {
		String sql = "Select * from passenger where id=?";
		PassengerRowMapper rowMapper = new PassengerRowMapper();
		Passenger passenger = jdbctemplate.queryForObject(sql, rowMapper, id);
		return passenger;
	}

	@Override
	public List<Passenger> read() {
		String sql = "select * from passenger";
		PassengerRowMapper rowMapper = new PassengerRowMapper();
		List<Passenger> result = jdbctemplate.query(sql, rowMapper);
		return result;
	}

	public JdbcTemplate getJdbctemplate() {
		return jdbctemplate;
	}

	public void setJdbctemplate(JdbcTemplate jdbctemplate) {
		this.jdbctemplate = jdbctemplate;
	}

}
