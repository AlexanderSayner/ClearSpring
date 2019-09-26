/**
 * 
 */
package sayner.sandbox.context.xml.models;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import sayner.sandbox.models.Music;

/**
 * @author uarchon
 *
 */
@Component("annotatedPlayer")
public class MusicPlayerComponent {

	// Любой жанр
	private final Music music;

	@Value("${musicPlayer.name}")
	private String name;
	@Value("${musicPlayer.volume}")
	private int volume;

	@Autowired
	public MusicPlayerComponent(@Qualifier("letIsRock") Music music) {

		this.music = music;
	}

	/*
	 * getter'ы & setter'ы
	 */

	/**
	 * 
	 * @param music
	 */

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getVolume() {
		return this.volume;
	}

	public void setVolume(int volume) {
		this.volume = volume;
	}

	/**
	 * 
	 */
	public void playMusic() {

		System.out.println(
				String.format("Playing: %s. Name: %s, volume: %d", this.music.getSong(), this.name, this.volume));
	}
}
