package com.finance.service;

import java.time.Month;
import java.util.*;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.finance.entity.FinancialRecord;
import com.finance.enums.RecordType;
import com.finance.repository.FinancialRecordRepository;

@Service
public class DashboardService {

	@Autowired
	private FinancialRecordRepository repo;

	//SUMMARY (income, expense, balance)
	public Map<String, Double> getSummary() {

		List<FinancialRecord> records = repo.findAll();

		double income = records.stream().filter(r -> r.getType() == RecordType.INCOME)
				.mapToDouble(r -> r.getAmount() != null ? r.getAmount() : 0.0).sum();

		double expense = records.stream().filter(r -> r.getType() == RecordType.EXPENSE)
				.mapToDouble(r -> r.getAmount() != null ? r.getAmount() : 0.0).sum();

		Map<String, Double> result = new HashMap<>();
		result.put("totalIncome", income);
		result.put("totalExpense", expense);
		result.put("netBalance", income - expense);

		return result;
	}

	//CATEGORY-WISE SUMMARY
	public Map<String, Double> getCategorySummary() {

		List<FinancialRecord> records = repo.findAll();

		return records.stream().collect(Collectors.groupingBy(FinancialRecord::getCategory,
				Collectors.summingDouble(r -> r.getAmount() != null ? r.getAmount() : 0.0)));
	}

	//MONTHLY SUMMARY (ADVANCED FEATURE 🔥)
	public List<Map<String, Object>> getMonthlySummary() {

		List<FinancialRecord> records = repo.findAll();

		Map<Month, Double> monthlyData = records.stream().collect(Collectors.groupingBy(r -> r.getDate().getMonth(),
				Collectors.summingDouble(r -> r.getAmount() != null ? r.getAmount() : 0.0)));

		List<Map<String, Object>> result = new ArrayList<>();

		for (Map.Entry<Month, Double> entry : monthlyData.entrySet()) {
			Map<String, Object> map = new HashMap<>();
			map.put("month", entry.getKey().toString());
			map.put("totalAmount", entry.getValue());
			result.add(map);
		}

		return result;
	}
}