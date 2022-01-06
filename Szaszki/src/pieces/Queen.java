package pieces;

import game.Board;

import java.util.ArrayList;

public class Queen extends Piece implements SlideMove {
	private int pos;
	
	public Queen(boolean isWhite, int pos) {
		super(isWhite, PieceType.QUEEN, 9);
		this.pos = pos;
	}

	@Override
	public ArrayList<Integer> possibleMoves() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isMovePossibleWhite(Board board, int move) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isMovePossibleBlack(Board board, int move) {
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

	@Override
	public ArrayList<Integer> listPossibleMoves(Board board, boolean isWhite) {
		// TODO Auto-generated method stub
		return null;
	}
}
