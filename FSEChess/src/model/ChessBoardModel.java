/**
 * Fabio Cogliati
 * Progetto di Fundamentals of software engineering
 */

package model;

import model.ChessPieces.ChessPiece;
import view.View;

/**
 * Class that represent the model of a chess game
 */
public class ChessBoardModel implements Model{

	/**
	 * Current view linked to the model
	 */
	private View view;
	
	/**
	 * Current configuration of the model
	 */
	private Configuration configuration;
	
	
	
	/**
	 * Constructor that takes a configuration to set to the model
	 */
	public ChessBoardModel(Configuration configuration){
		this.configuration = configuration;
	}
	
	/**
	 * Returns the piece of the current configuration in the tile (x,y)
	 */
	@Override
	public ChessPiece at(int x, int y) {
		return configuration.at(x, y);
	}

	/**
	 * Returns the current configuration of the model
	 */
	@Override
	public Configuration getConfiguration() {
		return configuration;
	}
	
	/**
	 * Sets the a new configuration to the model
	 */
	@Override
	public void setConfiguration(Configuration configuration) {
		if(this.configuration != configuration){
			this.configuration = configuration;
			if(view != null){
				view.onConfigurationChange();
			}
		}
	}
	
	/**
	 * Sets the start standard chess game configuration to the model
	 */
	@Override
	public void setStartConfiguration(){
		setConfiguration(new ChessBoardConfiguration());
	}
	
	/**
	 * Sets the view
	 */
	@Override
	public void setView(View view) {
		this.view = view;
	}

}
