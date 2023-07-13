package Game;

public class Beat {
	private int time;
	private String noteName;
	private int keyNumber;
	
	public static int thisTime;
	
	public Beat(int time, String noteName, int keyNumber) {
		super();
		this.time = time;
		this.noteName = noteName;
		this.keyNumber = keyNumber;
	}
	public int getTime() {
		return time;
	}
	public void setTime(int time) {
		this.time = time;
	}
	public String getNoteName() {
		return noteName;
	}
	public void setNoteName(String noteName) {
		this.noteName = noteName;
	}
	public int getKeyNumber() {
		return keyNumber;
	}
	public void setKeyNumber(int keyNumber) {
		this.keyNumber = keyNumber;
	}
	
}