package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import puzzle.Game;

public class SolveListener implements ActionListener {
	private Game _game;
	
	public SolveListener(Game g){
		_game = g;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		_game.solve();
	}
}
