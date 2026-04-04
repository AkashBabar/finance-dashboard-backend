package com.finance.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.finance.entity.FinancialRecord;
import com.finance.enums.RecordType;
import com.finance.service.FinancialService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/records")
public class FinancialController {

	@Autowired
	private FinancialService service;

	//CREATE
	@PostMapping
	public FinancialRecord create(@RequestBody @Valid FinancialRecord record) {
		return service.createRecord(record);
	}

	//GET ALL
	@GetMapping
	public List<FinancialRecord> getAll() {
		return service.getAllRecords();
	}

	//GET BY ID
	@GetMapping("/{id}")
	public FinancialRecord getById(@PathVariable Long id) {
		return service.getRecordById(id);
	}

	// UPDATE
	@PutMapping("/{id}")
	public FinancialRecord update(@PathVariable Long id, @RequestBody @Valid FinancialRecord record) {
		return service.updateRecord(id, record);
	}

	//DELETE
	@DeleteMapping("/{id}")
	public String delete(@PathVariable Long id) {
		service.deleteRecord(id);
		return "Record deleted successfully";
	}

	//FILTER BY TYPE
	@GetMapping("/type/{type}")
	public List<FinancialRecord> getByType(@PathVariable RecordType type) {
		return service.getByType(type);
	}

	//FILTER BY CATEGORY
	@GetMapping("/category/{category}")
	public List<FinancialRecord> getByCategory(@PathVariable String category) {
		return service.getByCategory(category);
	}

	//FILTER BY DATE
	@GetMapping("/date/{date}")
	public List<FinancialRecord> getByDate(@PathVariable LocalDate date) {
		return service.getByDate(date);
	}
}