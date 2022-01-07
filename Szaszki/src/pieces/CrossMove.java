package pieces;

import java.util.ArrayList;

public interface CrossMove {

	static ArrayList<ArrayList<Integer>> crossMove(int pos) {
		ArrayList<ArrayList<Integer>> moves = new ArrayList<>();
		ArrayList<Integer> temp = new ArrayList<>();
		// 0 - top right
		// 1 - bottom right
		// 2 - bottom left
		// 3 - top left
		int col = pos%8+1;
		int row = pos/8-1;

		for(int i = -7; row > -1 && col < 8; i-=7) {
			row--;
			col++;
			temp.add(i);
		}
		moves.add(temp);
		temp = new ArrayList<>();

		col = pos%8+1;
		row = pos/8+1;
		for(int i = 9; row < 8 && col < 8; i+=9) {
			row++;
			col++;
			temp.add(i);
		}
		moves.add(temp);
		temp = new ArrayList<>();

		col = pos%8-1;
		row = pos/8+1;
		for(int i = 7; row < 8 && col > -1; i+=7) {
			row++;
			col--;
			temp.add(i);
		}
		moves.add(temp);
		temp = new ArrayList<>();
		col = pos%8-1;
		row = pos/8-1;
		for(int i = -9; row > -1 && col > -1; i-=9) {
			row--;
			col--;
			temp.add(i);
		}
		moves.add(temp);
		return moves;
	}
}
