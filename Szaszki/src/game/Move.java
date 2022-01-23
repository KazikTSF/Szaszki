package game;

import pieces.Piece;
import pieces.PieceType;

public class Move {
    private final long INITIAL_POS;
    private final long FINAL_POS;
    private final PieceType PIECE_TYPE;
    private final MoveType TYPE;

    public Move(long initialPos, long finalPos, PieceType pieceType, MoveType type) {
        INITIAL_POS = initialPos;
        FINAL_POS = finalPos;
        PIECE_TYPE = pieceType;
        TYPE = type;
    }
}
