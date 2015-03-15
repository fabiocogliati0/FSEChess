/**
 * Fabio Cogliati
 * Progetto di Fundamentals of software engineering
 */

package model;

import model.ChessPieces.ChessPiece;
import view.View;

/**
 * Interface of a class that represent the model of a chess game
 */
public interface Model {

	/**
	 * Returns the piece of the current configuration in the tile (x,y)
	 */
	public ChessPiece at(int x, int y);
	
	/**
	 * Returns the current configuration of the model
	 */
	public Configuration getConfiguration();
	
	/**
	 * Sets the a new configuration to the model
	 */
	public void setConfiguration(Configuration configuration);
	
	/**
	 * Sets the start standard chess game configuration to the model
	 */
	public void setStartConfiguration();
	
	/**
	 * Sets the view
	 */
	public void setView(View view);
}
