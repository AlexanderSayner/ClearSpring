/**
 * 
 */
package sayner.sandbox.models.impl;

import sayner.sandbox.models.Music;

/**
 * @author uarchon
 *
 */
public class ClassicalMusic implements Music {

	/**
	 * new делать больше нельзя
	 */
	private ClassicalMusic() {

	}

	/**
	 * Паттерн фабричного метода
	 * 
	 * @return
	 */
	public static ClassicalMusic getClassicalMusic() {
		return new ClassicalMusic();
	}

	void doMyInit() {

		// Работает, но выводить в консоль не хочу
		//System.out.println(String.format("init-method for %s. Package: sayner.sandbox.models.impl", this.getClass()));
	}

	void doMyDestroy() {

		//System.out.println(String.format("destroy-method for %s. Package: sayner.sandbox.models.impl", this.getClass()));
	}

	@Override
	public String getSong() {

		return "Hungarian Rhapsody";
	}

}
