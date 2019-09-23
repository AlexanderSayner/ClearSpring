/**
 * 
 */
package sayner.sandbox.models;

/**
 * @author uarchon
 *
 */
public class MusicPlayer {

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

	// Любой жанр
	private Music music;
	
	private String name;
	private int volume;

	public MusicPlayer() {
	}

	/**
	 * <constructor-arg ref="musicBean" />
	 * 
	 * @param music
	 */
	public MusicPlayer(Music music) {

		this.music = music;
	}

	/**
	 * 
	 * @param music
	 */
	public void setMusic(Music music) {

		this.music = music;
	}

	/**
	 * 
	 */
	public void playMusic() {

		System.out.println(String.format("Playing: %s. Name: %s, volume: %d", this.music.getSong(),this.name,this.volume));
	}
}
