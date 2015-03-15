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
	
	private boolean pieceSelected;		//true se un pezzo è selezionato
	private int pieceSelectedX;
	private int pieceSelectedY;
	
	private boolean turnColor;

	//ATTENZIONE: per ora questa matrice è inutilizzata, utilizzarla per non fare i controlli quando si muove
	//serve solo per ottimizzazione
	private boolean[][] pieceSelectedAllowedMoves = new boolean[8][8];		//decidere se rimuovere o implementare
	

	public ChessBoardController(View view, Model model){
		this.view = view;
		this.model = model;
		view.setController(this);
		turnColor = Constants.whiteColor;
	}
	
	@Override
	public void onClick(int x, int y) {
		
		if(model.at(x, y) != null && model.at(x, y).isOfColor(turnColor)){		//se clicco su un pezzo del colore del giocatore di turno
			if(pieceSelected){													//se avevo già un pezzo selezionato lo deseleziono
				deselectPiece();
				if(x != pieceSelectedX || y != pieceSelectedY) {				//se il pezzo cliccato è diverso da quello precedentemente selezionato seleziono questo
					selectPiece(x,y);
				}
			}
			else{																//se non avevo un pezzo già selezionato seleziono quello cliccato
				selectPiece(x,y);
			}
		}
		else if(pieceSelected){																	//se clicco su una casella vuota o su un pezzo dell'altro colore e ho un pezzo selezionato
			if(model.getConfiguration().isLegalMove(pieceSelectedX, pieceSelectedY, x, y)){		//se la mossa del pezzo selezionato verso la casella selezionata è legale nella configurazione corrente
				deselectPiece();																//deseleziono il pezzo
				move(pieceSelectedX, pieceSelectedY, x, y);										//eseguo la mossa
				
				if(!checkVictory()){
					turnColor = !turnColor;															//cambio il colore del turno
				}
			}
		}
		
	}

	public void restartGame(){
		model.setInitialConfiguration();
		deselectPiece();
		turnColor = Constants.whiteColor;
	}
	
	private boolean checkVictory() {
		
		boolean chess = false;
		boolean chessMate = false;
		
		if(model.getConfiguration().isChessConfiguration(!turnColor)) chess = true;
		if(model.getConfiguration().isChessMateConfiguration(!turnColor)) chessMate = true;
		
		//chess
		if(chess && !chessMate){
			view.showCheckDialog(turnColor);
		}
		//chessMate
		else if(chess && chessMate){
			view.showCheckmateDialog(turnColor);
		}
		//patta
		else if(!chess & chessMate){
			view.ShowDrawDialog();
		}

		return chessMate;
	}
	
	
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
					pieceSelectedAllowedMoves[i][j] = true;
					view.selectTile(i, j);
				}
				else{
					pieceSelectedAllowedMoves[i][j] = false;
				}
			}
		}
	}
	
	private void deselectPiece(){
		pieceSelected = false;
		view.deselectAllTiles();
	}
	
	private void move(int fromX, int fromY, int toX, int toY){
		//cambio configurazione
		model.setConfiguration(model.getConfiguration().swap(fromX, fromY, toX, toY));
	}
}
