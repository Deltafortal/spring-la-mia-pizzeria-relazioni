package org.java.spring;

import java.util.List;

import org.java.spring.pojo.Ingredient;
import org.java.spring.pojo.Pizza;
import org.java.spring.pojo.SpecialSale;
import org.java.spring.serv.IngredientService;
import org.java.spring.serv.PizzaService;
import org.java.spring.serv.SpecialSaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class SpringLaMiaPizzeriaCrudApplication implements CommandLineRunner{

	
	@Autowired
	private PizzaService pizzaService;
	
	@Autowired
	private SpecialSaleService specialSaleService;
	
	@Autowired
	private IngredientService ingredientService;
	
	//Main function
	public static void main(String[] args) {
		SpringApplication.run(SpringLaMiaPizzeriaCrudApplication.class, args);
	}

	
	
	@Override
	public void run(String... args) throws Exception {
		
		
		Ingredient patate = new Ingredient("patate");
		Ingredient cipolla = new Ingredient("cipolla");
		Ingredient salsiccia = new Ingredient("salsiccia");
		Ingredient gorgonzola = new Ingredient("gorgonzola");
		
		ingredientService.save(patate);
		ingredientService.save(cipolla);
		ingredientService.save(salsiccia);
		ingredientService.save(gorgonzola);
		
		
		pizzaService.save(new Pizza("Pizza Margherita", "Una bellissima pizza margherita adatta a tutti grandi e piccoli", "https://upload.wikimedia.org/wikipedia/commons/c/c8/Pizza_Margherita_stu_spivack.jpg", 5.00));
		pizzaService.save(new Pizza("Pizza Mais e Ricotta", "Una pizza esotica  adatta ai veri degustatori, un pizzico di dolce misto col salato", "https://www.ricettedalmondo.it/images/foto-ricette/p/29294-pizza-mimosa.jpg", 7.00));
		pizzaService.save(new Pizza("Pizza patate e cipolla", "Sicuramente devi avere dei gusti discutibili, ma in ogni caso da Pizzeria da Aldo sei libero di fare schif.. coff coff, di mangiare!", "https://www.youcookit.net/it/wp-content/uploads/2021/06/pizza-patate-cipolle-rosmarino-07.jpg", 6.00));
		
		
		List<Pizza> pizzas = pizzaService.findAll();
		
		specialSaleService.save(new SpecialSale("Margherita Day", "07/12/2023", "08/12/2023", pizzas.get(0)));
		specialSaleService.save(new SpecialSale("Ricottone", "09/12/2023", "13/12/2023", pizzas.get(1)));
		
	}

}
