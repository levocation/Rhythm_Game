package Game;

import java.awt.*;

import javax.swing.*;

public class Game extends JFrame {
	
	private Image screenImage;
	private Graphics screenGraphic;

	// 이미지 가져오기
	private Image introBackground = new ImageIcon(Main.class.getResource("../images/introBackground.jpg")).getImage();
	private JLabel menuBar = new JLabel(new ImageIcon(Main.class.getResource("../images/menuBar.jpg")));
	
	public Game() {
		setUndecorated(true); // 메뉴바가 안보이게 됨
		setTitle("VectroBeat");
		setSize(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
		setResizable(false);
		setLocationRelativeTo(null); // 창을 화면의 가운데에 띄움
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 윈도우창 종료시 프로세스까지 닫을 수 있음
		setVisible(true);
		
		Music introMusic = new Music("sangil_song.mp3", true);
		introMusic.start();
	}
	
	// 함수 오버라이딩으로 화면을 그린다.
	public void paint(Graphics g) {
		// 더블 버퍼링(깜빡임 방지)
		screenImage = createImage(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
		screenGraphic = screenImage.getGraphics();
		screenDraw(screenGraphic);
		g.drawImage(screenImage, 0, 0, null);
	}

	private void screenDraw(Graphics g) {
		g.drawImage(introBackground, 0, 0, null); // 자주 바뀔 수 있는 이미지를 그리기 (0,0부터)
		paintComponents(g); // 항상 고정되는 이미지를 그리기
		this.repaint();
	}
}
