package com.go4food.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.go4food.entity.Order;

@Component
public class OrderDAO {
	
	@Autowired
	DishDAO dao;

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	public int getCount() {
		return this.jdbcTemplate.queryForObject("SELECT COUNT(*) FROM ORDER_TABLE", Integer.class);
	}

	public List<Order> getOrderByBill(String username, int bill) {

		try {
			return this.jdbcTemplate.query("SELECT * FROM ORDER_TABLE WHERE BILL_NO = ? AND USERNAME = ?",
					new Object[] { bill, username }, new RowMapper<Order>() {
						@Override
						public Order mapRow(ResultSet rs, int rownumber) throws SQLException {
							Order o = new Order(rs.getInt(1), rs.getString(2), dao.getDishByName(rs.getString(3)),
									rs.getInt(4), rs.getInt(5), rs.getString(6), rs.getString(7));
							return o;
						}
					});
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return new ArrayList<Order>();
		}
	}
}
