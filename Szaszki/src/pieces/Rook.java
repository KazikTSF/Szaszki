package pieces;

import java.util.ArrayList;

public class Rook extends Piece implements SlideMove {
	private int pos;
	
	public Rook(boolean isWhite, int pos) {
		super(isWhite, PieceType.ROOK, 5);
		this. pos = pos;
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
		ArrayList<Integer> moves = new ArrayList<Integer>();
		moves.addAll(slideMove(pos));
		return moves;
	}

	public int getPos() {
		return pos;
	}
	
}
