/**
 * Fabio Cogliati
 * Progetto di Fundamentals of software engineering
 */

package view;

import java.awt.BorderLayout;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

import controller.ChessBoardController;
import controller.Controller;
import model.ChessBoardModel;

public class ChessBoardFrame extends JFrame{
	private final ChessBoardModel chessBoard;
	private final Controller controller;
	
	public ChessBoardFrame(){
		
		setTitle("Chess");
		
		chessBoard = new ChessBoardModel();
		
		View view = addTiles();
		controller = new ChessBoardController(view);
		
		setIconImage(new ImageIcon("img/chess-icon.png").getImage());
		
		pack();
		
	}
	
	private View addTiles(){
		ChessBoardPanel panel = new ChessBoardPanel(chessBoard, this);
		add(panel, BorderLayout.CENTER);
		return panel;
	}
}
