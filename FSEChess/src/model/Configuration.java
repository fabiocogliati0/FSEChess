/**
 * Fabio Cogliati
 * Progetto di Fundamentals of software engineering
 */

package model;

import model.ChessPieces.ChessPiece;

public interface Configuration {
	public ChessPiece at(int x,int y);
	public Configuration swap(int fromX, int fromY, int intoX, int intoY);
	public boolean isChessConfiguration(boolean color);
	public boolean isChessMateConfiguration(boolean color);
	public boolean isLegalMove(int formX, int fromY, int toX, int toY);
}
