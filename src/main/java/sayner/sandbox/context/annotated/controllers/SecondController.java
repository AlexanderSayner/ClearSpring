package sayner.sandbox.context.annotated.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import sayner.sandbox.context.annotated.models.Person;

@Controller
@RequestMapping("/spring")
public class SecondController {

	@Autowired
	private ApplicationContext appContext;
	
	@GetMapping
	public ModelAndView someMethod(HttpServletRequest request) {

		Person person = this.appContext.getBean("personBean", Person.class);
		person.setName("I am just a person krya");
		
		System.out.println(String.format("context person Name is ===%s=== for %s%s uri", person.getName(),
				request.getRequestURL().toString(),
				request.getQueryString() == null ? "" : "?" + request.getQueryString()));
		
		String message = "Тут что-то умное должно было быть";
		return new ModelAndView("welcome", "message", message);
	}
}
