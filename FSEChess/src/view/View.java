/**
 * Fabio Cogliati
 * Progetto di Fundamentals of software engineering
 */

package view;

import model.Model;
import controller.Controller;

public interface View {

	public Model getModel();
	public void setController (Controller controller);
	
	public void showSolvedDialog();
	
	public void onConfigurationChange();
	
	public void selectPiece(int x, int y);
	public void deselectPiece(int x, int y);
}
