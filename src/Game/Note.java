package Game;

import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.ImageIcon;

public class Note extends Thread {
	
	private Image noteBasicImage_4B = new ImageIcon(Main.class.getResource("../images/noteBasic_4B.png")).getImage();
	private Image noteBasicImage_5B = new ImageIcon(Main.class.getResource("../images/noteBasic_5B.png")).getImage();
	private Image noteBasicImage_6B = new ImageIcon(Main.class.getResource("../images/noteBasic_6B.png")).getImage();
	private Image noteBasicImage_7B = new ImageIcon(Main.class.getResource("../images/noteBasic_7B.png")).getImage();

	private Image keyPlusImage = new ImageIcon(Main.class.getResource("../images/KeyPlus.jpg")).getImage();
	private Image keyMinusImage = new ImageIcon(Main.class.getResource("../images/KeyMinus.jpg")).getImage();
	
	private String getKey;
	
	private int x, y = 580 - (1000 / Main.SLEEP_TIME * Main.NOTE_SPEED) * Main.REACH_TIME;
	private int noteType; // keyNumber
	public boolean proceeded = true;
	
	public boolean isProceeded() {
		return proceeded;
	}
	
	public String getKey() {
		return getKey;
	}
	
	public void close() {
		proceeded = false;
	}
	
	public Note(String getKey, int noteType) {
		this.noteType = noteType;
		this.getKey = getKey;
		
		if (getKey.equals("Plus")) {
			this.x = 250;
		} else if (getKey.equals("Minus")) {
			this.x = 250;
		} else {
			switch (noteType) {
			case 4:
				if (getKey.equals("X")) this.x = 250;
				else if (getKey.equals("C")) this.x = 454;
				else if (getKey.equals(",")) this.x = 658;
				else if (getKey.equals(".")) this.x = 862;
				break;
			case 5:
				if (getKey.equals("X")) this.x = 250;
				else if (getKey.equals("C")) this.x = 411;
				else if (getKey.equals("SPACE")) this.x = 572;
				else if (getKey.equals(",")) this.x = 733;
				else if (getKey.equals(".")) this.x = 894;
				break;
			case 6:
				if (getKey.equals("Z")) this.x = 250;
				else if (getKey.equals("X")) this.x = 384;
				else if (getKey.equals("C")) this.x = 518;
				else if (getKey.equals(",")) this.x = 652;
				else if (getKey.equals(".")) this.x = 786;
				else if (getKey.equals("/")) this.x = 920;
				break;
			case 7:
				if (getKey.equals("Z")) this.x = 250;
				else if (getKey.equals("X")) this.x = 365;
				else if (getKey.equals("C")) this.x = 480;
				else if (getKey.equals("SPACE")) this.x = 595;
				else if (getKey.equals(",")) this.x = 710;
				else if (getKey.equals(".")) this.x = 825;
				else if (getKey.equals("/")) this.x = 940;
				break;
			default:
				break;
			}
		}
	}
	
	public void screenDraw(Graphics2D g) {
		if (getKey.equals("Plus")) {
			g.drawImage(keyPlusImage, x, y, null);
		} else if (getKey.equals("Minus")) {
			g.drawImage(keyMinusImage, x, y, null);
		} else {
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
	}
	
	public void drop() {
		y += Main.NOTE_SPEED;
		
		if (( (!getKey.equals("Plus")) && (!getKey.equals("Minus")) ) && y > 640) {
			System.out.println("Miss");
			close();
		}
	}
	
	@Override
	public void run() {
		try {
			while (true) {
				drop();
				if (proceeded) {
					Thread.sleep(Main.SLEEP_TIME);
				} else {
					interrupt();
					break;
				}
			}
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}

	public int judge() {
		if (getKey.equals("Plus")) {
			if (y >= 573) {
				System.out.println("Plus");
				close();
				return 1;
			}
			return 0;
		}
		else if (getKey.equals("Minus")) {
			if (y >= 573) {
				System.out.println("Minus");
				close();
				return -1;
			}
			return 0;
		}
		else {
			if (y >= 613) {
				System.out.println("Late");
				close();
			} else if (y >= 600) {
				System.out.println("Good");
				close();
			} else if (y >= 587) {
				System.out.println("Cool");
				close();
			} else if (y >= 573) {
				System.out.println("Prefect");
				close();
			} else if (y >= 565) {
				System.out.println("Cool");
				close();
			} else if (y >= 550) {
				System.out.println("Good");
				close();
			} else if (y >= 535) {
				System.out.println("Early");
				close();
			} else if (y >= 475) {
				System.out.println("Miss");
				close();
			}
			return 0;
		}
	}
}
