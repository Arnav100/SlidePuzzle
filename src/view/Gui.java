package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import puzzle.*;

public class Gui {
	 private JFrame _window;
	 private Game _game; 
	 private JPanel _statePanel;
	 private JPanel _optionsPanel;
	 
	public Gui() {
		_window = new JFrame();
		_game = new Game(this, 3);
		_statePanel = new JPanel();
		_optionsPanel = new JPanel();
		_window.add(_statePanel);
		_window.add(_optionsPanel);
		_window.setLayout(new GridLayout(0,1));
		createOptions();
		update();
	}
	

	private void createOptions() {
	
		JButton b = new JButton("Solve!");
		b.addActionListener(new SolveListener(_game));
		_optionsPanel.add(b);
	}
		
	public void update() {
		_statePanel.removeAll();
		_statePanel.setLayout(new GridLayout(_game.getSize(), _game.getSize()));
		
		ButtonListener bListener = new ButtonListener(_game, this);
		int size = _game.getSize();
		int[][] board = _game.getBoard();
		
		for(int y = 0; y < size; y ++){
			for(int x = 0; x < size; x ++){
				
				JButton tile = new JButton("" + board[y][x]);		
				tile.addActionListener(bListener);
				
				if(board[y][x] == 0){
					tile.setBackground(new Color(255, 0, 0));
					tile.setOpaque(true);
					tile.setBorderPainted(false);
				}else{
					tile.setBackground(new Color(0,255,0));
					tile.setOpaque(true);
					tile.setBorderPainted(false);
				}
				
				tile.setFont(new Font("TimesRoman", Font.BOLD, 24));
				_statePanel.add(tile);
				
			}
		}
		
		_window.setSize(1000, 1000);
		_window.setVisible(true);
		_window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public void changeTileBorderColor(JButton tile, Color color) {
		tile.setBackground(color);
		tile.setOpaque(true);
		tile.setBorderPainted(false);
	}
}
