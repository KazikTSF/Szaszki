package pieces;

import game.Board;
import game.Move;

import java.util.ArrayList;

public class King extends Piece implements SlideMove {

	private boolean canQCastle;
	private boolean canKCastle;
	private int pos;
	
	public King(boolean isWhite, int pos, boolean canQCastle, boolean canKCastle) {
		super(isWhite, PieceType.KING, 200);
		this.pos = pos;
		this.canKCastle = canKCastle;
		this.canQCastle = canQCastle;
	}
	@Override
	public ArrayList<Integer> possibleMoves() {
		ArrayList<Integer> fmoves = new ArrayList<>();
		int[] moves = new int[10];
		int row = pos/8;
		int col = pos%8;
		moves[0] = -9;
		moves[1] = -8;
		moves[2] = -7;
		moves[3] = -1;
		moves[4] = 1;
		moves[5] = 9;
		moves[6] = 8;
		moves[7] = 7;
		moves[8] = 2;
		moves[9] = -2;
		if(col == 0) {
			moves[0] = 64;
			moves[3] = 64;
			moves[7] = 64;
		}
			
		if(col == 7) {
			moves[2] = 64;
			moves[4] = 64;
			moves[5] = 64;
		}
		if(row == 0) {
			moves[0] = 64;
			moves[1] = 64;
			moves[2] = 64;
		}
		if(row == 7) {
			moves[5] = 64;
			moves[6] = 64;
			moves[7] = 64;
		}
		for(int i = 0; i < 10; i++) {
			if(moves[i] != 64)
				fmoves.add(moves[i]);
		}
			
		return fmoves;
	}

	@Override
	public boolean isMovePossibleWhite(Board board, int move) {
		ArrayList<Move> attackedSquares;
		attackedSquares = board.getPossibleMovesBlack();
		int size = attackedSquares.size();
		for(int i = 0; i < size; i++) {
			if(attackedSquares.get(i).getPiece().getType() == PieceType.PAWN) {
				if (attackedSquares.get(i).getMove() == 7 || attackedSquares.get(i).getMove() == 9) {
					attackedSquares.remove(i);
					size--;
				}
			}
			if(pos+move == attackedSquares.get(i).getFinalPos())
				return false;
		}
		if(move == 2) {
			if(!canKCastle)
				return false;
			for(int i = 0; i < attackedSquares.size(); i++) {
				if(attackedSquares.get(i).getFinalPos() == 62)
					return false;
				if(attackedSquares.get(i).getFinalPos() == 61)
					return false;
				if(attackedSquares.get(i).getFinalPos() == 60)
					return false;
			}
			if(board.getBoard()[62] != null)
				return false;
			if(board.getBoard()[61] != null)
				return false;
			if(board.getBoard()[63] == null)
				return false;
			if(board.getBoard()[63].getType() != PieceType.ROOK || !board.getBoard()[63].isWhite())
				return false;
		}
		else if(move == -2) {
			if(!canQCastle)
				return false;
			for(int i = 0; i < attackedSquares.size(); i++) {
				if (attackedSquares.get(i).getFinalPos() == 58)
					return false;
				if (attackedSquares.get(i).getFinalPos() == 59)
					return false;
				if (attackedSquares.get(i).getFinalPos() == 60)
					return false;
			}
			if(board.getBoard()[59] != null)
				return false;
			if(board.getBoard()[58] != null)
				return false;
			if(board.getBoard()[57] != null)
				return false;
			if(board.getBoard()[56] == null)
				return false;
			if(board.getBoard()[56].getType() != PieceType.ROOK || !board.getBoard()[56].isWhite())
				return false;
		}
		if(board.getBoard()[pos+move] == null || !board.getBoard()[pos+move].isWhite())
			return true;
		return false;
	}

	@Override
	public boolean isMovePossibleBlack(Board board, int move) {
		ArrayList<Move> attackedSquares;
		attackedSquares = board.getPossibleMovesWhite();
		int size = attackedSquares.size();
		for(int i = 0; i < size; i++) {
			if(attackedSquares.get(i).getPiece().getType() == PieceType.PAWN) {
				if (attackedSquares.get(i).getMove() == -7 || attackedSquares.get(i).getMove() == -9) {
					attackedSquares.remove(i);
					size--;
				}
			}
			if(pos+move == attackedSquares.get(i).getFinalPos())
				return false;
		}
		if(move == 2) {
			if(!canKCastle())
				return false;
			for(int i = 0; i < attackedSquares.size(); i++) {
				if(attackedSquares.get(i).getFinalPos() == 6)
					return false;
				if(attackedSquares.get(i).getFinalPos() == 5)
					return false;
				if(attackedSquares.get(i).getFinalPos() == 4)
					return false;
			}
			if(board.getBoard()[7] == null)
				return false;
			if(board.getBoard()[6] != null)
				return false;
			if(board.getBoard()[5] != null)
				return false;
			if(board.getBoard()[7].getType() != PieceType.ROOK || board.getBoard()[7].isWhite())
				return false;
		}
		else if(move == -2) {
			if(!canQCastle)
				return false;
			for(int i = 0; i < attackedSquares.size(); i++) {
				if (attackedSquares.get(i).getFinalPos() == 2)
					return false;
				if (attackedSquares.get(i).getFinalPos() == 3)
					return false;
				if (attackedSquares.get(i).getFinalPos() == 4)
					return false;
			}
			if(board.getBoard()[0] == null)
				return false;
			if(board.getBoard()[1] != null)
				return false;
			if(board.getBoard()[2] != null)
				return false;
			if(board.getBoard()[3] != null)
				return false;
			if(board.getBoard()[0].getType() != PieceType.ROOK || board.getBoard()[0].isWhite())
				return false;
		}
		if(board.getBoard()[pos+move] == null || board.getBoard()[pos+move].isWhite())
			return true;
		return false;
	}

	public boolean canQCastle() {
		return canQCastle;
	}
	public boolean canKCastle() {
		return canKCastle;
	}

	@Override
	public int getPos() {
		return pos;
	}
	
	@Override
	public void setPos(int pos) {
		this.pos = pos;
	}
}
