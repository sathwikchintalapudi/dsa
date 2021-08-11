package com.example.demo;

public class KinghtsTourNumber {


    int[] rowChange = {1, -1, -2, -2, 1, -1, 2, 2};
    int[] columnChange = {2, 2, 1, 1, -2, -2, 1, -1};
    int ride = 0;

    public static void main(String[] args) {
        KinghtsTourNumber knightsTour = new KinghtsTourNumber();
        knightsTour.getResult(5);
    }

    private void getResult(int n) {
        int[][] chessBoard = new int[n][n];

        getR(chessBoard, 0, 0, 0);
    }

    private void getR(int[][] chessBoard, int row, int column, int ride) {

        if(ride == chessBoard.length * chessBoard[1].length) {
            printChessBoard(chessBoard);
            return;
        }

        if (isValidMove(chessBoard, row, column)) {
            chessBoard[row][column] = ride + 1;
            for(int i = 0; i < 8; i++) {
                getR(chessBoard, row + rowChange[i], column + columnChange[i], ride + 1);
            }
            chessBoard[row][column] = 0;
        }
    }

    private boolean isValidMove(int[][] chessBoard, int row, int column) {
        if(row < 0 || row >= chessBoard.length || column < 0 || column >= chessBoard.length || chessBoard[row][column] != 0) {
            return false;
        }
        return true;
    }

    private void printChessBoard(int[][] chessBoard) {
        for(int i = 0; i < chessBoard.length; i++) {
            for(int j = 0; j < chessBoard[i].length; j++) {
                System.out.print(chessBoard[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
        System.out.println();
    }

}
