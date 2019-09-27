package sayner.sandbox.context.annotated.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import sayner.sandbox.context.annotated.models.Person;

@Controller
@RequestMapping("/welcome")
public class HelloWorldController {

	@Autowired
	private ApplicationContext appContext;

	private final Person person;

	/**
	 * 
	 */
	@Autowired
	public HelloWorldController(@Qualifier("personBean") Person person) {
		// TODO Auto-generated constructor stub
		this.person = person;
	}

	@GetMapping
	public ModelAndView helloWorld(HttpServletRequest request) {

		System.out.println("Вызван метод helloWorld() контроллера HelloWorldController по url /welcome");

		// From context
		Person person = this.appContext.getBean("personBean", Person.class);
		person.setName("I am the context person phhh");

		// Autowired
		System.out.println("this person Name = " + this.person.getName());

		System.out.println(String.format("context person Name is ===%s=== for %s%s uri", person.getName(),
				request.getRequestURL().toString(),
				request.getQueryString() == null ? "" : "?" + request.getQueryString()));

		System.out.println(String.format(
				"Указывают ли оба объекта ClassicRockMusicComponent на один и тот же участок в памяти? %b",
				person == this.person));

		String message = "Сюда даже хтмл можно"
				+ "<h3>Hello World, Spring MVC Tutorial</h3>This message is coming from CrunchifyHelloWorld.java";

		return new ModelAndView("welcome", "message", message);
	}
}
