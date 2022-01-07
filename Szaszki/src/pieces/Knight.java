package pieces;

import game.Board;

import java.util.ArrayList;

public class Knight extends Piece {
	private int pos;
	public Knight(boolean isWhite, int pos) {
		super(isWhite, PieceType.KNIGHT, 3);
		this.pos = pos;
	}
	@Override
	public ArrayList<Integer> possibleMoves() {
		int[] moves = new int[8];
		ArrayList<Integer> fmoves = new ArrayList<>();
		int row = pos/8;
		int col = pos%8;
		moves[0] = 15;
		moves[1] = 17;
		moves[2] = -15;
		moves[3] = -17;
		moves[4] = 6;
		moves[5] = -10;
		moves[6] = 10;
		moves[7] = -6;
		if(row == 0) {
			moves[2] = 64;
			moves[3] = 64;
			moves[5] = 64;
			moves[7] = 64;
		}
		else if(row == 1) {
			moves[2] = 64;
			moves[3] = 64;
		}
		else if(row == 7) {
			moves[0] = 64;
			moves[1] = 64;
			moves[4] = 64;
			moves[6] = 64;
		}
		else if(row == 6) {
			moves[0] = 64;
			moves[1] = 64;
		}
		if(col == 0) {
			moves[0] = 64;
			moves[3] = 64;
			moves[4] = 64;
			moves[5] = 64;
		}
		else if(col == 1) {
			moves[4] = 64;
			moves[5] = 64;
		}
		else if(col == 7) {
			moves[1] = 64;
			moves[2] = 64;
			moves[6] = 64;
			moves[7] = 64;
		}
		else if(col == 6) {
			moves[6] = 64;
			moves[7] = 64;
		}
		for(int i = 0; i < 8; i++) {
			if(moves[i] != 64)
				fmoves.add(moves[i]);
		}
		return fmoves;
	}

	@Override
	public boolean isMovePossibleWhite(Board board, int move) {
		int finalPos=pos+move;
		if(board.getBoard()[finalPos] == null)
			return true;
		if(!board.getBoard()[finalPos].isWhite())
			return true;
		return false;
	}

	@Override
	public boolean isMovePossibleBlack(Board board, int move) {
		int finalPos=pos+move;
		if(board.getBoard()[finalPos] == null)
			return true;
		if(board.getBoard()[finalPos].isWhite())
			return true;
		return false;
	}

	@Override
	public int getPos() {
		return pos;
	}
	
	@Override
	public void setPos(int pos) {
		this.pos = pos;
	}
}
