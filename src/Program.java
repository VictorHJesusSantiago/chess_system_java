
import chess.ChessException;
import chess.ChessMatch;
import chess.ChessPiece;
import chess.ChessPosition;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Program {

    public static void main(String[] args) {
        //Board board = new Board(8, 8);
        Scanner sc = new Scanner(System.in);
        ChessMatch chessMatch = new ChessMatch();
        List<ChessPiece> captured = new ArrayList<>();
        
        
        while (!chessMatch.getCheckMate()) {
            try {
                UI.clearScreen();
                UI.printMatch(chessMatch, captured);
                System.out.println();
                System.out.print("Procura: ");
                ChessPosition source = UI.readChessPosition(sc);
 
                boolean[][] possibleMoves = chessMatch.possibleMoves(source);
                UI.clearScreen();
                UI.printBoard(chessMatch.getPieces(), possibleMoves);
                System.out.println();
                System.out.print("Alvo: ");
                ChessPosition target = UI.readChessPosition(sc);

                ChessPiece capturedPiece = chessMatch.performChessMove(source, target);
                
                if(capturedPiece != null){
                    captured.add(capturedPiece);
                }
                
                if(chessMatch.getPromoted() != null){
                    System.out.print("Entre com a promoção da peça (B/H/R/Q: ");
                    String type =sc.nextLine();
                    chessMatch.replacePromotedPiece(type);
                }
            } 
            catch (ChessException e) {
                System.out.println(e.getMessage());
                sc.nextLine();
            }
            catch (InputMismatchException e) {
                System.out.println(e.getMessage());
                sc.nextLine();
            }
        }
        UI.clearScreen();
        UI.printMatch(chessMatch, captured);
    }

}
