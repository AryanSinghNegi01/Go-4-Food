package com.go4food.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.go4food.dao.CustomerDAO;
import com.go4food.dao.DishDAO;
import com.go4food.entity.Customer;
import com.go4food.entity.Dish;

@RestController
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	CustomerDAO custDao;
	
	@Autowired
	DishDAO dishDao;
	
	@GetMapping(value="/users")
	public List<Customer> getAllUsers() {
		return custDao.getAll();
	}
	
	@GetMapping(value="/dish")
	public List<Dish> getDishes() {
		return dishDao.getAllDishes();
	}
	
	
}
