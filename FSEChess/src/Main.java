/**
 * Fabio Cogliati
 * Progetto di Fundamentals of software engineering
 */

import java.awt.EventQueue;
import javax.swing.JFrame;
import view.ChessBoardFrame;

public class Main {

	static final int screenSizeX = 800;
	static final int screenSizeY = 800;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {

			@Override
			public void run() {
				JFrame frame = new ChessBoardFrame();
				frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				frame.setSize(screenSizeX, screenSizeY);
				frame.setVisible(true);
			}
		});
	}
}