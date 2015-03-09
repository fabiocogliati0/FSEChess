/**
 * Fabio Cogliati
 * Progetto di Fundamentals of software engineering
 */

package view;

import java.awt.GridLayout;		//ATTENZIONE: POSSO IMPORTARE DA AWT?
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import model.Model;
import controller.Controller;

public class ChessBoardPanel extends JPanel implements View{
	
	private final int TilesSizeX = 8;
	private final int TilesSizeY = 8;
	
	private final JFrame frame;
	private final Model model;
	private Controller controller;
	private final JButton[][] buttons = new JButton[TilesSizeX][TilesSizeY];
	
	//-------------------------------Public methods-------------------------------------------
	
	public ChessBoardPanel(Model model, JFrame frame){
		this.model = model;
		this.frame = frame;
		
		createButtons();
		
		model.setView(this);
	}
	
	@Override
	public Model getModel() {
		return model;
	}

	@Override
	public void setController(Controller controller) {
		this.controller = controller;
	}

	@Override
	public void showSolvedDialog() {
		//TODO
		//new SolvedDialog(frame, controller).setVisible(true);
	}

	@Override
	public void onConfigurationChange() {
		for(int y = 0; y<TilesSizeY; y++){
			for(int x = 0; x<TilesSizeX; x++){
				buttons[x][y].setText(model.at(x, y) == 0 ? "" : String.valueOf(model.at(x, y)));
			}
		}
	}
	
	
	//-------------------------------Private methods-------------------------------------------

	private void createButtons(){
		setLayout(new GridLayout(TilesSizeX,TilesSizeY));
		
		for(int y = 0; y<TilesSizeY; y++){
			for(int x = 0; x<TilesSizeX; x++){
				add(buttons[x][y] = makeButton(x,y,model.at(x, y)));
			}
		}
	}
	
	private JButton makeButton(int x, int y, int value){
		JButton button = new JButton(value == 0 ? "" : String.valueOf(value));
		button.addActionListener(event -> {
			if(controller != null){
				controller.onClick(x, y);
			}
		});
		
		return button;
	}
	
}
