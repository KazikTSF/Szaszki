package pieces;

import game.Board;

import java.util.ArrayList;

public class Rook extends Piece implements SlideMove {
	private int pos;
	
	public Rook(boolean isWhite, int pos) {
		super(isWhite, PieceType.ROOK, 5);
		this. pos = pos;
	}

	@Override
	public ArrayList<Integer> possibleMoves() {
		ArrayList<Integer> moves = new ArrayList<>();
		ArrayList<ArrayList<Integer>> temp = new ArrayList<>();
		temp.addAll(SlideMove.slideMove(pos));
		for(int i = 0; i < 4; i++)
			moves.addAll(temp.get(i));

		return moves;
	}

	@Override
	public boolean isMovePossibleWhite(Board board, int move) {
		int posAfterMove = pos+move;
		if(move > 7) {
			for(int i = pos+8; i <= posAfterMove; i+=8) {
				if(board.getBoard()[i] != null) {
					if(i-pos == move && !board.getBoard()[i].isWhite())
						break;
					return false;
				}
			}
			return true;
		}
		else if(move < -7) {
			for(int i = pos-8; i >= posAfterMove; i-=8) {
				if(board.getBoard()[i] != null) {
					if(i-pos == move && !board.getBoard()[i].isWhite())
						break;
					return false;
				}
			}
			return true;
		}
		else if(move < 0) {
			for(int i = pos-1; i >= posAfterMove; i--) {
				if(board.getBoard()[i] != null) {
					if(i-pos == move && !board.getBoard()[i].isWhite())
						break;
					return false;
				}
			}
			return true;
		}
		for(int i = pos+1; i <= posAfterMove; i++) {
			if(board.getBoard()[i] != null) {
				if(i-pos == move && !board.getBoard()[i].isWhite())
					break;
				return false;
			}
		}
		return true;
	}

	@Override
	public boolean isMovePossibleBlack(Board board, int move) {
		int posAfterMove = pos+move;
		if(move > 7) {
			for(int i = pos+8; i <= posAfterMove; i+=8) {
				if(board.getBoard()[i] != null) {
					if(i-pos == move && board.getBoard()[i].isWhite())
						break;
					return false;
				}
			}
			return true;
		}
		else if(move < -7) {
			for(int i = pos-8; i >= posAfterMove; i-=8) {
				if(board.getBoard()[i] != null) {
					if(i-pos == move && board.getBoard()[i].isWhite())
						break;
					return false;
				}
			}
			return true;
		}
		else if(move < 0) {
			for(int i = pos-1; i >= posAfterMove; i--) {
				if(board.getBoard()[i] != null) {
					if(i-pos == move && board.getBoard()[i].isWhite())
						break;
					return false;
				}
			}
			return true;
		}
		for(int i = pos+1; i <= posAfterMove; i++) {
			if(board.getBoard()[i] != null) {
				if(i-pos == move && board.getBoard()[i].isWhite())
					break;
				return false;
			}
		}
		return true;
	}

	@Override
	public int getPos() {
		return pos;
	}
	
	@Override
	public void setPos(int pos) {
		this.pos = pos;
	}

	@Override
	public ArrayList<Integer> listPossibleMoves(Board board, boolean isWhite) {
		ArrayList<Integer> moves = new ArrayList<>();
		ArrayList<ArrayList<Integer>> temp = new ArrayList<>();
		temp.addAll(SlideMove.slideMove(pos));
		for(int i = 0; i < temp.size(); i++) {
			for (int j = 0; j < temp.get(i).size(); j++) {
				if(isWhite) {
					if(isMovePossibleWhite(board ,temp.get(i).get(j)))
						moves.add(temp.get(i).get(j));
				}
				else {
					if(isMovePossibleBlack(board ,temp.get(i).get(j)))
						moves.add(temp.get(i).get(j));
				}
			}
		}
		return moves;
	}
}
