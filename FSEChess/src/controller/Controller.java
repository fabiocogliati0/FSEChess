/**
 * Fabio Cogliati
 * Progetto di Fundamentals of software engineering
 */

package controller;

/**
 * Interface of a controller that controls all the game and manages the interaction between view and model
 */
public interface Controller {
	
	/**
	 * Function invoked when a button on the view is clicked
	 */
	public void onClick(int x, int y);
	
	/**
	 * Restart the current game resetting the model to the initial standard configuration
	 */
	public void restartGame();
}
