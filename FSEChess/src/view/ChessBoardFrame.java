/**
 * Fabio Cogliati
 * Progetto di Fundamentals of software engineering
 */

package view;

import java.awt.BorderLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import controller.ChessBoardController;
import controller.Controller;
import model.ChessBoardModel;
import model.ChessBoardConfiguration;
import model.Model;

public class ChessBoardFrame extends JFrame{
	
	private final Model chessBoard;
	
	public ChessBoardFrame(){
		super();
		
		setTitle("FSE Project : Chess Game - Fabio Cogliati");
		setResizable(false);
		
		//creates a chessBoard with the start chess configuration
		ChessBoardConfiguration conf = new ChessBoardConfiguration();
		chessBoard = new ChessBoardModel(conf);
		
		//creates the panel of the chessBoard
		View view = addTilesPanel();
		
		//creates the controller
		new ChessBoardController(view, chessBoard);
		
		setIconImage(new ImageIcon("img/chess-icon.png").getImage());
		
		pack();
	}
	
	private View addTilesPanel(){
		ChessBoardPanel panel = new ChessBoardPanel(chessBoard, this);
		add(panel, BorderLayout.CENTER);
		return panel;
	}
}
