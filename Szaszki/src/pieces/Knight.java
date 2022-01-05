package pieces;

import java.util.ArrayList;

public class Knight extends Piece {
	private int pos;
	public Knight(boolean isWhite, int pos) {
		super(isWhite, PieceType.KNIGHT, 3);
		this.pos = pos;
	}

	@Override
	public ArrayList<Integer> possibleMoves() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isMovePossible(Piece[] board, int move) {
		// TODO Auto-generated method stub
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
	public ArrayList<Integer> listPossibleMoves(Piece[] board) {
		// TODO Auto-generated method stub
		return null;
	}
}
