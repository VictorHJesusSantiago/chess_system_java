import chess.ChessException;
import chess.ChessMatch;
import chess.ChessPiece;
import chess.ChessPosition;
import chess.Color;

public class ChessSystemTest {

    public static void main(String[] args) {
        startsWithStandardBoard();
        movesPawnAndTracksTurnState();
        rejectsEmptySourceSquare();
        detectsScholarsMate();
    }

    private static void startsWithStandardBoard() {
        ChessMatch match = new ChessMatch();

        assert match.getTurn() == 1 : "initial turn";
        assert match.getCurrentPlayer() == Color.WHITE : "initial player";
        assert countPieces(match) == 32 : "standard board piece count";
        assert "K".equals(match.getPieces()[7][4].toString()) : "white king on e1";
        assert "K".equals(match.getPieces()[0][4].toString()) : "black king on e8";
    }

    private static void movesPawnAndTracksTurnState() {
        ChessMatch match = new ChessMatch();

        ChessPiece captured = match.performChessMove(new ChessPosition('e', 2), new ChessPosition('e', 4));

        assert captured == null : "plain pawn move does not capture";
        assert match.getTurn() == 2 : "turn advances after a legal move";
        assert match.getCurrentPlayer() == Color.BLACK : "player alternates after move";
        assert match.getPieces()[4][4] != null : "pawn moved to e4";
        assert match.getPieces()[4][4].getColor() == Color.WHITE : "white pawn on e4";
        assert match.getEnPassantVulnerable() == match.getPieces()[4][4] : "double pawn move is en passant vulnerable";
    }

    private static void rejectsEmptySourceSquare() {
        ChessMatch match = new ChessMatch();

        assertThrows(ChessException.class, () ->
            match.performChessMove(new ChessPosition('e', 3), new ChessPosition('e', 4)));
    }

    private static void detectsScholarsMate() {
        ChessMatch match = new ChessMatch();

        match.performChessMove(new ChessPosition('e', 2), new ChessPosition('e', 4));
        match.performChessMove(new ChessPosition('e', 7), new ChessPosition('e', 5));
        match.performChessMove(new ChessPosition('f', 1), new ChessPosition('c', 4));
        match.performChessMove(new ChessPosition('b', 8), new ChessPosition('c', 6));
        match.performChessMove(new ChessPosition('d', 1), new ChessPosition('h', 5));
        match.performChessMove(new ChessPosition('g', 8), new ChessPosition('f', 6));
        match.performChessMove(new ChessPosition('h', 5), new ChessPosition('f', 7));

        assert match.getCheck() : "black is in check";
        assert match.getCheckMate() : "scholar's mate is checkmate";
    }

    private static int countPieces(ChessMatch match) {
        int total = 0;
        ChessPiece[][] pieces = match.getPieces();
        for (int row = 0; row < pieces.length; row++) {
            for (int column = 0; column < pieces[row].length; column++) {
                if (pieces[row][column] != null) {
                    total++;
                }
            }
        }
        return total;
    }

    private static <T extends Throwable> void assertThrows(Class<T> expected, ThrowingRunnable action) {
        try {
            action.run();
        } catch (Throwable actual) {
            if (expected.isInstance(actual)) {
                return;
            }
            throw new AssertionError("Expected " + expected.getName() + " but caught " + actual, actual);
        }
        throw new AssertionError("Expected " + expected.getName());
    }

    @FunctionalInterface
    private interface ThrowingRunnable {
        void run();
    }
}
