package game;

import pieces.Piece;

public class Move {
    private final long INITIAL_POS;
    private final long FINAL_POS;
    private final Piece PIECE;
    private final MoveType TYPE;

    public Move(long initialPos, long finalPos, Piece piece, MoveType type) {
        INITIAL_POS = initialPos;
        FINAL_POS = finalPos;
        PIECE = piece;
        TYPE = type;
    }
}
