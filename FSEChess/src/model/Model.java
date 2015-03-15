/**
 * Fabio Cogliati
 * Progetto di Fundamentals of software engineering
 */

package model;

import model.ChessPieces.ChessPiece;
import view.View;

public interface Model {

	public ChessPiece at(int x, int y);
	public Configuration getConfiguration();
	
	public void setConfiguration(Configuration configuration);
	public void setInitialConfiguration();
	public void setView(View view);
}
