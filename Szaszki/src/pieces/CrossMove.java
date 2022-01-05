package pieces;

import java.util.ArrayList;

public interface CrossMove {
	default ArrayList<Integer> crossMove(int pos) {
		ArrayList<Integer> moves = new ArrayList<Integer>();
		
		return moves;
	}
}
