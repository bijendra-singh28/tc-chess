package com.solution.chessapp;
import java.util.ArrayList;
import java.util.List;

public class ChessSimulation {
	

    private static final int BOARD_SIZE = 8;

    public static void main(String[] args) {
        String piece = "King"; // Specify the chess piece: Pawn, King, or Queen
        String position = "D5"; // Starting position of the piece

        List<String> moves = getPieceMoves(piece, position);
        System.out.println("Output: " + moves);
    }

    public static List<String> getPieceMoves(String piece, String position) {
        List<String> moves = new ArrayList<>();
        int row = BOARD_SIZE - (position.charAt(1) - '0');
        int col = position.charAt(0) - 'A';

        switch (piece) {
            case "Pawn":
                if (row < BOARD_SIZE - 1) {
                    moves.add("" + position.charAt(0) + (char) ('1' + (BOARD_SIZE - row - 1)));
                }
                break;

            case "King":
                for (int i = -1; i <= 1; i++) {
                    for (int j = -1; j <= 1; j++) {
                        int newRow = row + i;
                        int newCol = col + j;
                        if (isValid(newRow, newCol)) {
                            moves.add("" + (char) ('A' + newCol) + (BOARD_SIZE - newRow));
                        }
                    }
                }
                moves.removeIf(s -> s.equals(position));
                break;

            case "Queen":
                // Similar to the previous QueenMoves implementation
                moves = getQueenMoves(row, col);
                moves.removeIf(s -> s.equals(position));
                break;

            default:
                System.out.println("Invalid chess piece");
        }
        
        return moves;
    }

    public static List<String> getQueenMoves(int row, int col) {
        List<String> moves = new ArrayList<>();

        // Horizontal and vertical movements
        for (int i = 0; i < BOARD_SIZE; i++) {
            if (i != col) {
                moves.add("" + (char) ('A' + i) + (BOARD_SIZE - row));
            }
            if (i != row) {
                moves.add("" + (char) ('A' + col) + (BOARD_SIZE - i));
            }
        }

        // Diagonal movements
        for (int i = -BOARD_SIZE; i < BOARD_SIZE; i++) {
            int newRow = row + i;
            int newCol = col + i;
            if (isValid(newRow, newCol)) {
                moves.add("" + (char) ('A' + newCol) + (BOARD_SIZE - newRow));
            }
            newCol = col - i;
            if (isValid(newRow, newCol)) {
                moves.add("" + (char) ('A' + newCol) + (BOARD_SIZE - newRow));
            }
        }

        return moves;
    }

    private static boolean isValid(int row, int col) {
        return row >= 0 && row < BOARD_SIZE && col >= 0 && col < BOARD_SIZE;
    }
}
