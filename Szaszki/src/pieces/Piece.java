package pieces;

import game.Board;

import java.util.ArrayList;

public abstract class Piece
{
	private boolean isWhite;
	private PieceType type;
	private int value;
	private ArrayList<Integer> possibleMoves = new ArrayList<>();
	protected abstract ArrayList<Integer> possibleMoves();
	public abstract boolean isMovePossibleWhite(Board board, int move);
	public abstract boolean isMovePossibleBlack(Board board, int move);
	public abstract int getPos();
	public abstract void setPos(int pos);

	public ArrayList<Integer> listPossibleMoves(Board board, boolean isWhite) {
		ArrayList<Integer> moves = new ArrayList<>();
		ArrayList<Integer> fmoves = new ArrayList<>();
		moves.addAll(possibleMoves());
		for(int i = 0; i < moves.size(); i++) {
			if(isWhite) {
				if (isMovePossibleWhite(board, moves.get(i)))
					fmoves.add(moves.get(i));
			}
			else {
				if (isMovePossibleBlack(board, moves.get(i)))
					fmoves.add(moves.get(i));
			}
		}
		return fmoves;
	}
	public void update(Board board) {
		if(type != PieceType.KING && type != PieceType.ROOK && type != PieceType.PAWN)
			return;
		possibleMoves = new ArrayList<>();
		possibleMoves.addAll(listPossibleMoves(board, isWhite));
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

	public ArrayList<Integer> getPossibleMoves() {
		return possibleMoves;
	}
}
