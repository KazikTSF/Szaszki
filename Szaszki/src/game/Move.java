package game;

import pieces.Piece;

public class Move {
    int move;
    int initialPos;
    int finalPos;
    Piece piece;

    public Move(int move, int initialPos, Piece piece) {
        this.move = move;
        this.initialPos = initialPos;
        this.piece = piece;
        finalPos=initialPos+move;
    }

    public int getMove() {
        return move;
    }

    public int getInitialPos() {
        return initialPos;
    }

    public int getFinalPos() {
        return finalPos;
    }

    public Piece getPiece() {
        return piece;
    }
}
