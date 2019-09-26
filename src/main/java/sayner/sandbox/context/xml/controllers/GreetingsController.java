package sayner.sandbox.context.xml.controllers;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import sayner.sandbox.context.xml.models.ClassicRockMusicComponent;
import sayner.sandbox.context.xml.models.MusicPlayerComponent;

@Controller
@RequestMapping(value = "/xml/hi")
public class GreetingsController {

	@GetMapping
	public String geetings() {

		System.out.println("Вызван метод geetings() контроллера GreetingsController по url /xml/hi");

		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");

		// Из xml контекста
		// MusicPlayer musicPlayer = context.getBean("musicPlayerBean",
		// MusicPlayer.class);

		// musicPlayer.playMusic();

		// А этот класс уже с аннотацией @Component
		MusicPlayerComponent musicPlayerComponent = context.getBean("annotatedPlayer", MusicPlayerComponent.class);
		MusicPlayerComponent musicPlayerCompClone = context.getBean("annotatedPlayer", MusicPlayerComponent.class);

		musicPlayerComponent.playMusic();

		System.out.println(
				String.format("Указывают ли оба объекта MusicPlayerComponent на один и тот же участок в памяти? %b",
						musicPlayerComponent == musicPlayerCompClone));

		ClassicRockMusicComponent classicalMusicComponent = context.getBean("letIsRock",
				ClassicRockMusicComponent.class);
		ClassicRockMusicComponent classicalMusicCompClone = context.getBean("letIsRock",
				ClassicRockMusicComponent.class);

		System.out.println(String.format(
				"Указывают ли оба объекта ClassicRockMusicComponent на один и тот же участок в памяти? %b",
				classicalMusicComponent == classicalMusicCompClone));

		context.close();

		return "bootstrap";
	}
}
