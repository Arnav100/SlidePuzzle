package puzzle;

import java.util.ArrayList;


public class State {
	int _size;
	int _xPosition;
	int _yPosition;
	int[][] _values;
	
	public State(int size) {
		 _size = size - 1;
		 _values = new int[size][size];
		 int area = size*size;
		 int[] tiles = new int[area];
	
		 ArrayList<Integer> list = new ArrayList<>();
		 for (int i = 0; i < area; i++){
		     list.add(i);
		 }
		
		 for (int count = 0; count < area; count++){
		     tiles[count] = list.remove((int)(Math.random() * list.size())); 
		   //removing a random number from list, and puts in tiles, guarantees that value is unique
		 }	 
		 
		 int tileNum = 0;
		 for(int y = 0; y < size; y ++) {
			 for(int x = 0; x < size; x++){				
				_values[y][x] = tiles[tileNum];
				if(tiles[tileNum]==0){
					_yPosition = y;
					_xPosition = x;
				}
				tileNum ++;
			} 
		} 
	}
	
	public static State getSolution(int size) {
		State solution = new State(size);
		int[][] solved = new int[size][size];
		int tileNum = 0;
		for(int y = 0; y < size; y ++) {
			 for(int x = 0; x < size; x++){				
				solved[y][x] = tileNum;
				tileNum ++;
			} 
		}
		solution.setBoard(solved, 0, 0);
		return solution;
	}
	
	public void setBoard(int[][] newBoard, int x, int y){
		this._values = newBoard;
		this._xPosition = x;
		this._yPosition = y;
	}
	
	public int[][] getBoard() {
		return _values;
	}
	

	public int[] find(int a) {
		int[] index = new int[2];
		for(int y = 0; y <= _size; y ++ ){
			for(int x = 0; x <= _size; x ++){
				if(_values[y][x] == a) {
					 index[0] = y;
					 index[1] = x;
				}
			}
		}
		return index;
	}
	
 	public State moveRight() {
 		int[][] temp = _values.clone();
 		State newState = new State(this._size +1); //check if using _size is ok
 		if(_xPosition != _size){
 			//change values
 			temp[_yPosition][_xPosition] = _values[_yPosition][_xPosition + 1];
 			temp[_yPosition][_xPosition + 1] = 0;
 			_xPosition ++; 
 			newState.setBoard(temp, _xPosition, _yPosition);
 	 		return newState;
 		}
 		return null;
 	}
 	
 	public State moveLeft() {
 		int[][] temp = _values.clone();
 		State newState = new State(this._size + 1);
 		if(_xPosition != 0){
 			//change values
 			temp[_yPosition][_xPosition] = _values[_yPosition][_xPosition - 1];
 			temp[_yPosition][_xPosition - 1] = 0;
 			_xPosition --;
 			newState.setBoard(temp, _xPosition, _yPosition);
 	 		return newState;
 		}
 		return null;
 	}
 	
 	public State moveDown() {
 		int[][] temp = _values.clone();
 		State newState = new State(this._size +1);
 		if(_yPosition != _size){
 			//change values;
 			temp[_yPosition][_xPosition] = _values[_yPosition + 1][_xPosition];
 			temp[_yPosition + 1][_xPosition] = 0;
 			_yPosition ++;
 			newState.setBoard(temp, _xPosition, _yPosition);
 	 		return newState;
 		}
 		return null;
 	}
 
 	public State moveUp() {
 		int[][] temp = _values.clone();
 		State newState = new State(this._size +1);
 		if(_yPosition != 0){
 			//change values;
 			temp[_yPosition][_xPosition] = _values[_yPosition - 1][_xPosition];
 			temp[_yPosition - 1][_xPosition] = 0;
 			_yPosition --;
 			newState.setBoard(temp, _xPosition, _yPosition);
 	 		return newState;
 		}
 		return null;
 	}
 	
 	public ArrayList<State> getChildren() {
		ArrayList<State> Children = new ArrayList<State>();
		State up = moveUp();
		State down = moveDown();
		State left = moveLeft();
		State right = moveRight();
		
		if(up != null){
			Children.add(up);
		}
		if(right != null){
			
			Children.add(right);
		}
		if(left != null){
			Children.add(left);
		}
		if(down != null){
			Children.add(down);
		}
		return Children;
  }
 	
 	public boolean compare(State s) {
 	 int[][] check = s.getBoard();
 			for(int y = 0; y <= _size; y ++ ){
 				for(int x = 0; x <= _size; x ++){
 					if(this._values[y][x] != check[y][x]){
 						return false;
 					}
 				}
 			}
 		return true;
 		} 	


}
