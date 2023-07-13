package Game;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.ArrayList;

import javax.swing.*;

public class VectroBeat extends JFrame {
	
	private Image screenImage;
	private Graphics screenGraphic;

	// 이미지 가져오기
	private JLabel menuBar = new JLabel(new ImageIcon(Main.class.getResource("../images/menuBar.jpg")));

	private ImageIcon exitButtonBasicImage = new ImageIcon(Main.class.getResource("../images/exitButtonBasic.png"));
	private ImageIcon startButtonBasicImage = new ImageIcon(Main.class.getResource("../images/startButtonBasic.png"));
	private ImageIcon quitButtonBasicImage = new ImageIcon(Main.class.getResource("../images/quitButtonBasic.png"));
	private ImageIcon backButtonImage = new ImageIcon(Main.class.getResource("../images/backButton.png"));

	private ImageIcon leftButtonBasicImage = new ImageIcon(Main.class.getResource("../images/leftButtonBasic.png"));
	private ImageIcon leftButtonEnteredImage = new ImageIcon(Main.class.getResource("../images/leftButtonEntered.png"));
	private ImageIcon rightButtonBasicImage = new ImageIcon(Main.class.getResource("../images/rightButtonBasic.png"));
	private ImageIcon rightButtonEnteredImage = new ImageIcon(Main.class.getResource("../images/rightButtonEntered.png"));

	private JButton exitButton = new JButton(exitButtonBasicImage);
	private JButton startButton = new JButton(startButtonBasicImage);
	private JButton quitButton = new JButton(quitButtonBasicImage);
	private JButton leftButton = new JButton(leftButtonBasicImage);
	private JButton rightButton = new JButton(rightButtonBasicImage);
	private JButton backButton = new JButton(backButtonImage);
	
	private ImageIcon easyButtonImage = new ImageIcon(Main.class.getResource("../images/easyButton.png"));
	private ImageIcon normalButtonImage = new ImageIcon(Main.class.getResource("../images/normalButton.png"));
	private ImageIcon hardButtonImage = new ImageIcon(Main.class.getResource("../images/hardButton.png"));
	private ImageIcon crazyButtonImage = new ImageIcon(Main.class.getResource("../images/crazyButton.png"));

	private JButton easyButton = new JButton(easyButtonImage);
	private JButton normalButton = new JButton(normalButtonImage);
	private JButton hardButton = new JButton(hardButtonImage);
	private JButton crazyButton = new JButton(crazyButtonImage);
	
	private Image background = new ImageIcon(Main.class.getResource("../images/introBackground.jpg")).getImage();
	
	private int mouseX, mouseY;
	
	private boolean isMainScreen = false;
	private boolean isGameScreen = false;
	
	public static ArrayList<Track> trackList = new ArrayList<Track>();

	private Image titleImage;
	private Image selectedImage;
	private Music selectedMusic;
	private Music introMusic = new Music("sangil_song.mp3", true);
	private int nowSelected = 0; // 현재 선택된 곡 번호
	
	public static Game game;
	
	public ArrayList<Difficulty> difficulty_Array = new ArrayList<Difficulty>();
	
	public VectroBeat() {
		
		// 트랙에 [ 타이틀 사진, 인게임 소개 사진, 하이라이트 곡, 곡 풀버전, 타이틀 이름 ] 추가
		trackList.add(new Track("sangil_title.png", 
				"sangil_start.jpg", 
				"sangil_game.jpg", 
				"sangil_song cut.mp3", 
				"sangil_song.mp3", 
				"School Song (SangilMedia ver.)"));
		// 선택 가능한 난이도
		difficulty_Array.add(new Difficulty(true, true, true, true));
		
		trackList.add(new Track("Light It Up_title.png", "Light It Up_start.jpg", "Light It Up_game.jpg", 
				"Light It Up cut.mp3", "Robin Hustin x TobiMorrow - Light It Up.mp3", "Light It Up"));
		difficulty_Array.add(new Difficulty(false, true, false, true));
		
		trackList.add(new Track("Invincible_title.png", "Invincible_start.jpg", "Invincible_game.jpg", 
				"Invincible cut.mp3", "DEAF KEV - Invincible.mp3", "Invincible"));
		difficulty_Array.add(new Difficulty(true, false, true, false));
		
		trackList.add(new Track("Heart of Witch_title.png", "heart of witch_start.jpg", "heart of witch_game.jpg", 
				"Heart of Witch cut.mp3", "ReX - Heart of Witch.mp3", "Heart of Witch"));
		difficulty_Array.add(new Difficulty(true, false, true, true));
		
		trackList.add(new Track("Toxic vibration_title.png", "Toxic vibration_start.png", "Toxic vibration_game.jpg", 
				"Toxic vibration cut.mp3", "BEMANI - TOXIC VIBRATION.mp3", "Toxic Vibration"));
		difficulty_Array.add(new Difficulty(false, false, false, true));
		
		
		setUndecorated(true); // 메뉴바가 안보이게 됨
		setTitle("VectroBeat");
		setSize(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
		setResizable(false);
		setLocationRelativeTo(null); // 창을 화면의 가운데에 띄움
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 윈도우창 종료시 프로세스까지 닫을 수 있음
		setVisible(true);
		setBackground(new Color(0, 0, 0, 0));
		setLayout(null);
		
		addKeyListener(new KeyListener());
		
		introMusic.start();

		// exitButton
		exitButton.setBounds(1245, 0, 30, 30); // 좌표
		exitButton.setBorderPainted(false); // 외곽선 제거
		exitButton.setContentAreaFilled(false); // 내용 제거
		exitButton.setFocusPainted(false); // 외곽선 제거
		exitButton.addMouseListener(new MouseAdapter() { // 클릭이벤트
			public void mouseEntered(MouseEvent e) {
				// 커서 변경
				exitButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
			public void mouseExited(MouseEvent e) {
				// 커서 변경
				exitButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			public void mousePressed(MouseEvent e) {
				try {
					// 1초 쉬었다가
					Thread.sleep(1000);
				} catch (InterruptedException ex) {
					ex.printStackTrace();
				}
				// 프로그램 종료
				System.exit(0);
			}
		});
		add(exitButton);
		
		// leftButton
		leftButton.setVisible(false);
		leftButton.setBounds(140, 310, 60, 60);
		leftButton.setBorderPainted(false);
		leftButton.setContentAreaFilled(false);
		leftButton.setFocusPainted(false);
		leftButton.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				leftButton.setIcon(leftButtonEnteredImage);
				leftButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
			public void mouseExited(MouseEvent e) {
				leftButton.setIcon(leftButtonBasicImage);
				leftButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			public void mousePressed(MouseEvent e) {
				selectLeft();
			}
		});
		add(leftButton);
		
		// rightButton
		rightButton.setVisible(false);
		rightButton.setBounds(1080, 310, 60, 60);
		rightButton.setBorderPainted(false);
		rightButton.setContentAreaFilled(false);
		rightButton.setFocusPainted(false);
		rightButton.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				rightButton.setIcon(rightButtonEnteredImage);
				rightButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
			public void mouseExited(MouseEvent e) {
				rightButton.setIcon(rightButtonBasicImage);
				rightButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			public void mousePressed(MouseEvent e) {
				selectRight();
			}
		});
		add(rightButton);
		
		// easyButton
		easyButton.setVisible(false);
		easyButton.setBounds(375, 550, 250, 67);
		easyButton.setBorderPainted(false);
		easyButton.setContentAreaFilled(false);
		easyButton.setFocusPainted(false);
		easyButton.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				easyButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
			public void mouseExited(MouseEvent e) {
				easyButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			public void mousePressed(MouseEvent e) {
				gameStart(nowSelected, "Easy");
			}
		});
		add(easyButton);
		
		// normalButton
		normalButton.setVisible(false);
		normalButton.setBounds(655, 550, 250, 67);
		normalButton.setBorderPainted(false);
		normalButton.setContentAreaFilled(false);
		normalButton.setFocusPainted(false);
		normalButton.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				normalButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
			public void mouseExited(MouseEvent e) {
				normalButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			public void mousePressed(MouseEvent e) {
				gameStart(nowSelected, "Normal");
			}
		});
		add(normalButton);
		
		// hardButton
		hardButton.setVisible(false);
		hardButton.setBounds(375, 630, 250, 67);
		hardButton.setBorderPainted(false);
		hardButton.setContentAreaFilled(false);
		hardButton.setFocusPainted(false);
		hardButton.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				hardButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
			public void mouseExited(MouseEvent e) {
				hardButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			public void mousePressed(MouseEvent e) {
				gameStart(nowSelected, "Hard");
			}
		});
		add(hardButton);
		
		// crazyButton
		crazyButton.setVisible(false);
		crazyButton.setBounds(655, 630, 250, 67);
		crazyButton.setBorderPainted(false);
		crazyButton.setContentAreaFilled(false);
		crazyButton.setFocusPainted(false);
		crazyButton.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				crazyButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
			public void mouseExited(MouseEvent e) {
				crazyButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			public void mousePressed(MouseEvent e) {
				gameStart(nowSelected, "Crazy");
			}
		});
		add(crazyButton);
		
		menuBar.setBounds(0, 0, 1280, 30);
		menuBar.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				mouseX = e.getX();
				mouseY = e.getY();
			}
		});
		
		// backButton
		backButton.setVisible(false);
		backButton.setBounds(20, 50, 60, 60);
		backButton.setBorderPainted(false);
		backButton.setContentAreaFilled(false);
		backButton.setFocusPainted(false);
		backButton.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				backButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
			public void mouseExited(MouseEvent e) {
				backButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			public void mousePressed(MouseEvent e) {
				backMain();
			}
		});
		add(backButton);
		
		menuBar.setBounds(0, 0, 1280, 30);
		menuBar.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				mouseX = e.getX();
				mouseY = e.getY();
			}
		});
		

		// startButton
		startButton.setBounds(800, 200, 400, 100); // 좌표
		startButton.setBorderPainted(false); // 외곽선 제거
		startButton.setContentAreaFilled(false); // 빈칸 제거
		startButton.setFocusPainted(false); // 외곽선 제거
		
		// 마우스 관련 이벤트 추가
		startButton.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				// 마우스가 버튼 안에 들어오면 커서 변경
				startButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
			public void mouseExited(MouseEvent e) {
				// 마우스가 버튼을 빠져나가면 커서 변경
				startButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			public void mousePressed(MouseEvent e) {
				// 메인화면으로 이동
				enterMain();
			}
		});
		add(startButton);
		
		// quitButton
		quitButton.setBounds(800, 330, 400, 100);
		quitButton.setBorderPainted(false);
		quitButton.setContentAreaFilled(false);
		quitButton.setFocusPainted(false);
		quitButton.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				quitButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
			public void mouseExited(MouseEvent e) {
				quitButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			public void mousePressed(MouseEvent e) {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException ex) {
					ex.printStackTrace();
				}
				System.exit(0);
			}
		});
		add(quitButton);
		
		menuBar.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				int x = e.getXOnScreen();
				int y = e.getYOnScreen();
				setLocation(x - mouseX, y - mouseY);
			}
		});
		add(menuBar);
	}
	
	// 함수 오버라이딩으로 화면을 그린다.
	public void paint(Graphics g) {
		// 더블 버퍼링(깜빡임 방지)
		screenImage = createImage(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
		screenGraphic = screenImage.getGraphics();
		screenDraw((Graphics2D) screenGraphic);
		g.drawImage(screenImage, 0, 0, null);
	}

	private void screenDraw(Graphics2D g) {
		g.drawImage(background, 0, 0, null); // 자주 바뀔 수 있는 이미지를 그리기 (0,0부터)
		if (isMainScreen) {
			g.drawImage(selectedImage, 340, 70, null);
			g.drawImage(titleImage, 340, 70, null);
		}
		if (isGameScreen) {
			game.screenDraw(g);
		}
		paintComponents(g); // 항상 고정되는 이미지를 그리기
		try {
			Thread.sleep(5);
		} catch (Exception e) {
			e.printStackTrace();
		}
		this.repaint();
	}
	
	public void selectTrack(int nowSelected) {
		// 선택된 이미지가 있으면
		if (selectedImage != null) {
			// 실행중인 음악 종료
			selectedMusic.close();
		}
		
		// 이미지, 음악 불러오기
		titleImage = new ImageIcon(Main.class.getResource(
				"../images/" + trackList.get(nowSelected).getTitleImage())).getImage();
		selectedImage = new ImageIcon(Main.class.getResource(
				"../images/" + trackList.get(nowSelected).getStartImage())).getImage();
		selectedMusic = new Music(trackList.get(nowSelected).getStartMusic(), true);

		// 난이도 선택버튼 보이기 여부
		easyButton.setVisible(difficulty_Array.get(nowSelected).easy);
		normalButton.setVisible(difficulty_Array.get(nowSelected).normal);
		hardButton.setVisible(difficulty_Array.get(nowSelected).hard);
		crazyButton.setVisible(difficulty_Array.get(nowSelected).crazy);
		
		// 뮤직 스타트
		selectedMusic.start();
	}
	
	// 왼쪽 곡으로 이동
	public void selectLeft() {
		if (nowSelected == 0) {
			nowSelected = trackList.size() - 1;
		} else {
			nowSelected--;
		}
		selectTrack(nowSelected);
	}
	
	// 오른쪽 곡으로 이동
	public void selectRight() {
		if (nowSelected == trackList.size() - 1) {
			nowSelected = 0;
		} else {
			nowSelected++;
		}
		selectTrack(nowSelected);
	}
	
	public void gameStart(int nowSelected, String difficulty) {
		if (selectedMusic != null) {
			selectedMusic.close();
		}
		isMainScreen = false;

		leftButton.setVisible(false);
		rightButton.setVisible(false);
		easyButton.setVisible(false);
		normalButton.setVisible(false);
		hardButton.setVisible(false);
		crazyButton.setVisible(false);

		background = new ImageIcon(Main.class.getResource("../images/" + trackList.get(nowSelected).getGameImage())).getImage();
		backButton.setVisible(true);
		
		isGameScreen = true;
		game = new Game(trackList.get(nowSelected).getTitleName(), difficulty, trackList.get(nowSelected).getGameMusic(), nowSelected);
		game.setKeyNumber(4);
		
		game.start(); // run 함수 실행
		setFocusable(true);
	}
	
	public void backMain() {
		isMainScreen = true;
		leftButton.setVisible(true);
		rightButton.setVisible(true);
		easyButton.setVisible(true);
		normalButton.setVisible(true);
		hardButton.setVisible(true);
		crazyButton.setVisible(true);
		
		backButton.setVisible(false);
		
		background = new ImageIcon(Main.class.getResource("../images/mainBackground.jpg")).getImage();
		
		selectTrack(nowSelected);
		
		isGameScreen = false;
		
		game.close();
	}
	
	public void enterMain() {
		isMainScreen = true;

		background = new ImageIcon(Main.class.getResource("../images/mainBackground.jpg")).getImage();
		
		startButton.setVisible(false);
		quitButton.setVisible(false);
		leftButton.setVisible(true);
		rightButton.setVisible(true);
		easyButton.setVisible(true);
		normalButton.setVisible(true);
		hardButton.setVisible(true);
		crazyButton.setVisible(true);
		
		introMusic.close();
		selectTrack(0);
	}
}
