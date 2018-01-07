package puzzle;

import java.util.ArrayList;

import view.Gui;

public class Game {
	private int _size;
	private State _currentState; 
	private Gui _gui;
	
	public Game(Gui g, int size){
		_gui = g;
		_size = size;
		_currentState = new State(_size);
	}
	
	public State reset() {
		_currentState = new State(_size);
		return _currentState;
	}
	
	public void setSize(int a) {
		_size = a;
		reset();
	}
	
	public int[][] getBoard() {
		return _currentState.getBoard();
	}
	
	public State getState() {
		return _currentState;
	}
	
	
	public int getSize() {
		return _size;
	}
	
	public void moveRight() {
		State s = _currentState.moveRight();
		if(s != null){
		_currentState = s;
		}
	}
	
	public void moveLeft() {
		State s = _currentState.moveLeft();
		if(s != null){
		_currentState = s;
		}
		
	}
	
	public void moveUp() {
		State s = _currentState.moveUp();
		if(s != null){
		_currentState = s;
		}
	}
	
	public void moveDown() {
		State s = _currentState.moveDown();
		if(s != null){
		_currentState = s;
		}
	}
	
	public ArrayList<State> getChildren(){
		return _currentState.getChildren();
	}
		
	public int getZeroX() {
		return _currentState._xPosition;
	}
	
	public int getZeroY() {
		return _currentState._yPosition;
	}
	
	public void swap(int a, int b) {
		// TODO Auto-generated method stub
		if(a != 0 && b != 0){
			return;
	}
		int[] zeroCoord = null;
		int[] otherCoord = null;
		if(a == 0){
			zeroCoord =_currentState.find(a);
			otherCoord = _currentState.find(b);
		}
		if(b == 0){
			otherCoord =_currentState.find(a);
			zeroCoord = _currentState.find(b);	
		}
		int rowChange = otherCoord[0] - zeroCoord[0];
		int columnChange = otherCoord[1] - zeroCoord[1];
		
		if(Math.abs(rowChange) == 1 && columnChange == 0 ){
			if(rowChange == 1){
				moveDown();
			}
			if(rowChange == -1){
				moveUp();
			}
		}
		if(Math.abs(columnChange) == 1 && rowChange == 0 ){
			if(columnChange == 1){
				moveRight();
			}
			if(columnChange == -1){
				moveLeft();
			}
		}
	}

	public State getGoal(){
		State s = State.getSolution(getSize());
		return s;
	}
	
	public void solve() {
		ArrayList<State> steps = Solver.BFSSolve(_currentState, getGoal());
		for(State s: steps){
			_currentState = s;
			
			//TimeDelay
			
			_gui.update();
		}
	}
}

