package pieces;

public class Pawn extends Piece {
	
	public Pawn(boolean isWhite, int pos) {
		super(isWhite, pos, PieceType.PAWN);
	}

	@Override
	protected int[] possibleMoves() {
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
}
