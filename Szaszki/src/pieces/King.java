package pieces;

import java.util.ArrayList;

public class King extends Piece {

	private boolean canQCastle;
	private boolean canKCastle;
	private int pos;
	
	public King(boolean isWhite, int pos, boolean canQCastle, boolean canKCastle) {
		super(isWhite, PieceType.KING, 200);
		this.canKCastle = canKCastle;
		this.canQCastle = canQCastle;
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

	public boolean canQCastle() {
		return canQCastle;
	}

	public void setCanQCastle(boolean canQCastle) {
		this.canQCastle = canQCastle;
	}

	public boolean canKCastle() {
		return canKCastle;
	}

	public void setCanKCastle(boolean canKCastle) {
		this.canKCastle = canKCastle;
	}

	public int getPos() {
		return pos;
	}
	
	
}
