package org.java.spring.controller;

import java.util.List;

import org.java.spring.pojo.Pizza;
import org.java.spring.serv.PizzaService;
import org.java.spring.serv.SpecialSaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

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
}
