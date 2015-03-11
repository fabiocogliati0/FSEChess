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
import model.ChessBoardConfiguration;
import model.Model;

public class ChessBoardFrame extends JFrame{
	
	private final Model chessBoard;
	private final Controller controller;
	
	public ChessBoardFrame(){
		
		setTitle("Chess");
		setResizable(false);
		
		ChessBoardConfiguration conf = new ChessBoardConfiguration();
		
		chessBoard = new ChessBoardModel(conf);
		
		View view = addTiles();
		controller = new ChessBoardController(view, chessBoard);
		
		setIconImage(new ImageIcon("img/chess-icon.png").getImage());
		
		pack();
		
	}
	
	private View addTiles(){
		ChessBoardPanel panel = new ChessBoardPanel(chessBoard, this);
		add(panel, BorderLayout.CENTER);
		return panel;
	}
}
