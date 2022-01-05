package pieces;

import java.util.ArrayList;

public abstract class Piece 
{
	private boolean isWhite;
	private PieceType type;
	private int value;

	protected abstract ArrayList<Integer> possibleMoves();
	public abstract boolean isMovePossible(Piece[] board, int move);
	public ArrayList<Integer> listPossibleMoves(Piece[] board) {
		ArrayList<Integer> moves = new ArrayList<Integer>();
		ArrayList<Integer> fmoves = new ArrayList<Integer>();
		moves.addAll(possibleMoves());
		for(int i = 0; i < moves.size(); i++) {
			if(isMovePossible(board, moves.get(i)))
				fmoves.add(moves.get(i));
		}
		return fmoves;
	}
	
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
	public abstract int getPos();
	public abstract void setPos(int pos);
}
