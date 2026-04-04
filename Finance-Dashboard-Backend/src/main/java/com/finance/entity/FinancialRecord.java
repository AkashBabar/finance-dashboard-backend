package com.finance.entity;

import java.time.LocalDate;

import com.finance.enums.RecordType;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;

@Entity
@Data
public class FinancialRecord {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	//Amount must be positive
	@NotNull(message = "Amount is required")
	@Positive(message = "Amount must be greater than zero")
	private Double amount;

	//Type required
	@NotNull(message = "Type is required")
	@Enumerated(EnumType.STRING)
	private RecordType type;

	//Category required
	@NotBlank(message = "Category is required")
	private String category;

	//Date required
	@NotNull(message = "Date is required")
	private LocalDate date;

	
	private String description;

	@ManyToOne
	private User createdBy;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public RecordType getType() {
		return type;
	}

	public void setType(RecordType type) {
		this.type = type;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public User getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(User createdBy) {
		this.createdBy = createdBy;
	}
}