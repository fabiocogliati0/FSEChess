/**
 * Fabio Cogliati
 * Progetto di Fundamentals of software engineering
 */

package controller;

import model.Configuration;
import model.Model;
import view.View;

/**
 * Controller that controls all the game and manages the interaction between view and model
 */
public class ChessBoardController implements Controller{

	/**
	 * The view
	 */
	private final View view;
	
	/**
	 * The model
	 */
	private final Model model;
	
	/**
	 * flag that is set to true if one piece is selected by user
	 */
	private boolean pieceSelected;
	
	/**
	 * if pieceSelected is true this contains the x-position of the selected piece
	 */
	private int pieceSelectedX;
	
	/**
	 * if pieceSelected is true this contains the y-position of the selected piece
	 */
	private int pieceSelectedY;

	
	
	/**
	 * Constructor, we needs view and model to create a controller
	 */
	public ChessBoardController(View view, Model model){
		this.view = view;
		this.model = model;
		view.setController(this);
	}
	
	/**
	 * Function invoked when a button on the view is clicked
	 */
	@Override
	public void onClick(int x, int y) {
		
		if(model.at(x, y) != null && model.at(x, y).isOfColor(model.getConfiguration().getTurnColor())){		//se clicco su un pezzo del colore del giocatore di turno
			if(pieceSelected){																					//se avevo già un pezzo selezionato lo deseleziono
				deselectPiece();
				if(x != pieceSelectedX || y != pieceSelectedY) {												//se il pezzo cliccato è diverso da quello precedentemente selezionato seleziono questo
					selectPiece(x,y);
				}
			}
			else{																				//se non avevo un pezzo già selezionato seleziono quello cliccato
				selectPiece(x,y);
			}
		}
		else if(pieceSelected){																	//se clicco su una casella vuota o su un pezzo dell'altro colore e ho un pezzo selezionato
			if(model.getConfiguration().isLegalMove(pieceSelectedX, pieceSelectedY, x, y)){		//se la mossa del pezzo selezionato verso la casella selezionata è legale nella configurazione corrente
				deselectPiece();																//deseleziono il pezzo
				move(pieceSelectedX, pieceSelectedY, x, y);										//eseguo la mossa
				checkChess();																	//controllo se è finita la partita
			}
		}
		
	}

	/**
	 * Restart the current game resetting the model to the initial standard configuration
	 */
	public void restartGame(){
		deselectPiece();
		model.setStartConfiguration();
	}
	
	
	
	/**
	 * Check if there is a chess, if there is a checkMate for the player that have made the last move.
	 * This method will check even if there is a draw position
	 * After all checks this method will call the view for displaying the right alert message
	 */
	private void checkChess() {
		
		boolean chess = false;
		boolean noMoves = false;
		
		Configuration currentConf = model.getConfiguration();
		
		if(currentConf.isChessConfiguration(currentConf.getTurnColor()))
			chess = true;
		
		if(currentConf.noLegalmoves(currentConf.getTurnColor())) 
			noMoves = true;
		
		//chess
		if(chess && !noMoves){
			view.showCheckDialog(currentConf.getTurnColor());
		}
		//chessMate
		else if(chess && noMoves){
			view.showCheckmateDialog(currentConf.getTurnColor());
		}
		//patta
		else if(!chess & noMoves){
			view.ShowDrawDialog();
		}

	}
	
	/**
	 * Function called when a piece is selected. This method will save the selected piece and select all the legal
	 * movement tiles on the view
	 */
	private void selectPiece(int x, int y){
		
		//memorizza la posizione del pezzo selezionato
		pieceSelectedX = x;
		pieceSelectedY = y;
		pieceSelected = true;
		
		//evidenzia il pezzo sulla view
		view.selectTileSpecialColor(x, y);
		
		//evidenzia tutte le caselle dove il pezzo può muoversi sulla view
		Configuration currentConf = model.getConfiguration();
		for(int i=0; i<8; i++){
			for(int j=0 ; j<8; j++){
				if(currentConf.isLegalMove(pieceSelectedX, pieceSelectedY, i, j)){
					view.selectTile(i, j);
				}
			}
		}
	}
	
	/**
	 * Function called when a piece is deselected. This method will save the selected piece and deselect all the tiles on the view
	 */
	private void deselectPiece(){
		pieceSelected = false;
		view.deselectAllTiles();
	}
	
	/**
	 * Change the model configuration doing the passed move
	 */
	private void move(int fromX, int fromY, int toX, int toY){
		//cambio configurazione
		model.setConfiguration(model.getConfiguration().swap(fromX, fromY, toX, toY));
	}
}
