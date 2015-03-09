/**
 * Fabio Cogliati
 * Progetto di Fundamentals of software engineering
 */

package model;

import model.ChessPieces.*;

public class ChessBoardConfiguration implements Configuration{
	
	private ChessPiece tiles[][];
	
	public ChessBoardConfiguration(){
		tiles = new ChessPiece [Constants.tileSizeX][Constants.tileSizeY];
		setInitialConfiguration();
	}
	
	public ChessBoardConfiguration(ChessBoardConfiguration other){
		for(int x = 0; x < Constants.tileSizeX; x++){
			for(int y = 0; y < Constants.tileSizeX; y++){
				tiles[x][y] = other.tiles[x][y];
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
	
	//migliorare il metodo per renderlo più generico se possibile
	private void setInitialConfiguration(){
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
	

}
