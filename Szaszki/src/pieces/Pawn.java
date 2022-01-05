package pieces;

import java.util.ArrayList;

public class Pawn extends Piece {
	private int pos;
	public Pawn(boolean isWhite, int pos) {
		super(isWhite, PieceType.PAWN, 1);
		this.pos = pos;
	}

	@Override
	protected ArrayList<Integer> possibleMoves() {
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
		// TODO Auto-generated method stub
		
	}

	public int getPos() {
		return pos;
	}
	
}
