package puzzle;

import java.awt.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;


public class Solver {
/*	Game _game;
	State solution;
	State check;
	
	public Solver(Game g) {
	_game = g;
	 solution = _game.getSolution();
	 check = _game.getState();
	}
	
	public void addChildren(ArrayList<State> a, State s){
		State[] children = s.getChildren();
		for(int i = 0; i < children.length; i ++ ){
			if(children[i] != null){
			a.add(children[i]);
			}
		}
	}
	
	public State Solve() {
	
		ArrayList<State> one = new ArrayList<>();
		ArrayList<State> two = new ArrayList<>();
		
		addChildren(one, check);
		
		boolean checkSecond = false;
		
		int i = 0;
		int r = 0;
		while(!(solution.compare(check))){
			if(i < one.size() && !checkSecond){
				check = one.get(i);
				System.out.print(check.getBoard());
				if(!(solution.compare(check))){
					addChildren(two, one.get(i));
					one.remove(i);
					i ++;
				}
				r = 0;
			}
			else {
				checkSecond = true;
				if(r < two.size()){
					check = two.get(r);
					if(!(solution.compare(check))){
						addChildren(one, two.get(r));
						two.remove(i);
						r ++;
					}
				}
				else  {
					checkSecond = false;
					i = 0;
				}
			}		
		}
		return check;
	} */
	
    Map<State, State> map;
	
    public Solver() {
    	map = new HashMap<State, State>(); 
    }
    
	public static ArrayList<State> GetMap(State goal, State original) {
		ArrayList<State> States = new ArrayList<State>();
		State solution = goal;
		while(!(original.compare(solution))){
			States.add(solution);
			solution = map.get(solution);
		}
		return States;
	}
	
	public static ArrayList<State> BFSSolve(State current, State goal) {
		ArrayList<State> ret = new ArrayList<State>();
		LinkedList<State> queue = new LinkedList<State>();
		
		
		queue.add(current);
		while(!(queue.isEmpty())){
			State check = queue.pop();
			if(goal.compare(check)){
				ret = GetMap(goal, check);
			}
			for (State Child : check.getChildren()){
				queue.add(Child);
				if(!(map.containsKey(Child))){
					map.put(Child, check);
				}
			}
		}
		
		return ret;
	}
	
}
