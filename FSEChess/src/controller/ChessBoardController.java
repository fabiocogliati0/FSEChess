/**
 * Fabio Cogliati
 * Progetto di Fundamentals of software engineering
 */

package controller;

import model.Configuration;
import model.Constants;
import model.Model;
import model.ChessPieces.ChessPiece;
import view.View;

public class ChessBoardController implements Controller{

	private final View view;
	private final Model model;
	
	private int pieceSelectedX;
	private int pieceSelectedY;
	private ChessPiece pieceSelected;
	
	private boolean turnColor;
	
	
	public ChessBoardController(View view, Model model){
		this.view = view;
		this.model = model;
		view.setController(this);
		
		turnColor = Constants.whiteColor;
	}
	
	@Override
	public void onClick(int x, int y) {
		
		// se non ho ancora selezionato un pezzo memorizzo il pezzo cliccato
		if(pieceSelected == null){
			if( model.at(x, y) != null && model.at(x,y).getColor() == turnColor) {
				selectPiece(x, y);
			}
		}
		//se ho già selezionato il pezzo controllo se si può muovere nella casella cliccata e lo muovo
		else{
			
			//se la casella selezionata è la stessa precedente deseleziono il pezzo attualmente selezionato
			if(x == pieceSelectedX && y == pieceSelectedY){
				deselectPiece(x, y);
			}
			else if(true){	//TODO: controllare se la mossa è legale
				
				deselectPiece(pieceSelectedX, pieceSelectedY);
				moveAt(x,y);
				
				//controllo lo scacco matto
				if(isSolved()){
					view.showSolvedDialog();
				}
				else{
					turnColor = !turnColor;
				}
				
			}
		}
		
		
	}
	
	private void moveAt(int x, int y) {
		model.setConfiguration(model.getConfiguration().swap(pieceSelectedX, pieceSelectedY, x, y));
	}

	private boolean isSolved() {
		return false;
	}
	
	private void selectPiece(int x, int y){
		pieceSelectedX = x;
		pieceSelectedY = y;
		pieceSelected = model.at(x, y);
		view.selectPiece(x, y);
	}
	
	private void deselectPiece(int x, int y){
		pieceSelected = null;
		view.deselectPiece(x, y);
	}

}
