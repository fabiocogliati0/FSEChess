/**
 * Fabio Cogliati
 * Progetto di Fundamentals of software engineering
 */

package model;

import model.ChessPieces.*;

public class ChessBoardConfiguration implements Configuration{
	
	private ChessPiece tiles[][] = new ChessPiece [Constants.tileSizeX][Constants.tileSizeY];
	
	//-------------------------------Public methods-------------------------------------------
	
	public ChessBoardConfiguration(){
		setInitialConfiguration();
	}
	
	public ChessBoardConfiguration(ChessBoardConfiguration other){
		for(int x = 0; x < Constants.tileSizeX; x++){
			for(int y = 0; y < Constants.tileSizeX; y++){
				if(other.tiles[x][y] != null){
					tiles[x][y] = other.tiles[x][y];
				}
			}
		}
	}
	
	@Override
	public ChessPiece at(int x, int y) {
		return tiles[x][y];
	}

	@Override
	public ChessBoardConfiguration swap(int fromX, int fromY, int intoX, int intoY) {
		ChessBoardConfiguration nextConfiguration = new ChessBoardConfiguration(this);
		nextConfiguration.tiles[intoX][intoY] = nextConfiguration.tiles[fromX][fromY];
		nextConfiguration.tiles[fromX][fromY] = null;
		return nextConfiguration;
	}
	
	@Override
	public boolean isLegalMove(int fromX, int fromY, int toX, int toY){
		return isLegalMoveForTheMovement(fromX,fromY, toX, toY) &&
				!isNextConfigurationAChess(fromX,fromY, toX, toY);
	}
	
	private boolean isLegalMoveForTheMovement(int fromX, int fromY, int toX, int toY){
		return (tiles[fromX][fromY].legalMove(fromX, fromY, toX, toY, this) &&					//se il pezzo può eseguire quella mossa "a scacchiera vuota"
				!sameColorOnTheArrival(toX, toY, tiles[fromX][fromY].getColor()) &&				//se nella casella di arrivo non c'è un pezzo dello stesso colore
				(tiles[fromX][fromY].canFly() || !someoneOnThePath(fromX, fromY, toX, toY)));
	}
	
	private boolean isNextConfigurationAChess(int fromX, int fromY, int toX, int toY){
		//Genero la nuova configurazione per controllare che non ci sia scacco per chi ha mosso
		Configuration moveConfig = this.swap(fromX, fromY, toX, toY);
		if(moveConfig.isChessConfiguration(tiles[fromX][fromY].getColor())){
			return true;
		}
		else{
			return false;
		}
	}

	@Override
	public boolean isChessMateConfiguration(boolean color) {

		boolean thereIsAvalidMove = false;
		
		for(int i=0; i<Constants.tileSizeX && !thereIsAvalidMove; i++){
			for(int j=0; j<Constants.tileSizeY && !thereIsAvalidMove; j++){
				if(tiles[i][j]!= null && tiles[i][j].isOfColor(color)){
					for(int x=0; x<Constants.tileSizeX && !thereIsAvalidMove; x++){
						for(int y=0; y<Constants.tileSizeY && !thereIsAvalidMove; y++){
							if(isLegalMove(i, j, x, y)){
								thereIsAvalidMove = true;
							}
						}
					}
				}
			}
		}
		
		return !thereIsAvalidMove;
	}
	
	//potrebbe non trovare il re - gestire con una eccezione
	public boolean isChessConfiguration(boolean color){
		
		int kingPosX = 0;
		int kingPosY = 0;
		
		boolean chess = false;
		
		for(int i=0; i<Constants.tileSizeX; i++){
			for(int j=0; j<Constants.tileSizeY; j++){
				if(tiles[i][j] != null && tiles[i][j] instanceof King && tiles[i][j].isOfColor(color)){
					kingPosX = i;
					kingPosY = j;
				}
			}
		}
		
		//se tutti i pezzi dell'altro colore non hanno come mossa legale la pos del re allora non è scacco
		for(int i=0; i<Constants.tileSizeX && !chess; i++){
			for(int j=0; j<Constants.tileSizeY && !chess; j++){
				if(tiles[i][j] != null && !tiles[i][j].isOfColor(color) && isLegalMoveForTheMovement(i, j, kingPosX, kingPosY)){
					chess = true;
				}
			}
		}
		
		//é SBAGLIATO! DEVE CONTROLLARE NON SOLO SE LA MOSSA è LEGAL PER IL PEZZO MA DEVE CHIAMARE QUELLO DEL CONTROLLER
		
		return chess;
	}

	@Override
	public String toString(){
		String string = "";
		for(int x = 0; x < Constants.tileSizeX; x++){
			for(int y = 0; y < Constants.tileSizeX; y++){
				if(tiles[x][y] != null){
					string += tiles[x][y] + "\t";
				}
				else{
					string += "emptyTile\t";
				}
			}
			string += "\n";
		}
		
		return string;
	}
	
	//-------------------------------Private methods-------------------------------------------
	
	//migliorare il metodo per renderlo più generico se possibile
	public void setInitialConfiguration(){
		//inserisce la fila di pedoni neri
		int pawnsPositionX = 1;
		for(int y = 0; y < Constants.tileSizeY; y++){
			tiles[pawnsPositionX][y] = new Pawn(Constants.blackColor);
		}
		
		//inserisce la fila di pedoni bianchi
		pawnsPositionX = 6;
		for(int y = 0; y < Constants.tileSizeY; y++){
			tiles[pawnsPositionX][y] = new Pawn(Constants.whiteColor);
		}
		
		tiles[0][0] = new Rook		(Constants.blackColor);
		tiles[0][1] = new Knight	(Constants.blackColor);
		tiles[0][2] = new Bishop	(Constants.blackColor);
		tiles[0][3] = new Queen		(Constants.blackColor);
		tiles[0][4] = new King		(Constants.blackColor);
		tiles[0][5] = new Bishop	(Constants.blackColor);
		tiles[0][6] = new Knight	(Constants.blackColor);
		tiles[0][7] = new Rook		(Constants.blackColor);
		
		tiles[7][0] = new Rook		(Constants.whiteColor);
		tiles[7][1] = new Knight	(Constants.whiteColor);
		tiles[7][2] = new Bishop	(Constants.whiteColor);
		tiles[7][3] = new Queen		(Constants.whiteColor);
		tiles[7][4] = new King		(Constants.whiteColor);
		tiles[7][5] = new Bishop	(Constants.whiteColor);
		tiles[7][6] = new Knight	(Constants.whiteColor);
		tiles[7][7] = new Rook		(Constants.whiteColor);
		
	}
		
	private boolean someoneOnThePath(int fromX, int fromY, int toX, int toY){
		
		boolean someOne = false;
		
		int distX = toX - fromX;
		int distY = toY - fromY;
		
		int distXsign = distX<0 ? -1 : 1;
		int distYsign = distY<0 ? -1 : 1;
		
		distX = Math.abs(distX);
		distY = Math.abs(distY);
		
		if(distX == distY){
			for(int i = 1; i < distX; i++){
				if(tiles[fromX + (i * distXsign)][fromY + ( i * distYsign)] != null){
					someOne = true;
				}
			}
		}
		else if(distX > 0){
			for(int i = 1; i < distX; i++){
				if(tiles[fromX + (i * distXsign)] [fromY] != null){
					someOne = true;
				}
			}
		}
		else if(distY > 0){
			for(int i = 1; i < distY; i++){
				if(tiles[fromX][fromY+ (i * distYsign)] != null){
					someOne = true;
				}
			}
		}
		
		return someOne;
	}
	
	private boolean sameColorOnTheArrival(int toX, int toY, boolean turnColor){
		if(tiles[toX][toY] != null){
			return tiles[toX][toY].isOfColor(turnColor);
		}
		else{
			return false;
		}
	}
	
	

}
