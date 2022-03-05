package com.go4food.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.go4food.entity.Bill;

@Component
public class BillDAO {

	@Autowired
	OrderDAO dao;

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public List<Bill> getBillByUsername(String username) {
		return jdbcTemplate.query("SELECT * FROM BILL WHERE USERNAME = ? ORDER BY BILL_NO DESC",
				new Object[] { username }, new RowMapper<Bill>() {
					@Override
					public Bill mapRow(ResultSet rs, int rownumber) throws SQLException {
						Bill b = new Bill(rs.getInt(1), rs.getString(2), rs.getDouble(3), rs.getString(4),
								rs.getString(5), rs.getString(6), rs.getString(7),
								dao.getOrderByBill(username, rs.getInt(1)));
						return b;
					}
				});

	}
	
	public int getCount() {
		return this.jdbcTemplate.queryForObject("SELECT COUNT(*) FROM BILL", Integer.class);
	}
}
