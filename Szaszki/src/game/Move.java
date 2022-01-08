package game;

import pieces.Piece;

public class Move {
    private final int MOVE;
    private final int INITIAL_POS;
    private final int FINAL_POS;
    Piece piece;

    public Move(int move, int initialPos, Piece piece) {
        this.MOVE = move;
        this.INITIAL_POS = initialPos;
        this.piece = piece;
        FINAL_POS =initialPos+move;
    }

    public int getMOVE() {
        return MOVE;
    }

    public int getINITIAL_POS() {
        return INITIAL_POS;
    }

    public int getFINAL_POS() {
        return FINAL_POS;
    }

    public Piece getPiece() {
        return piece;
    }
    @Override
    public String toString() {
        String s = piece.getType().name() + " ";
        s = s + Game.convertFromPos(INITIAL_POS) + "-" + Game.convertFromPos(FINAL_POS);
        return s;
    }
}
