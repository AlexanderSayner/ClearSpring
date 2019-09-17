package sayner.sandbox.context.xml.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/xml/hi")
public class GreetingsController {

	@GetMapping
	public String geetings() {

		System.out.println("Вызван метод geetings() контроллера GreetingsController по url /hi");
		
		return "bootstrap";
	}
}
