package Game;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyListener extends KeyAdapter {

	@Override
	public void keyPressed(KeyEvent e) { // 키를 눌렀을 때
		if (VectroBeat.game == null) {
			return;
		}
		if (e.getKeyCode() == KeyEvent.VK_Z) {
			VectroBeat.game.pressZ();
		}
		else if (e.getKeyCode() == KeyEvent.VK_X) {
			VectroBeat.game.pressX();
		}
		else if (e.getKeyCode() == KeyEvent.VK_C) {
			VectroBeat.game.pressC();
			
		}
		else if (e.getKeyCode() == KeyEvent.VK_SPACE) {
			VectroBeat.game.pressSpace();
			
		}
		else if (e.getKeyCode() == KeyEvent.VK_COMMA) {
			VectroBeat.game.pressComma();
			
		}
		else if (e.getKeyCode() == KeyEvent.VK_PERIOD) {
			VectroBeat.game.pressPeriod();
			
		}
		else if (e.getKeyCode() == KeyEvent.VK_SLASH) {
			VectroBeat.game.pressSlash();
			
		}
	}
	
	@Override
	public void keyReleased(KeyEvent e) { // 키를 뗐을 때
		if (VectroBeat.game == null) {
			return;
		}
		if (e.getKeyCode() == KeyEvent.VK_Z) {
			VectroBeat.game.releaseZ();
		}
		else if (e.getKeyCode() == KeyEvent.VK_X) {
			VectroBeat.game.releaseX();
		}
		else if (e.getKeyCode() == KeyEvent.VK_C) {
			VectroBeat.game.releaseC();
			
		}
		else if (e.getKeyCode() == KeyEvent.VK_SPACE) {
			VectroBeat.game.releaseSpace();
			
		}
		else if (e.getKeyCode() == KeyEvent.VK_COMMA) {
			VectroBeat.game.releaseComma();
			
		}
		else if (e.getKeyCode() == KeyEvent.VK_PERIOD) {
			VectroBeat.game.releasePeriod();
			
		}
		else if (e.getKeyCode() == KeyEvent.VK_SLASH) {
			VectroBeat.game.releaseSlash();
			
		}
	}
}
