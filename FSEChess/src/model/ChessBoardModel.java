/**
 * Fabio Cogliati
 * Progetto di Fundamentals of software engineering
 */

package model;

import model.ChessPieces.ChessPiece;
import view.View;

public class ChessBoardModel implements Model{

	View view;
	Configuration configuration;
	
	public ChessBoardModel(Configuration configuration){
		this.configuration = configuration;
	}
	
	@Override
	public ChessPiece at(int x, int y) {
		return configuration.at(x, y);
	}

	@Override
	public Configuration getConfiguration() {
		return configuration;
	}

	@Override
	public void setConfiguration(Configuration configuration) {
		if(this.configuration != configuration){
			this.configuration = configuration;
			if(view != null){
				view.onConfigurationChange();
			}
		}
	}

	@Override
	public void setView(View view) {
		this.view = view;
	}

}
