package org.java.spring.pojo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class SpecialSale {

	
	//variables
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String title;
	private String startingDate;
	private String endDate;
	
	
	
	@ManyToOne
	private Pizza pizza;
	
	
	
	//Constructor
	public SpecialSale(){}
	
	public SpecialSale(String title, String startingDate, String endDate) {
		
		
		setTitle(title);
		setStartingDate(startingDate);
		setEndDate(endDate);
	}

	
	
	
	//Title Functions
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}

	
	
	//Starting Date Functions
	public String getStartingDate() {
		return startingDate;
	}
	public void setStartingDate(String startingDate) {
		this.startingDate = startingDate;
	}
	
	
	
	//End Date Functions
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
}