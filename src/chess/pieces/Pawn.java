
package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessPiece;
import chess.Color;


public class Pawn extends ChessPiece{

    public Pawn(Board board, Color color) {
        super(board, color);
    }

    @Override
    public boolean[][] possibleMoves() {
        boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()]; 
        Position p = new Position(0,0);
        
        
        if(getColor() == Color.WHITE){
            
            //UMA CASA A FRENTE PARA O PEÃO
            p.setValues(position.getRow() - 1, position.getColumn());
            if(getBoard().positionExists(p) && !getBoard().thereIsaPiece(p)){
                mat[p.getRow()][p.getColumn()] = true;
            }
            
            //DUAS CASAs A FRENTE PARA O PEÃO
            p.setValues(position.getRow() - 2, position.getColumn());
            Position p2 = new Position(position.getRow() - 1, position.getColumn());
            if(getBoard().positionExists(p) && !getBoard().thereIsaPiece(p) && getBoard().positionExists(p2) && !getBoard().thereIsaPiece(p2) && getMoveCount() == 0){
                mat[p.getRow()][p.getColumn()] = true;
            }
            
            //DIAGONAL ESQUERDA DO PEÃO
            p.setValues(position.getRow() - 1, position.getColumn() - 1);
            if(getBoard().positionExists(p) && isThereOpponentPiece(p)){
                mat[p.getRow()][p.getColumn()] = true;
            }
            
            //DIAGONAL DIREITA DO PEÃO
            p.setValues(position.getRow() - 1, position.getColumn() + 1);
            if(getBoard().positionExists(p) && isThereOpponentPiece(p)){
                mat[p.getRow()][p.getColumn()] = true;
            }
            
        }
        else{
            //PEÃO PRETO
            //UMA CASA A FRENTE PARA O PEÃO
            p.setValues(position.getRow() + 1, position.getColumn());
            if(getBoard().positionExists(p) && !getBoard().thereIsaPiece(p)){
                mat[p.getRow()][p.getColumn()] = true;
            }
            
            //DUAS CASAs A FRENTE PARA O PEÃO
            p.setValues(position.getRow() + 2, position.getColumn());
            Position p2 = new Position(position.getRow() + 1, position.getColumn());
            if(getBoard().positionExists(p) && !getBoard().thereIsaPiece(p) && getBoard().positionExists(p2) && !getBoard().thereIsaPiece(p2) && getMoveCount() == 0){
                mat[p.getRow()][p.getColumn()] = true;
            }
            
            //DIAGONAL ESQUERDA DO PEÃO
            p.setValues(position.getRow() + 1, position.getColumn() - 1);
            if(getBoard().positionExists(p) && isThereOpponentPiece(p)){
                mat[p.getRow()][p.getColumn()] = true;
            }
            
            //DIAGONAL DIREITA DO PEÃO
            p.setValues(position.getRow() + 1, position.getColumn() + 1);
            if(getBoard().positionExists(p) && isThereOpponentPiece(p)){
                mat[p.getRow()][p.getColumn()] = true;
            }
        }
        
        return mat;
    }
    
    @Override 
    public String toString (){
        return "P";
    }
    
}
