
import boardgame.Board;
import boardgame.Position;
import chess.ChessMatch;
import chess.ChessPiece;
import chess.ChessPosition;
import java.util.Scanner;


public class Program {

    public static void main(String[] args) {
        //Board board = new Board(8, 8);
        Scanner sc = new Scanner (System.in);
        ChessMatch chessMatch = new ChessMatch();
        
        while(true){
            UI.printBoard(chessMatch.getPieces());
            System.out.println();
            System.out.print("Procura: ");
            ChessPosition source = UI.readChessPosition(sc);
            
            System.out.println();
            System.out.print("Alvo: ");
            ChessPosition target = UI.readChessPosition(sc);
       
            ChessPiece capturedPiece = chessMatch.performChessMove(source, target);
        }
    }
    
}
