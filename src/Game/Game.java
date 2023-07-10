package Game;

import java.awt.*;

import javax.swing.*;

public class Game extends JFrame {
	
	private Image screenImage;
	private Graphics screenGraphic;
	
	private Image introBackground;
	
	public Game() {
		setTitle("Dynamic Beat");
		setSize(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
		setResizable(false);
		setLocationRelativeTo(null); // 창을 화면의 가운데에 띄움
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 윈도우창 종료시 프로세스까지 닫을 수 있음
		setVisible(true);
		
		introBackground = new ImageIcon(Main.class.getResource("../images/introBackground.jpg")).getImage();
	}
}
