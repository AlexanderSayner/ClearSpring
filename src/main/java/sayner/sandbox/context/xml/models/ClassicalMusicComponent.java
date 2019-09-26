/**
 * 
 */
package sayner.sandbox.context.xml.models;

import org.springframework.stereotype.Component;

import sayner.sandbox.models.Music;

/**
 * @author uarchon
 * 
 */
@Component("calssicalSong")
public class ClassicalMusicComponent implements Music {

	@Override
	public String getSong() {

		return "Hungarian Rhapsody";
	}

}
