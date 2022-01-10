package pieces;

public class Piece {
    private long possibleMoves;
    private long pos;
    private final PieceType TYPE;
    private final boolean IS_WHITE;

    public Piece(long pos, PieceType type, boolean isWhite) {
        this.pos = pos;
        this.TYPE = type;
        this.IS_WHITE = isWhite;
    }

    public long getPos() {
        return pos;
    }

    public PieceType getTYPE() {
        return TYPE;
    }

    public long getPossibleMoves() {
        return possibleMoves;
    }

    public boolean isIS_WHITE() {
        return IS_WHITE;
    }

    public void setPossibleMoves(long possibleMoves) {
        this.possibleMoves = possibleMoves;
    }
}
