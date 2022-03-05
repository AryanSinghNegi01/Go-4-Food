package com.go4food.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.go4food.dao.BillDAO;
import com.go4food.entity.Bill;

@RestController
@RequestMapping("/admin/bill")
public class BillController {

	@Autowired
	BillDAO bill;
	
	@GetMapping(value="/{username}")
	public List<Bill> getBillByUsername(@PathVariable String username) {
		return bill.getBillByUsername(username);
	}
	
	@GetMapping(value="/")
	public int getCount() {
		return bill.getCount();
	}
	
}
