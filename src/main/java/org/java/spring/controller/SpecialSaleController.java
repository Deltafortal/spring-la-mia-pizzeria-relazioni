package org.java.spring.controller;

import java.util.List;

import org.java.spring.dto.PizzaSpecialSaleDTO;
import org.java.spring.pojo.Pizza;
import org.java.spring.pojo.SpecialSale;
import org.java.spring.serv.PizzaService;
import org.java.spring.serv.SpecialSaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class SpecialSaleController {

	
	@Autowired
	private PizzaService pizzaService;
	
	@Autowired
	private SpecialSaleService specialSaleService;
	
	
	@GetMapping("/pizza/specialSale")
	public String getSpecialSale(Model model) {
		
		List<Pizza> pizza = pizzaService.findAll();
		model.addAttribute("pizza", pizza);
		
		return "special-sale-form";
	}
	
	
	@PostMapping("/pizza/specialSale")
	public String storeSpecialSale(@ModelAttribute PizzaSpecialSaleDTO pizzaSpecialSaleDTO) {
		
		
		Pizza pizza = pizzaService.findById(pizzaSpecialSaleDTO.getPizza_id());
		
		SpecialSale specialSale = new SpecialSale(pizzaSpecialSaleDTO.getTitle(), "dataInizio", "dataFine", pizza);
		
		specialSaleService.save(specialSale);
		
		
		return "redirect:/";
	}
}
