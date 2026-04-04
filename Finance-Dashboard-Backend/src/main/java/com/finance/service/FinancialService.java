package com.finance.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.finance.entity.FinancialRecord;
import com.finance.enums.RecordType;
import com.finance.repository.FinancialRecordRepository;

@Service
public class FinancialService {

	@Autowired
	private FinancialRecordRepository repo;

	//CREATE
	public FinancialRecord createRecord(FinancialRecord record) {
		if (record == null) {
			throw new RuntimeException("Record cannot be null");
		}
		return repo.save(record);
	}

	//READ ALL
	public List<FinancialRecord> getAllRecords() {
		return repo.findAll();
	}

	//READ BY ID
	public FinancialRecord getRecordById(Long id) {
		return repo.findById(id).orElseThrow(() -> new RuntimeException("Record not found with id: " + id));
	}

	//UPDATE
	public FinancialRecord updateRecord(Long id, FinancialRecord updatedRecord) {

		FinancialRecord existing = repo.findById(id)
				.orElseThrow(() -> new RuntimeException("Record not found with id: " + id));

		existing.setAmount(updatedRecord.getAmount());
		existing.setType(updatedRecord.getType());
		existing.setCategory(updatedRecord.getCategory());
		existing.setDate(updatedRecord.getDate());
		existing.setDescription(updatedRecord.getDescription());

		return repo.save(existing);
	}

	//DELETE
	public void deleteRecord(Long id) {

		FinancialRecord record = repo.findById(id)
				.orElseThrow(() -> new RuntimeException("Record not found with id: " + id));

		repo.delete(record);
	}

	//FILTER BY CATEGORY
	public List<FinancialRecord> getByCategory(String category) {
		return repo.findByCategory(category);
	}

	//FILTER BY TYPE
	public List<FinancialRecord> getByType(RecordType type) {
		return repo.findByType(type);
	}

	//FILTER BY DATE
	public List<FinancialRecord> getByDate(LocalDate date) {
		return repo.findByDate(date);
	}
}