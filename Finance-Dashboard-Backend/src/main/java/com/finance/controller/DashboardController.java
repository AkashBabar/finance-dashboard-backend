package com.finance.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.finance.service.DashboardService;

@RestController
@RequestMapping("/dashboard")
public class DashboardController {

	@Autowired
	private DashboardService service;

	//TOTAL SUMMARY
	@GetMapping("/summary")
	public Map<String, Double> getSummary() {
		return service.getSummary();
	}

	//CATEGORY SUMMARY
	@GetMapping("/category-summary")
	public Map<String, Double> getCategorySummary() {
		return service.getCategorySummary();
	}

	//MONTHLY SUMMARY
	@GetMapping("/monthly-summary")
	public List<Map<String, Object>> getMonthlySummary() {
		return service.getMonthlySummary();
	}
}