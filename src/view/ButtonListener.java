package view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;


import puzzle.Game;

public class ButtonListener implements ActionListener {
	
	String _pressedButton;
	Game _game;
	Gui _gui;
	public ButtonListener(Game g, Gui gui) {
		_game = g;
		_gui = gui;
	}
	
	public void actionPerformed(ActionEvent e) {
		if(_pressedButton == null){
			JButton button = ((JButton) e.getSource());
			_gui.changeTileBorderColor(button, Color.blue);
			_pressedButton = button.getText();
			return;
		}
		JButton button = ((JButton) e.getSource());
		_gui.changeTileBorderColor(button, Color.blue);
		String secondButton = button.getText();
		int firstNum = Integer.parseInt(_pressedButton);
		int secondNum = Integer.parseInt(secondButton);
		
		_game.swap(firstNum, secondNum);
		_gui.update();
		

		
	}
	


}
