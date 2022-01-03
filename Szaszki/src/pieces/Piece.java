package pieces;

public abstract class Piece 
{
	private boolean isWhite;
	private PieceType type;
	public int pos;

	protected abstract int[] possibleMoves();
	protected abstract boolean isMovePossible(Piece[] board);
	protected abstract void move();
	
	public Piece(boolean isWhite, int pos, PieceType type) {
		this.isWhite = isWhite;
		this.pos = pos;
		this.type = type;
	}
	public boolean isWhite() {
		return isWhite;
	}
	public PieceType getType() {
		return type;
	}
	public int getPos() {
		return pos;
	}
}
