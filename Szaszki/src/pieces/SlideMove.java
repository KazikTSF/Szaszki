package pieces;

import java.util.ArrayList;

public interface SlideMove {
	
	static ArrayList<ArrayList<Integer>> slideMove(int pos) {
		
		ArrayList<ArrayList<Integer>> moves = new ArrayList<>();
		// 0 - up
		// 1 - right
		// 2 - down
		// 3 - left
		ArrayList<Integer> temp = new ArrayList<>();
		for(int i = -8; pos+i > 0; i-=8)
			temp.add(i);
		moves.add(temp);
		temp = new ArrayList<>();

		int col = pos%8;
		for(int i = 1; col < 7; i++) {
			col = (pos+i)%8;
			temp.add(i);
		}
		moves.add(temp);
		temp = new ArrayList<>();

		for(int i = 8; pos+i < 63; i+=8)
			temp.add(i);
		moves.add(temp);
		temp = new ArrayList<>();

		col = pos%8;
		for(int i = -1; col > 0; i--) {
			col = (pos+i)%8;
			temp.add(i);
		}
		moves.add(temp);

		return moves;
	}
}
