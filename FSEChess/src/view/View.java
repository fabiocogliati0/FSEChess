/**
 * Fabio Cogliati
 * Progetto di Fundamentals of software engineering
 */

package view;

import model.Model;
import controller.Controller;

public interface View {

	/**
 	 * Gets the model
 	 */
	public Model getModel();
	
	/**
	 * Sets a new controller for this view
	 */
	public void setController (Controller controller);
	
	/**
	 * Show the checkmate dialog. The variable color is the color of the player that make chessmates
	 */
	public void showCheckmateDialog(boolean color);
	
	/**
	 * Show the check dialog. The variable color is the color of the player that make chess
	 */
	public void showCheckDialog(boolean color);
	
	/**
	 * Shows the tie dialog
	 */
	public void ShowDrawDialog();
	
	/**
	 * Invoked by controller when the configuration of the model change
	 */
	public void onConfigurationChange();
	
	/**
	 * Select a tile of the chessboard with a special background color
	 */
	public void selectTileSpecialColor(int x, int y);
	
	/**
	 * Select a tile of the chessboard with a background color
	 */
	public void selectTile(int x, int y);
	
	/**
	 * Deselects a tile restoring its normal background color
	 */
	public void deselectTile(int x, int y);
	
	/**
	 * Deselects all tiles restoring their normal background color
	 */
	public void deselectAllTiles();
}
