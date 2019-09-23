package sayner.sandbox.context.xml.controllers;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import sayner.sandbox.models.Music;
import sayner.sandbox.models.MusicPlayer;

@Controller
@RequestMapping(value = "/xml/hi")
public class GreetingsController {

	@GetMapping
	public String geetings() {

		System.out.println("Вызван метод geetings() контроллера GreetingsController по url /xml/hi");

		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");

		MusicPlayer musicPlayer=context.getBean("musicPlayerBean",MusicPlayer.class);
		
		musicPlayer.playMusic();

		context.close();

		return "bootstrap";
	}
}
