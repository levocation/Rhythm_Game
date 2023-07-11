package Game;

import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.ImageIcon;

public class Note extends Thread {
	
	private Image noteBasicImage_4B = new ImageIcon(Main.class.getResource("../images/noteBasic_4B.png")).getImage();
	private Image noteBasicImage_5B = new ImageIcon(Main.class.getResource("../images/noteBasic_5B.png")).getImage();
	private Image noteBasicImage_6B = new ImageIcon(Main.class.getResource("../images/noteBasic_6B.png")).getImage();
	private Image noteBasicImage_7B = new ImageIcon(Main.class.getResource("../images/noteBasic_7B.png")).getImage();
	
	private int x, y = 580 - 1000 / Main.SLEEP_TIME * Main.NOTE_SPEED;
	private int noteType; // keyNumber
	
	public Note(int x, int noteType) {
		this.x = x;
		this.noteType = noteType;
	}
	
	public void screenDraw(Graphics2D g) {
		switch (noteType) {
		case 4:
			g.drawImage(noteBasicImage_4B, x, y, null);
			break;
		case 5:
			g.drawImage(noteBasicImage_5B, x, y, null);
			break;
		case 6:
			g.drawImage(noteBasicImage_6B, x, y, null);
			break;
		case 7:
			g.drawImage(noteBasicImage_7B, x, y, null);
			break;

		default:
			break;
		}
	}
	
	public void drop() {
		y += Main.NOTE_SPEED;
	}
	
	@Override
	public void run() {
		try {
			while (true) {
				drop();
				Thread.sleep(Main.SLEEP_TIME);
			}
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}
}
