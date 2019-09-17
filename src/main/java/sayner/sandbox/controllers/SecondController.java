package sayner.sandbox.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/spring")
public class SecondController {

	@GetMapping
	public ModelAndView someMethod() {
		 
		String message = "Тут что-то умное должно было быть";
		return new ModelAndView("welcome", "message", message);
	}
}
