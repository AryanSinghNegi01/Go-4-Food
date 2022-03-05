package com.go4food.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.go4food.entity.Dish;

@Component
public class DishDAO {

	@Autowired
	JdbcTemplate jdbcTemplate;

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public List<Dish> getAllDishes() {
		return jdbcTemplate.query("SELECT * FROM dish", new BeanPropertyRowMapper<Dish>(Dish.class));
	}

	public Dish getDishByName(String name) {
		return jdbcTemplate.query("SELECT * FROM dish WHERE name = ?", new Object[] { name },
				new BeanPropertyRowMapper<Dish>(Dish.class)).get(0);
	}

	public String addDish(Dish dish) {
		try {
			jdbcTemplate.update("INSERT INTO dish VALUES (dish_seq.nextval,?,?,?,?,?,?)",
					new Object[] { dish.getName(), dish.getPrice(), dish.getDiscount(), dish.getImage_url(),
							dish.getCategory(), dish.getVisibility() });
			return "Dish successfully added.";
		} catch (Exception e) {
			return "Couldn't add dish.";
		}
	}

	public String deleteDish(String name) {
		try {
			jdbcTemplate.update("DELETE FROM dish WHERE name = ?", new Object[] { name });
			return "Dish deleted successfully.";
		} catch (Exception e) {
			// TODO: handle exception
			return "Couldn't deleted dish.";
		}
	}

	public String updateDish(Dish dish) {
		try {
			jdbcTemplate.update(
					"UPDATE DISH SET name = ?, price = ?, discount = ?, image_url = ?, category = ?, visibility = ?",
					new Object[] { dish.getName(), dish.getPrice(), dish.getDiscount(), dish.getImage_url(),
							dish.getCategory(), dish.getVisibility() });
			return "Dish successfully updated.";
		} catch (Exception e) {
			// TODO: handle exception
			return "Couldn't update dish";
		}
	}

	public String toggleVisibility(int id) {
		try {
			String a = jdbcTemplate.queryForObject("SELECT visibility FROM DISH where id = ?", new Object[] { id },
					String.class);
			if (a.equalsIgnoreCase("Y")) {
				jdbcTemplate.update("UPDATE DISH SET visibility = ? WHERE id = ?", new Object[] { "N", id });
				return "VISIBILITY - OFF";
			} else {
				jdbcTemplate.update("UPDATE DISH SET visibility = ? WHERE id = ?", new Object[] { "Y", id });
				return "VISIBILITY - ON";
			}
		} catch (Exception e) {
			// TODO: handle exception
			return "Invalid Dish-id";
		}
	}

}
