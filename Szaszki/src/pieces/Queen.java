package pieces;

import java.util.ArrayList;

public class Queen extends Piece {
	private int pos;
	
	public Queen(boolean isWhite, int pos) {
		super(isWhite, PieceType.QUEEN, 9);
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
