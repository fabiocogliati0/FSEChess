/**
 * Fabio Cogliati
 * Progetto di Fundamentals of software engineering
 */

package view;

import java.awt.BorderLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import controller.ChessBoardController;
import model.ChessBoardModel;
import model.ChessBoardConfiguration;
import model.Model;

/**
 * Window that contains all the GUI
 */
public class ChessBoardFrame extends JFrame{
	
	/**
	 * Serial version UID
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * The model of the chess game
	 */
	private final Model chessBoard;
	
	/**
	 * Constructor that create the window
	 */
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
	
	/**
	 * Creates the panel containing the chessBoard
	 */
	private View addTilesPanel(){
		ChessBoardPanel panel = new ChessBoardPanel(chessBoard, this);
		add(panel, BorderLayout.CENTER);
		return panel;
	}
}
