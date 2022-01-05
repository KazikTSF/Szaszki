package pieces;

import java.util.ArrayList;

public class Bishop extends Piece {

	private int pos;
	
	public Bishop(boolean isWhite, int pos) {
		super(isWhite, PieceType.BISHOP, 3);
		this.pos = pos;
	}

	@Override
	protected ArrayList<Integer> possibleMoves() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected boolean isMovePossible(Piece[] board) {
		// TODO Auto-generated method stub
		return false;
	}
	
	@Override
	protected ArrayList<Integer> move() {
		return null;
		
	}

	public int getPos() {
		return pos;
	}
}
