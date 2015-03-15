/**
 * Fabio Cogliati
 * Progetto di Fundamentals of software engineering
 */

package view;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import model.Constants;
import model.Model;
import controller.Controller;

public class ChessBoardPanel extends JPanel implements View{
	
	/**
	 * Name of the white player that appears on the GUI
	 */
	private final static String whiteString = "White";
	
	/**
	 * Name of the black player that appears on the GUI
	 */
	private final static String blackString = "Black";
	
	/**
	 * Numbers of rows of the grid
	 */
	private final static int TilesSizeX = Constants.tileSizeX;
	
	/**
	 * numbers of columns of the grid
	 */
	private final static int TilesSizeY = Constants.tileSizeY;
	
	/**
	 * The frame where this panel will be putted
	 */
	private final JFrame frame;
	
	/**
	 * The model of the chess game
	 */
	private final Model model;
	
	/**
	 * The controller of the chess game
	 */
	private Controller controller;
	
	/**
	 * A matrix of tiles that are the tiles of the chessboard printed on screen
	 */
	private ChessBoardTile[][] tiles = new ChessBoardTile[TilesSizeX][TilesSizeY];
	
	
	
	/**
	 * Constructor of ChessBoardPanel class
	 */
 	public ChessBoardPanel(Model model, JFrame frame){
 		super();
 		this.model = model;
		this.frame = frame;
		createTiles();
		model.setView(this);
	}
	
 	/**
 	 * Gets the model
 	 */
	@Override
	public Model getModel() {
		return model;
	}

	/**
	 * Sets a new controller for this view
	 */
	@Override
	public void setController(Controller controller) {
		this.controller = controller;
	}

	/**
	 * Show the checkmate dialog. The variable color is the color of the player that make chessmates
	 */
	@Override
	public void showCheckmateDialog(boolean color) {
				
		int result = JOptionPane.showConfirmDialog(this, getColorString(color) + " wins. Restart?", "Restart?", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
		if(result == 0){
			controller.restartGame();
		}
		else{
			frame.dispose();
		}
	}
	
	/**
	 * Show the check dialog. The variable color is the color of the player that make chess
	 */
	@Override
	public void showCheckDialog(boolean color){
		JOptionPane.showMessageDialog(this, getColorString(color) + " says:\"Check!\"");
	}
	
	/**
	 * Shows the tie dialog
	 */
	public void ShowDrawDialog(){
		int result = JOptionPane.showConfirmDialog(this, "Draw, Restart?", "Restart?", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
		
		if(result == 0){
			controller.restartGame();
		}
		else{
			frame.dispose();
		}
	}

	/**
	 * Invoked by controller when the configuration of the model change
	 */
	@Override
	public void onConfigurationChange() {
		for(int y = 0; y<TilesSizeY; y++){
			for(int x = 0; x<TilesSizeX; x++){
				tiles[x][y].setPiece(model.at(x, y));
			}
		}
	}
	
	/**
	 * Select a tile of the chessboard with a special background color defined in ChessboardTile
	 */
	public void selectTileSpecialColor(int x, int y){
		tiles[x][y].selectPiece();
	}
	
	/**
	 * Select a tile of the chessboard with a background color defined in ChessboardTile
	 */
	public void selectTile(int x, int y){
		tiles[x][y].selectTile();
	}
	
	/**
	 * Deselects a tile restoring its normal background color
	 */
	public void deselectTile(int x, int y){
		tiles[x][y].deselectTile();
	}
	
	/**
	 * Deselects all tiles restoring their normal background color
	 */
	public void deselectAllTiles(){
		for(int y = 0; y<TilesSizeY; y++){
			for(int x = 0; x<TilesSizeX; x++){
				deselectTile(x,y);
			}
		}
	}
	
	//-------------------------------Private methods-------------------------------------------

	
	
	/**
	 * Creation of the grid of tiles
	 */
	private void createTiles(){
		
		setLayout(new GridLayout(TilesSizeX,TilesSizeY));
		
		boolean tileColor = Constants.whiteColor;
		
		for(int x = 0; x<TilesSizeX; x++){
			for(int y = 0; y<TilesSizeY; y++){
				
				tiles[x][y] = new ChessBoardTile(x, y, tileColor, makeButton(x,y),model.at(x,y));
				add(tiles[x][y]);
				
				tileColor = ! tileColor;
			
			}
			
			tileColor = ! tileColor;
		}
		
	}
	
	/**
	 * Get the name of the player of the color passed at the function
	 */
	private String getColorString(boolean color){
		if(color == Constants.whiteColor) return whiteString;
		else return blackString;
	}
	
	/**
	 * Creation of a button and set its listener on the event controller.onClick
	 */
	private JButton makeButton(int x, int y){
		JButton button = new JButton();
		button.addActionListener(event -> {
			if(controller != null){
				controller.onClick(x, y);
			}
		});
		
		return button;
	}
	
}
