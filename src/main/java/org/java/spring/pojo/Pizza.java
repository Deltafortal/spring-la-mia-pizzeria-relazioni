package org.java.spring.pojo;

import org.hibernate.validator.constraints.Length;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;


@Entity
public class Pizza {

	//Declaring variables
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@NotNull
	@Length(min = 3, max = 40, message = "Il nome deve essere compreso tra i 3 e i 40 caratteri")
	private String nome;
	
	private String descrizione;
	private String url;
	
	@NotNull
	private double price;
	
	
	//Constructor 
	public Pizza() { }
	public Pizza(String nome, String descrizione, String url, double price) {
		
		setNome(nome);
		setDescrizione(descrizione);
		setUrl(url);
		setPrice(price);
		
	}
	
	
	
	
	
	//Id Functions
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	
	//Name functions
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
	//Description functions
	public String getDescrizione() {
		return descrizione;
	}
	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
	
	
	//URL functions
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	
	
	//Price functions
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
	
	
	
}
