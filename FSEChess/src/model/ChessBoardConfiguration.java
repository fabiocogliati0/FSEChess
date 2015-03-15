/**
 * Fabio Cogliati
 * Progetto di Fundamentals of software engineering
 */

package model;

import model.ChessPieces.ChessPiece;
import model.ChessPieces.ChessPiecesFactory;
import model.ChessPieces.King;
import model.ChessPieces.StandardChessPiecesFactory;

/**
 * Class that represent one chessBoard (pieces and turn) configuration
 */
public class ChessBoardConfiguration implements Configuration{
	
	/**
	 * Matrix that contains for each tile of the chessBoard the ChessPiece on it. if there is no piece on
	 * a tile, then the value will be null 
	 */
	private ChessPiece tiles[][] = new ChessPiece [Constants.tileSizeX][Constants.tileSizeY];
	
	/**
	 * Color of the player that have to move in this configuration
	 */
	private boolean turnColor;
	
	
	
	/**
	 * Constructor that creates the start configuration of the chess game
	 */
	public ChessBoardConfiguration(){
		resetConfiguration();
	}
	
	/**
	 * Copy constructor that copies another passed configurations
	 */
	public ChessBoardConfiguration(ChessBoardConfiguration other){
		for(int x = 0; x < Constants.tileSizeX; x++){
			for(int y = 0; y < Constants.tileSizeX; y++){
				if(other.tiles[x][y] != null){
					tiles[x][y] = other.tiles[x][y];
				}
			}
		}
	}
	
	/**
	 * Returns the piece at the tile in position (x,y). It returns null if there is no piece of that tile
	 */
	@Override
	public ChessPiece at(int x, int y) {
		return tiles[x][y];
	}

	/**
	 * Gets the current turn color
	 */
	@Override
	public boolean getTurnColor(){
		return turnColor;
	}
	
	/**
	 * Create a new configuration starting from this executing the passed move
	 */
	@Override
	public ChessBoardConfiguration swap(int fromX, int fromY, int intoX, int intoY) {
		ChessBoardConfiguration nextConfiguration = new ChessBoardConfiguration(this);
		nextConfiguration.tiles[intoX][intoY] = nextConfiguration.tiles[fromX][fromY];
		nextConfiguration.tiles[fromX][fromY] = null;
		nextConfiguration.turnColor = !turnColor;
		return nextConfiguration;
	}
	
	/**
	 * Checks if the passed move is legal
	 */
	@Override
	public boolean isLegalMove(int fromX, int fromY, int toX, int toY){
		return  tiles[fromX][fromY] != null 						&&
				tiles[fromX][fromY].isOfColor(turnColor) 			&&
				checkPieceMovement(fromX,fromY, toX, toY) 			&&
				!isNextConfigurationAChess(fromX,fromY, toX, toY);
	}
	
	/**
	 * Checks if there are no legal movement for the player of color "color" in this configuration
	 */
	@Override
	public boolean noLegalmoves(boolean color) {

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

	/**
	 * Checks if the player of color "color" is in chess in this configuration
	 */
	@Override
	public boolean isChessConfiguration(boolean color){
		
		int kingPosX = 0;
		int kingPosY = 0;
		boolean findKing = false;
		
		boolean chess = false;
		
		for(int i=0; i<Constants.tileSizeX; i++){
			for(int j=0; j<Constants.tileSizeY; j++){
				if(tiles[i][j] != null && tiles[i][j] instanceof King && tiles[i][j].isOfColor(color)){
					kingPosX = i;
					kingPosY = j;
					findKing = true;
				}
			}
		}
		
		if(findKing){
			//se tutti i pezzi dell'altro colore non hanno come mossa legale la pos del re allora non è scacco
			for(int i=0; i<Constants.tileSizeX && !chess; i++){
				for(int j=0; j<Constants.tileSizeY && !chess; j++){
					if(tiles[i][j] != null && !tiles[i][j].isOfColor(color) && checkPieceMovement(i, j, kingPosX, kingPosY)){
						chess = true;
					}
				}
			}
		}
		return chess;
	}
	
	
	
	/**
	 * Set this configuration to the start configuration of the chess game
	 */
	private void resetConfiguration(){
		
		ChessPiecesFactory factory = new StandardChessPiecesFactory();
		
		//inserisce la fila di pedoni neri
		int pawnsPositionX = 1;
		for(int y = 0; y < Constants.tileSizeY; y++){
			tiles[pawnsPositionX][y] = factory.createPiece("pawn" , Constants.blackColor);
		}
		
		//inserisce la fila di pedoni bianchi
		pawnsPositionX = 6;
		for(int y = 0; y < Constants.tileSizeY; y++){
			tiles[pawnsPositionX][y] = factory.createPiece("pawn" , Constants.whiteColor);
		}
		
		tiles[0][0] = factory.createPiece	("rook" , Constants.blackColor);
		tiles[0][1] = factory.createPiece	("knight",Constants.blackColor);
		tiles[0][2] = factory.createPiece	("bishop",Constants.blackColor);
		tiles[0][3] = factory.createPiece	("queen", Constants.blackColor);
		tiles[0][4] = factory.createPiece   ("king",  Constants.blackColor);
		tiles[0][5] = factory.createPiece	("bishop",Constants.blackColor);
		tiles[0][6] = factory.createPiece	("knight",Constants.blackColor);
		tiles[0][7] = factory.createPiece	("rook" , Constants.blackColor);
		
		tiles[7][0] = factory.createPiece	("rook" , Constants.whiteColor);
		tiles[7][1] = factory.createPiece	("knight",Constants.whiteColor);
		tiles[7][2] = factory.createPiece	("bishop",Constants.whiteColor);
		tiles[7][3] = factory.createPiece	("queen", Constants.whiteColor);
		tiles[7][4] = factory.createPiece   ("king",  Constants.whiteColor);
		tiles[7][5] = factory.createPiece	("bishop",Constants.whiteColor);
		tiles[7][6] = factory.createPiece	("knight",Constants.whiteColor);
		tiles[7][7] = factory.createPiece	("rook" , Constants.whiteColor);
	
		turnColor = Constants.whiteColor;
	}
	
	/**
	 * Checks if there are some pieces on the path that bring from (fromX,fromY) to (toX,toY) excluding
	 * for the start and the final tile
	 */
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
	
	/**
 	 * Checks if there is in the arrival a piece of the same color of the piece placed on the start tile
	 */
	private boolean sameColorOnTheArrival(int fromX, int fromY, int toX, int toY){
		if(tiles[toX][toY] != null){
			return tiles[toX][toY].isOfColor(tiles[fromX][fromY]);
		}
		else{
			return false;
		}
	}
	
	/**
	 * Checks if the piece placed in (fromX,fromY) can move in the tile (toX, toY) considering if that piece can make
	 * that move, if there isn't a piece of the same color on the arrival and if there aren't no pieces on that path
	 */
	private boolean checkPieceMovement(int fromX, int fromY, int toX, int toY){
		return 	(tiles[fromX][fromY].canMove(fromX, fromY, toX, toY, this) 		&&						//se la mossa da fare è nel set di mosse possibile per il tipo di pezzo selezionato
				!sameColorOnTheArrival(fromX, fromY, toX, toY) 					&&						//se nella casella di arrivo non c'è un pezzo dello stesso colore
				(tiles[fromX][fromY].canFly() || !someoneOnThePath(fromX, fromY, toX, toY)));
	}
	
	/**
	 * Checks if the configuration generated by moving the piece from (fromX,fromY) to (toX,toY) is a chess configuration
	 * for the same player who have done that move
	 */
	private boolean isNextConfigurationAChess(int fromX, int fromY, int toX, int toY){
		Configuration moveConfig = this.swap(fromX, fromY, toX, toY);
		if(moveConfig.isChessConfiguration(turnColor)){
			return true;
		}
		else{
			return false;
		}
	}
	

}
