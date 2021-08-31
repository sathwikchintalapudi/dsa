package com.example.demo;

import java.util.ArrayList;
import java.util.List;


public class PossiblePathsFromLeftToRight {
    int[] row_direction = {1, 0};
    int[] column_direction = {0, 1};
    List<Integer> result = new ArrayList<>();

    public static void main(String[] args) {
        PossiblePathsFromLeftToRight possiblePathsFromLeftToRight = new PossiblePathsFromLeftToRight();
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        possiblePathsFromLeftToRight.getPaths(matrix);
    }

    private void getPaths(int[][] matrix) {
        int numOfRows = matrix.length;
        int numOfColumns = matrix[0].length;
        result.add(matrix[0][0]);
        getResult(matrix, numOfRows, numOfColumns, 0, 0);
    }

    private void getResult(int[][] matrix, int numOfRows, int numOfColumns, int currentRow, int currentColumn) {
        if (currentRow == numOfRows - 1 && currentColumn == numOfColumns - 1) {
            System.out.println(result);
            return;
        }

        for (int i = 0; i < 2; i++) {
            // Check if next step is valid
            int nextRow = currentRow + row_direction[i];
            int nextColumn = currentColumn + column_direction[i];
            if (isEligibleMove(nextRow, nextColumn, numOfRows, numOfColumns, matrix)) {
                int temp = matrix[nextRow][nextColumn];
                result.add(temp);
                matrix[nextRow][nextColumn] = -1;
                getResult(matrix, numOfRows, numOfColumns, currentRow + row_direction[i], currentColumn + column_direction[i]);
                matrix[nextRow][nextColumn] = temp;
                result.remove(result.size() - 1);
            }
        }

    }

    private boolean isEligibleMove(int nextRow, int nextColumn, int numberOfRows, int numberOfColumns, int[][] matrix) {
        if (nextRow >= numberOfRows || nextColumn >= numberOfColumns || matrix[nextRow][nextColumn] == -1) {
            return false;
        }
        return true;
    }

}
