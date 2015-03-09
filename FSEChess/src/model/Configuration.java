/**
 * Fabio Cogliati
 * Progetto di Fundamentals of software engineering
 */

package model;

import model.ChessPieces.ChessPiece;

public interface Configuration {
	ChessPiece at(int x,int y);
	Configuration swap(int fromX, int fromY, int intoX, int intoY);
}
