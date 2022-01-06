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
		int col = pos%8;
		int row = pos/8;

		row++;
		col++;
		for(int i = pos-7; row > -1 && col < 8; i++) {
			row--;
			col++;
			temp.add(i);
		}
		moves.add(temp);
		temp = new ArrayList<>();

		col = pos%8;
		row = pos/8;
		for(int i = pos+9; row < 8 && col < 8; i++) {
			row++;
			col++;
			temp.add(i);
		}
		moves.add(temp);
		temp = new ArrayList<>();

		col = pos%8;
		row = pos/8;
		for(int i = pos+7; row < 8 && col > -1; i++) {
			row++;
			col--;
			temp.add(i);
		}
		moves.add(temp);
		temp = new ArrayList<>();

		col = pos%8;
		row = pos/8;
		for(int i = pos-9; row > -1 && col > -1; i++) {
			row--;
			col--;
			temp.add(i);
		}
		moves.add(temp);
		return moves;
	}
}
