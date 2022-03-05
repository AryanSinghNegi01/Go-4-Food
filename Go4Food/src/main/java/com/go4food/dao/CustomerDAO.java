package com.go4food.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.go4food.entity.Customer;

@Component
public class CustomerDAO {
	
	@Autowired
	JdbcTemplate jdbcTemplate;


	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}


	public List<Customer> getAll() {
		return this.jdbcTemplate.query("SELECT FIRSTNAME, LASTNAME, USERNAME, EMAILID, MOBILENUMBER, ADDRESS, GENDER FROM customer", new BeanPropertyRowMapper(Customer.class));
	}
}
