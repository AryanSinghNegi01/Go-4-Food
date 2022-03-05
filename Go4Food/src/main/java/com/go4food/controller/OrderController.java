package com.go4food.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.go4food.dao.OrderDAO;
import com.go4food.entity.Order;

@RestController
@RequestMapping("/admin/order")
public class OrderController {

	@Autowired
	OrderDAO order;
	
	@GetMapping(value="/search")
	@ResponseBody
	public List<Order> getOrderByBill(@RequestParam String username, @RequestParam int bill) {
		return order.getOrderByBill(username, bill);
	}
	
	@GetMapping(value="/")
	public int getCount() {
		return order.getCount();
	}
	
}
