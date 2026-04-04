package com.finance.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.finance.entity.FinancialRecord;
import com.finance.enums.RecordType;

public interface FinancialRecordRepository extends JpaRepository<FinancialRecord, Long> {

	//Filter by Type (INCOME / EXPENSE)
	List<FinancialRecord> findByType(RecordType type);

	//Filter by Category
	List<FinancialRecord> findByCategory(String category);

	//Filter by Exact Date
	List<FinancialRecord> findByDate(LocalDate date);

	//Filter by Date Range (Advanced)
	List<FinancialRecord> findByDateBetween(LocalDate start, LocalDate end);
}