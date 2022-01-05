package pieces;

import java.util.ArrayList;

public class Knight extends Piece {
	private int pos;
	public Knight(boolean isWhite, int pos) {
		super(isWhite, PieceType.KNIGHT, 3);
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
		// TODO Auto-generated method stub
		
	}

	public int getPos() {
		return pos;
	}
	
}
