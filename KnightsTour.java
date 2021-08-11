package com.example.demo;

public class KnightsTour {

    int[] rowChange = {1, -1, -2, -2, 1, -1, 2, 2};
    int[] columnChange = {2, 2, 1, 1, -2, -2, 1, -1};
    int ride = 0;

    public static void main(String[] args) {
        KnightsTour knightsTour = new KnightsTour();
        knightsTour.getResult(5);
    }

    private void getResult(int n) {
        boolean[][] chessBoard = new boolean[n][n];

        getR(chessBoard, 0, 0, 0);
    }

    private void printChessBoard(boolean[][] chessBoard) {
        for(int i = 0; i < chessBoard.length; i++) {
            for(int j = 0; j < chessBoard[i].length; j++) {
                if(chessBoard[i][j]) {
                    System.out.print("K ");
                }
                else {
                    System.out.print(". ");
                }
            }
            System.out.println();
        }
        System.out.println();
        System.out.println();
    }

    private void getR(boolean[][] chessBoard, int row, int column, int ride) {
        if(ride == chessBoard.length * chessBoard[1].length) {
            printChessBoard(chessBoard);
            return;
        }
        if (isValidMove(chessBoard, row, column)) {
            ride++;
            chessBoard[row][column] = true;
            for(int i = 0; i < 8; i++) {
                getR(chessBoard, row + rowChange[i], column + columnChange[i], ride);
            }
            chessBoard[row][column] = false;
        }
    }

    private boolean isValidMove(boolean[][] chessBoard, int row, int column) {
        if(row < 0 || row >= chessBoard.length || column < 0 || column >= chessBoard.length || chessBoard[row][column]) {
            return false;
        }
        return true;
    }
}
