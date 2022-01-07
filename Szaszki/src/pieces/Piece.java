package pieces;

import game.Board;

import java.util.ArrayList;

public abstract class Piece {
	private final boolean isWhite;
	private final PieceType type;
	private final int value;
	private ArrayList<Integer> possibleMoves = new ArrayList<>();

	protected abstract ArrayList<Integer> possibleMoves();
	public abstract boolean isMovePossibleWhite(Board board, int move);
	public abstract boolean isMovePossibleBlack(Board board, int move);
	public abstract int getPos();
	public abstract void setPos(int pos);

	public ArrayList<Integer> listPossibleMoves(Board board, boolean isWhite) {
		ArrayList<Integer> fmoves = new ArrayList<>();
		ArrayList<Integer> moves = new ArrayList<>(possibleMoves());
		for(int move : moves) {
			if(isWhite) {
				if (isMovePossibleWhite(board, move))
					fmoves.add(move);
			}
			else {
				if (isMovePossibleBlack(board, move))
					fmoves.add(move);
			}
		}
		return fmoves;
	}
	public void update(Board board) {
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
