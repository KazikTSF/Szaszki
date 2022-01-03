package pieces;

public class King extends Piece {

	private boolean canQCastle;
	private boolean canKCastle;
	
	public King(boolean isWhite, int pos, boolean canQCastle, boolean canKCastle) {
		super(isWhite, pos, PieceType.KING);
		this.canKCastle = canKCastle;
		this.canQCastle = canQCastle;
	}

	@Override
	protected int[] possibleMoves() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected boolean isMovePossible(Piece[] board) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	protected void move() {
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
	
}
