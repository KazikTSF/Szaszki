package game;

import pieces.Piece;

import java.util.ArrayList;

public class Game {

	Board board;
	Piece selected;
	int selectedPos;
	public Game(String FEN) {
		board = new Board(FEN);
	}
	public Board getBoard() {
		return board;
	}
	public static String convertFromPos(int pos) {
		String s = "";
		int col = pos%8;
		int row = 8-pos/8;
		switch (col) {
			case 0 -> s += "a";
			case 1 -> s += "b";
			case 2 -> s += "c";
			case 3 -> s += "d";
			case 4 -> s += "e";
			case 5 -> s += "f";
			case 6 -> s += "g";
			case 7 -> s += "h";
		}
		s+=row;
		return s;
	}
	public boolean moveInput(int row, int col) {
		if(selected == null) {
			int tselectedPos = 8*row+col;
			if(board.getBoard()[tselectedPos] == null)
				return false;
			Piece tselected = board.getBoard()[tselectedPos];
			if((board.isWhiteMove() && tselected.isWhite()) || (!board.isWhiteMove() && !tselected.isWhite())) {
				selected = tselected;
				selectedPos = tselectedPos;
			}
			return false;
		}
		else {
			int move = (8 * row + col) - selected.getPos();
			ArrayList<Integer> moves = new ArrayList<>(selected.getPossibleMoves());
			for (Integer i : moves) {
				if (i == move) {
					board.move(selected, move);
				}
			}
			selected = null;
			return true;
		}
	}

	public Piece getSelected() {
		return selected;
	}
}
