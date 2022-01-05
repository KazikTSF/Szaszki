package pieces;

import java.util.ArrayList;

public abstract class Piece 
{
	private boolean isWhite;
	private PieceType type;
	private int value;

	protected abstract ArrayList<Integer> possibleMoves();
	protected abstract boolean isMovePossible(Piece[] board);
	protected abstract ArrayList<Integer> move();
	
	public Piece(boolean isWhite, PieceType type, int value) {
		this.isWhite = isWhite;
		this.type = type;
		this.value = value;
	}
	public boolean isWhite() {
		return isWhite;
	}
	public PieceType getType() {
		return type;
	}
}
