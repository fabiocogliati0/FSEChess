/**
 * Fabio Cogliati
 * Progetto di Fundamentals of software engineering
 */

package controller;

import moves.Mover;
import moves.Solver;
import view.View;

public class ChessBoardController implements Controller{

	private final View view;
	private final Mover mover;
	private final Solver solver;
	
	public ChessBoardController(View view){
		this.view = view;
		this.mover = new Mover(view.getModel());
		this.solver = new Solver(view.getModel());
		
		view.setController(this);
	}
	
	@Override
	public void onClick(int x, int y) {
		mover.moveAt(x,y);
		if(mover.isSolved())
			view.showSolvedDialog();
	}

}
