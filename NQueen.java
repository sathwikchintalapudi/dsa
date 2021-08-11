package com.example.demo;

public class NQueen {

    int result = 0;

    public static void main(String[] args) {
        NQueen nQueen = new NQueen();
        nQueen.getResult(5);
        System.out.println("Number of ways in which queens can be arranged " + nQueen.result);
    }

    private void getResult(int n) {
        boolean[][] chessBoard = new boolean[n][n];
        getR(chessBoard, 0);
    }

    private void getR(boolean[][] chessBoard, int currentRow) {

        if (currentRow == chessBoard.length) {
            result++;
            printChessBoard(chessBoard);
            return;
        }

     //   for (int i = currentRow; i < chessBoard.length; i++) {
            for (int j = 0; j < chessBoard.length; j++) {
                if (isQueenSafe(chessBoard, currentRow, j)) {
                    chessBoard[currentRow][j] = true;
                    getR(chessBoard, currentRow + 1);
                    chessBoard[currentRow][j] = false;
                }
            }
      //  }
    }

    private void printChessBoard(boolean[][] chessBoard) {

        for(int row = 0; row < chessBoard.length; row++) {
            for(int column = 0; column < chessBoard[row].length; column++) {
                if(chessBoard[row][column]) {
                    System.out.print("Q ");
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

    private boolean isQueenSafe(boolean[][] chessBoard, int row, int column) {
        // Check for Same row
        for (int k = 0; k < chessBoard.length; k++) {
            if (chessBoard[row][k]) {
                return false;
            }
        }

        // Check for Same column
        for (int y = 0; y < chessBoard.length; y++) {
            if (chessBoard[y][column]) {
                return false;
            }
        }

        // Check for right diagonal - up
        for (int z1 = row - 1, z2 = column + 1; z1 >= 0 && z2 < chessBoard.length; z1--, z2++) {
            if (chessBoard[z1][z2]) {
                return false;
            }
        }

        // Check for left diagonal - up
        for (int z1 = row - 1, z2 = column - 1; z1 >= 0 && z2 >= 0; z1--, z2--) {
            if (chessBoard[z1][z2]) {
                return false;
            }
        }

        return true;
    }

}
