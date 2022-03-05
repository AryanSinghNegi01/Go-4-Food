package com.go4food.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.go4food.dao.DishDAO;
import com.go4food.entity.Dish;

@RestController
@RequestMapping("/admin/dish")
public class DishController {

	@Autowired
	DishDAO dishDao;
	
	@GetMapping(value="/{name}")
	public Dish getDishByName(@PathVariable String name) {
		return dishDao.getDishByName(name);
	}
	
	@PostMapping(value="/add")
	public String addDish(@RequestBody Dish dish) {
		return dishDao.addDish(dish);
	}
	
	@PostMapping(value="/edit")
	public String updateDish(@RequestBody Dish dish) {
		return dishDao.updateDish(dish);
	}
	
	@DeleteMapping(value="/delete")
	public String deleteDish(@RequestBody String name) {
		return dishDao.deleteDish(name);
	}
	
	@PostMapping(value="toggle")
	public String toggleVisibility(@RequestParam int id) {
		return dishDao.toggleVisibility(id);
	}
}
