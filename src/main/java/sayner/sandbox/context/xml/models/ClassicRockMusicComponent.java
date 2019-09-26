/**
 * 
 */
package sayner.sandbox.context.xml.models;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import sayner.sandbox.models.Music;

/**
 * @author uarchon
 *
 */
@Component("letIsRock")
//@Scope("prototype")
public class ClassicRockMusicComponent implements Music {

	@PostConstruct
	public void doMyInit() {
		System.out.println(String.format("init-method for %s.", this.getClass()));
	}
	
	@PreDestroy
	public void doMyDestroy() {
		System.out.println(String.format("destroy-method for %s.", this.getClass()));
	}
	
	@Override
	public String getSong() {

		return "Wings of Change";
	}

}
