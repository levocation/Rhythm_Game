package Game;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.util.ArrayList;

import javax.swing.ImageIcon;

public class Game extends Thread {

	private Image gameInfoImage = new ImageIcon(Main.class.getResource("../images/gameInfo.png")).getImage();
	private Image judgementLineImage = new ImageIcon(Main.class.getResource("../images/judgementLine.png")).getImage();

	private Image noteRouteImage_4B = new ImageIcon(Main.class.getResource("../images/noteRoute_4B.png")).getImage();
	private Image noteRouteImage_5B = new ImageIcon(Main.class.getResource("../images/noteRoute_5B.png")).getImage();
	private Image noteRouteImage_6B = new ImageIcon(Main.class.getResource("../images/noteRoute_6B.png")).getImage();
	private Image noteRouteImage_7B = new ImageIcon(Main.class.getResource("../images/noteRoute_7B.png")).getImage();

	private Image noteRouteLineImage = new ImageIcon(Main.class.getResource("../images/noteRouteLine.png")).getImage();
	
	private Image blueFlareImage = new ImageIcon(Main.class.getResource("../images/blueFlare.png")).getImage();
	private Image judgeImage;
	
	private Image noteRoutePressedImage_4B = new ImageIcon(Main.class.getResource("../images/noteRoutePressed_4B.png"))
			.getImage();
	private Image noteRoutePressedImage_5B = new ImageIcon(Main.class.getResource("../images/noteRoutePressed_5B.png"))
			.getImage();
	private Image noteRoutePressedImage_6B = new ImageIcon(Main.class.getResource("../images/noteRoutePressed_6B.png"))
			.getImage();
	private Image noteRoutePressedImage_7B = new ImageIcon(Main.class.getResource("../images/noteRoutePressed_7B.png"))
			.getImage();

	private Image noteRouteZImage = noteRouteImage_4B;
	private Image noteRouteXImage = noteRouteImage_4B;
	private Image noteRouteCImage = noteRouteImage_4B;
	private Image noteRouteSpaceImage = noteRouteImage_4B;
	private Image noteRouteCommaImage = noteRouteImage_4B;
	private Image noteRoutePeriodImage = noteRouteImage_4B;
	private Image noteRouteSlashImage = noteRouteImage_4B;

	private int keyNumber = 4; // 몇키인지 확인

	private String titleName;
	private String difficulty;
	private String musicTitle;
	private Music gameMusic;

	ArrayList<Note> noteList = new ArrayList<Note>();

	public Game(String titleName, String difficulty, String musicTitle) {
		this.titleName = titleName;
		this.difficulty = difficulty;
		this.musicTitle = musicTitle;
		gameMusic = new Music(this.musicTitle, false);

	}

	public void screenDraw(Graphics2D g) {
		switch (keyNumber) {
		case 4:

			g.drawImage(noteRouteXImage, 250, 30, null); // 1
			g.drawImage(noteRouteCImage, 454, 30, null); // 2
			g.drawImage(noteRouteCommaImage, 658, 30, null); // 3
			g.drawImage(noteRoutePeriodImage, 862, 30, null); // 4

			g.drawImage(noteRouteLineImage, 246, 30, null);
			g.drawImage(noteRouteLineImage, 450, 30, null);
			g.drawImage(noteRouteLineImage, 654, 30, null);
			g.drawImage(noteRouteLineImage, 858, 30, null);
			g.drawImage(noteRouteLineImage, 1062, 30, null);

			break;

		case 5:
			g.drawImage(noteRouteXImage, 250, 30, null); // 1
			g.drawImage(noteRouteCImage, 411, 30, null); // 2
			g.drawImage(noteRouteSpaceImage, 572, 30, null); // 3
			g.drawImage(noteRouteCommaImage, 733, 30, null); // 4
			g.drawImage(noteRoutePeriodImage, 894, 30, null); // 5

			g.drawImage(noteRouteLineImage, 246, 30, null);
			g.drawImage(noteRouteLineImage, 407, 30, null);
			g.drawImage(noteRouteLineImage, 568, 30, null);
			g.drawImage(noteRouteLineImage, 729, 30, null);
			g.drawImage(noteRouteLineImage, 890, 30, null);
			g.drawImage(noteRouteLineImage, 1051, 30, null);

			break;

		case 6:

			g.drawImage(noteRouteZImage, 250, 30, null); // 1
			g.drawImage(noteRouteXImage, 384, 30, null); // 2
			g.drawImage(noteRouteCImage, 518, 30, null); // 3
			g.drawImage(noteRouteCommaImage, 652, 30, null); // 4
			g.drawImage(noteRoutePeriodImage, 786, 30, null); // 5
			g.drawImage(noteRouteSlashImage, 920, 30, null); // 6

			g.drawImage(noteRouteLineImage, 246, 30, null);
			g.drawImage(noteRouteLineImage, 380, 30, null);
			g.drawImage(noteRouteLineImage, 514, 30, null);
			g.drawImage(noteRouteLineImage, 648, 30, null);
			g.drawImage(noteRouteLineImage, 782, 30, null);
			g.drawImage(noteRouteLineImage, 916, 30, null);
			g.drawImage(noteRouteLineImage, 1050, 30, null);

			break;

		case 7:

			g.drawImage(noteRouteZImage, 250, 30, null); // 1
			g.drawImage(noteRouteXImage, 365, 30, null); // 2
			g.drawImage(noteRouteCImage, 480, 30, null); // 3
			g.drawImage(noteRouteSpaceImage, 595, 30, null); // 4
			g.drawImage(noteRouteCommaImage, 710, 30, null); // 5
			g.drawImage(noteRoutePeriodImage, 825, 30, null); // 6
			g.drawImage(noteRouteSlashImage, 940, 30, null); // 7

			g.drawImage(noteRouteLineImage, 246, 30, null);
			g.drawImage(noteRouteLineImage, 361, 30, null);
			g.drawImage(noteRouteLineImage, 476, 30, null);
			g.drawImage(noteRouteLineImage, 591, 30, null);
			g.drawImage(noteRouteLineImage, 706, 30, null);
			g.drawImage(noteRouteLineImage, 821, 30, null);
			g.drawImage(noteRouteLineImage, 936, 30, null);
			g.drawImage(noteRouteLineImage, 1051, 30, null);

			break;
		default:
			break;
		}

		g.drawImage(gameInfoImage, 0, 660, null);
		g.drawImage(judgementLineImage, 0, 580, null);

		for (int i = 0; i < noteList.size(); i++) {
			Note note = noteList.get(i);
			if (note.getY() > 620) {
				judgeImage = new ImageIcon(Main.class.getResource("../images/Miss.png")).getImage();
			}
			if (!note.proceeded) {
				noteList.remove(i);
				i--;
			} else {
				note.screenDraw(g);
			}
			
		}

		g.setColor(Color.WHITE);
		g.setFont(new Font("Arial", Font.BOLD, 30));
		g.drawString(titleName, 15, 702);
		g.drawString(difficulty, 1100, 702);
		g.setFont(new Font("Elephant", Font.BOLD, 30));
		g.drawString("000000", 565, 702);
		g.drawImage(judgeImage, 460, 420, null);

		g.setColor(Color.DARK_GRAY);
		g.setFont(new Font("Arial", Font.PLAIN, 30));
		g.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);

		switch (keyNumber) {
		case 4:
			g.drawString("X", 350, 609);
			g.drawString("C", 554, 609);
			g.drawString(",", 758, 609);
			g.drawString(".", 962, 609);
			break;

		case 5:
			g.drawString("X", 250 + 70, 609);
			g.drawString("C", 411 + 70, 609);
			g.drawString("SPACE", 572 + 30, 609);
			g.drawString(",", 733 + 75, 609);
			g.drawString(".", 894 + 75, 609);
			break;

		case 6:
			g.drawString("Z", 250 + 55, 609);
			g.drawString("X", 384 + 55, 609);
			g.drawString("C", 518 + 55, 609);
			g.drawString(",", 652 + 55, 609);
			g.drawString(".", 786 + 55, 609);
			g.drawString("/", 920 + 55, 609);
			break;

		case 7:
			g.drawString("Z", 250 + 50, 609);
			g.drawString("X", 365 + 50, 609);
			g.drawString("C", 480 + 50, 609);
			g.drawString("SPACE", 595 + 5, 609);
			g.drawString(",", 710 + 50, 609);
			g.drawString(".", 825 + 50, 609);
			g.drawString("/", 940 + 50, 609);
			break;

		default:
			break;
		}

	}

	public void setKeyNumber(int keyNumber) {
		this.keyNumber = keyNumber;

		switch (keyNumber) {
		case 4:
			noteRouteZImage = noteRouteImage_4B;
			noteRouteXImage = noteRouteImage_4B;
			noteRouteCImage = noteRouteImage_4B;
			noteRouteSpaceImage = noteRouteImage_4B;
			noteRouteCommaImage = noteRouteImage_4B;
			noteRoutePeriodImage = noteRouteImage_4B;
			noteRouteSlashImage = noteRouteImage_4B;
			break;
		case 5:
			noteRouteZImage = noteRouteImage_5B;
			noteRouteXImage = noteRouteImage_5B;
			noteRouteCImage = noteRouteImage_5B;
			noteRouteSpaceImage = noteRouteImage_5B;
			noteRouteCommaImage = noteRouteImage_5B;
			noteRoutePeriodImage = noteRouteImage_5B;
			noteRouteSlashImage = noteRouteImage_5B;
			break;
		case 6:
			noteRouteZImage = noteRouteImage_6B;
			noteRouteXImage = noteRouteImage_6B;
			noteRouteCImage = noteRouteImage_6B;
			noteRouteSpaceImage = noteRouteImage_6B;
			noteRouteCommaImage = noteRouteImage_6B;
			noteRoutePeriodImage = noteRouteImage_6B;
			noteRouteSlashImage = noteRouteImage_6B;
			break;
		case 7:
			noteRouteZImage = noteRouteImage_7B;
			noteRouteXImage = noteRouteImage_7B;
			noteRouteCImage = noteRouteImage_7B;
			noteRouteSpaceImage = noteRouteImage_7B;
			noteRouteCommaImage = noteRouteImage_7B;
			noteRoutePeriodImage = noteRouteImage_7B;
			noteRouteSlashImage = noteRouteImage_7B;
			break;

		default:
			break;
		}
	}

	public void pressZ() {
		judge("Z");
		switch (keyNumber) {
		case 4:
			noteRouteZImage = noteRoutePressedImage_4B;
			break;
		case 5:
			noteRouteZImage = noteRoutePressedImage_5B;
			break;
		case 6:
			noteRouteZImage = noteRoutePressedImage_6B;
			break;
		case 7:
			noteRouteZImage = noteRoutePressedImage_7B;
			break;

		default:
			break;
		}
	}

	public void releaseZ() {
		switch (keyNumber) {
		case 4:
			noteRouteZImage = noteRouteImage_4B;
			break;
		case 5:
			noteRouteZImage = noteRouteImage_5B;
			break;
		case 6:
			noteRouteZImage = noteRouteImage_6B;
			break;
		case 7:
			noteRouteZImage = noteRouteImage_7B;
			break;

		default:
			break;
		}
	}

	public void pressX() {
		judge("X");
		switch (keyNumber) {
		case 4:
			noteRouteXImage = noteRoutePressedImage_4B;
			break;
		case 5:
			noteRouteXImage = noteRoutePressedImage_5B;
			break;
		case 6:
			noteRouteXImage = noteRoutePressedImage_6B;
			break;
		case 7:
			noteRouteXImage = noteRoutePressedImage_7B;
			break;

		default:
			break;
		}
	}

	public void releaseX() {
		switch (keyNumber) {
		case 4:
			noteRouteXImage = noteRouteImage_4B;
			break;
		case 5:
			noteRouteXImage = noteRouteImage_5B;
			break;
		case 6:
			noteRouteXImage = noteRouteImage_6B;
			break;
		case 7:
			noteRouteXImage = noteRouteImage_7B;
			break;

		default:
			break;
		}
	}

	public void pressC() {
		judge("C");
		switch (keyNumber) {
		case 4:
			noteRouteCImage = noteRoutePressedImage_4B;
			break;
		case 5:
			noteRouteCImage = noteRoutePressedImage_5B;
			break;
		case 6:
			noteRouteCImage = noteRoutePressedImage_6B;
			break;
		case 7:
			noteRouteCImage = noteRoutePressedImage_7B;
			break;

		default:
			break;
		}
	}

	public void releaseC() {
		switch (keyNumber) {
		case 4:
			noteRouteCImage = noteRouteImage_4B;
			break;
		case 5:
			noteRouteCImage = noteRouteImage_5B;
			break;
		case 6:
			noteRouteCImage = noteRouteImage_6B;
			break;
		case 7:
			noteRouteCImage = noteRouteImage_7B;
			break;

		default:
			break;
		}
	}

	public void pressSpace() {
		judge("SPACE");
		switch (keyNumber) {
		case 4:
			noteRouteSpaceImage = noteRoutePressedImage_4B;
			break;
		case 5:
			noteRouteSpaceImage = noteRoutePressedImage_5B;
			break;
		case 6:
			noteRouteSpaceImage = noteRoutePressedImage_6B;
			break;
		case 7:
			noteRouteSpaceImage = noteRoutePressedImage_7B;
			break;

		default:
			break;
		}
	}

	public void releaseSpace() {
		switch (keyNumber) {
		case 4:
			noteRouteSpaceImage = noteRouteImage_4B;
			break;
		case 5:
			noteRouteSpaceImage = noteRouteImage_5B;
			break;
		case 6:
			noteRouteSpaceImage = noteRouteImage_6B;
			break;
		case 7:
			noteRouteSpaceImage = noteRouteImage_7B;
			break;

		default:
			break;
		}
	}

	public void pressComma() {
		judge(",");
		switch (keyNumber) {
		case 4:
			noteRouteCommaImage = noteRoutePressedImage_4B;
			break;
		case 5:
			noteRouteCommaImage = noteRoutePressedImage_5B;
			break;
		case 6:
			noteRouteCommaImage = noteRoutePressedImage_6B;
			break;
		case 7:
			noteRouteCommaImage = noteRoutePressedImage_7B;
			break;

		default:
			break;
		}
	}

	public void releaseComma() {
		switch (keyNumber) {
		case 4:
			noteRouteCommaImage = noteRouteImage_4B;
			break;
		case 5:
			noteRouteCommaImage = noteRouteImage_5B;
			break;
		case 6:
			noteRouteCommaImage = noteRouteImage_6B;
			break;
		case 7:
			noteRouteCommaImage = noteRouteImage_7B;
			break;

		default:
			break;
		}
	}

	public void pressPeriod() {
		judge(".");
		switch (keyNumber) {
		case 4:
			noteRoutePeriodImage = noteRoutePressedImage_4B;
			break;
		case 5:
			noteRoutePeriodImage = noteRoutePressedImage_5B;
			break;
		case 6:
			noteRoutePeriodImage = noteRoutePressedImage_6B;
			break;
		case 7:
			noteRoutePeriodImage = noteRoutePressedImage_7B;
			break;

		default:
			break;
		}
	}

	public void releasePeriod() {
		switch (keyNumber) {
		case 4:
			noteRoutePeriodImage = noteRouteImage_4B;
			break;
		case 5:
			noteRoutePeriodImage = noteRouteImage_5B;
			break;
		case 6:
			noteRoutePeriodImage = noteRouteImage_6B;
			break;
		case 7:
			noteRoutePeriodImage = noteRouteImage_7B;
			break;

		default:
			break;
		}
	}

	public void pressSlash() {
		judge("/");
		switch (keyNumber) {
		case 4:
			noteRouteSlashImage = noteRoutePressedImage_4B;
			break;
		case 5:
			noteRouteSlashImage = noteRoutePressedImage_5B;
			break;
		case 6:
			noteRouteSlashImage = noteRoutePressedImage_6B;
			break;
		case 7:
			noteRouteSlashImage = noteRoutePressedImage_7B;
			break;

		default:
			break;
		}
	}

	public void releaseSlash() {
		switch (keyNumber) {
		case 4:
			noteRouteSlashImage = noteRouteImage_4B;
			break;
		case 5:
			noteRouteSlashImage = noteRouteImage_5B;
			break;
		case 6:
			noteRouteSlashImage = noteRouteImage_6B;
			break;
		case 7:
			noteRouteSlashImage = noteRouteImage_7B;
			break;

		default:
			break;
		}
	}

	@Override
	public void run() {
		dropNotes(titleName);
	}

	public void close() {
		gameMusic.close();
		this.interrupt();
	}

	public void dropNotes(String titleName) {

		Beat[] beats = null;

		if (titleName.equals("School Song (SangilMedia ver.)")) {

			int startTime = 1000 - (Main.REACH_TIME * 1000);

			if (difficulty.equals("Easy")) {
				int gap = 125;
				beats = new Beat[] { new Beat(startTime, "C", 4) };
			} else if (difficulty.equals("Normal")) {
				int gap = 125;
				beats = new Beat[] { new Beat(startTime, "C", 4) };
			} else if (difficulty.equals("Hard")) {
				int gap = 125;
				beats = new Beat[] { new Beat(startTime, "C", 4) };
			} else if (difficulty.equals("Crazy")) {
				int gap = 125;
				beats = new Beat[] { new Beat(startTime, "C", 4) };
			}
		} else if (titleName.equals("Light It Up")) {

			int startTime = 7250 - (Main.REACH_TIME * 1000);

			if (difficulty.equals("Easy")) {
				int gap = 125;
				beats = new Beat[] { new Beat(startTime, "C", 4) };
			} else if (difficulty.equals("Normal")) {
				int gap = 125;
				beats = new Beat[] { new Beat(startTime, "C", 4) };
			} else if (difficulty.equals("Hard")) {
				int gap = 125;
				beats = new Beat[] { new Beat(startTime, "C", 4) };
			} else if (difficulty.equals("Crazy")) {
				int gap = 125;
				beats = new Beat[] { new Beat(startTime, "C", 4) };
			}
		} else if (titleName.equals("Invincible")) {
			
			int startTime = 1000 - (Main.REACH_TIME * 1000);

			if (difficulty.equals("Easy")) {
				int gap = 125;
				beats = new Beat[] { new Beat(startTime, "C", 4) };
			} else if (difficulty.equals("Normal")) {
				int gap = 125;
				beats = new Beat[] { new Beat(startTime, "C", 4) };
			} else if (difficulty.equals("Hard")) {
				int gap = 125;
				beats = new Beat[] { new Beat(startTime, "C", 4) };
			} else if (difficulty.equals("Crazy")) {
				int gap = 125;
				beats = new Beat[] { new Beat(startTime, "C", 4) };
			}
		} else if (titleName.equals("ouroboros -twin stroke of the end-")) {
			
			int startTime = 1000 - (Main.REACH_TIME * 1000);
			
			if (difficulty.equals("Easy")) {
				int gap = 125;
				beats = new Beat[] { new Beat(startTime, "C", 4) };
			} else if (difficulty.equals("Normal")) {
				int gap = 125;
				beats = new Beat[] { new Beat(startTime, "C", 4) };
			} else if (difficulty.equals("Hard")) {
				int gap = 125;
				beats = new Beat[] { new Beat(startTime, "C", 4) };
			} else if (difficulty.equals("Crazy")) {
				int gap = 125;
				beats = new Beat[] { new Beat(startTime, "C", 4) };
			}
			
		} else if (titleName.equals("Toxic Vibration")) {
			
			int startTime = 3500 - (Main.REACH_TIME * 1000);
			int gap = 76;
			
			if (difficulty.equals("Easy")) {
				beats = new Beat[] {
						new Beat(startTime + gap * 0, "X", 4),
						new Beat(startTime + gap * 16, "C", 4),
						new Beat(startTime + gap * 32, ",", 4),
						new Beat(startTime + gap * 48, ".", 4),
						new Beat(startTime + gap * 64, "X", 4),
						new Beat(startTime + gap * 72, "C", 4),
						new Beat(startTime + gap * 80, ",", 4),
						new Beat(startTime + gap * 88, ".", 4),
						new Beat(startTime + gap * 96, "X", 4),
						new Beat(startTime + gap * 104, "C", 4),
						new Beat(startTime + gap * 104, ",", 4),
						new Beat(startTime + gap * 112, "C", 4),
						new Beat(startTime + gap * 112, ".", 4),
						new Beat(startTime + gap * 116, "X", 4),
						new Beat(startTime + gap * 120, "C", 4),
						new Beat(startTime + gap * 120, ",", 4),
						new Beat(startTime + gap * 124, "Plus", 4),
						new Beat(startTime + gap * 128, "X", 5),
						new Beat(startTime + gap * 136, "C", 5),
						new Beat(startTime + gap * 144, "SPACE", 5),
						new Beat(startTime + gap * 152, ",", 5),
						new Beat(startTime + gap * 160, ".", 5),
						new Beat(startTime + gap * 168, ",", 5),
						new Beat(startTime + gap * 176, "SPACE", 5),
						new Beat(startTime + gap * 184, "C", 5)
						};
			} else if (difficulty.equals("Normal")) {
				beats = new Beat[] {
						new Beat(startTime + gap * 0, "X", 4),
						new Beat(startTime + gap * 0, "C", 4),
						new Beat(startTime + gap * 16, "C", 4),
						new Beat(startTime + gap * 16, ",", 4),
						new Beat(startTime + gap * 32, ",", 4),
						new Beat(startTime + gap * 32, ".", 4),
						new Beat(startTime + gap * 48, "X", 4),
						new Beat(startTime + gap * 48, ",", 4),
						new Beat(startTime + gap * 64, "X", 4),
						new Beat(startTime + gap * 68, "C", 4),
						new Beat(startTime + gap * 72, ",", 4),
						new Beat(startTime + gap * 76, ".", 4),
						new Beat(startTime + gap * 80, "X", 4),
						new Beat(startTime + gap * 84, "C", 4),
						new Beat(startTime + gap * 88, ",", 4),
						new Beat(startTime + gap * 92, ".", 4),
						new Beat(startTime + gap * 96, "X", 4),
						new Beat(startTime + gap * 98, "X", 4),
						new Beat(startTime + gap * 100, "C", 4),
						new Beat(startTime + gap * 102, "C", 4),
						new Beat(startTime + gap * 104, ",", 4),
						new Beat(startTime + gap * 106, ",", 4),
						new Beat(startTime + gap * 108, ".", 4),
						new Beat(startTime + gap * 110, ".", 4)
						};
			} else if (difficulty.equals("Hard")) {
				beats = new Beat[] {
						new Beat(startTime + gap * 0, "X", 4), 
						new Beat(startTime + gap * 4, "C", 4), 
						new Beat(startTime + gap * 8, ",", 4), 
						new Beat(startTime + gap * 12, ".", 4) 
						};
			} else if (difficulty.equals("Crazy")) {
				beats = new Beat[] {
						new Beat(startTime + gap * 0, "C", 4),
						new Beat(startTime + gap * 4, "C", 4),
						new Beat(startTime + gap * 8, "C", 4),
						new Beat(startTime + gap * 12, "C", 4)
						};
			}
			
		}
		int i = 0;

		gameMusic.start();
		
		new Thread( ()-> {
			while (true) {
				judge("Plus");
				judge("Minus");
				try {
					Thread.sleep(20);
				} catch (Exception e) {
					// TODO: handle exception
				}
			}
			
		} ).start();
		
		while (i < beats.length && !isInterrupted()) {
			boolean dropped = false;

			if (beats[i].getTime() <= gameMusic.getTime()) {
				Note note = new Note(beats[i].getNoteName(), beats[i].getKeyNumber());
				note.start();
				noteList.add(note);
				i++;
				dropped = true;
			}

			if (!dropped) {
				try {
					Thread.sleep(5);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		
	}
	
	public void judge(String input) {
		for (int i = 0; i < noteList.size(); i++) {
			Note note = noteList.get(i);
			if (input.equals(note.getKey())) {
				String value = note.judge();
				judgeEvent(value);
				if (value.equals("Plus")) {
					keyNumber--;
					setKeyNumber(keyNumber);
				}
				else if (value.equals("Minus")) {
					keyNumber++;
					setKeyNumber(keyNumber);
				}
				break;
			}
		}
	}
	
	public void judgeEvent(String judge) {
		if (judge.equals("Miss")) {
			judgeImage = new ImageIcon(Main.class.getResource("../images/Miss.png")).getImage();
		} else if (judge.equals("Early")) {
			judgeImage = new ImageIcon(Main.class.getResource("../images/Early.png")).getImage();
		} else if (judge.equals("Late")) {
			judgeImage = new ImageIcon(Main.class.getResource("../images/Late.png")).getImage();
		} else if (judge.equals("Good")) {
			judgeImage = new ImageIcon(Main.class.getResource("../images/Good.png")).getImage();
		} else if (judge.equals("Cool")) {
			judgeImage = new ImageIcon(Main.class.getResource("../images/Cool.png")).getImage();
		} else if (judge.equals("Perfect")) {
			judgeImage = new ImageIcon(Main.class.getResource("../images/Perfect.png")).getImage();
		}
	}
}
