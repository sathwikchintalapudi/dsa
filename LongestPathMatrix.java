package com.example.demo;

public class LongestPathMatrix {

    int[] row_movement = {1, 0, -1, 0};
    int[] column_movement = {0, 1, 0, -1};
    int loggestPath = -1;


    public static void main(String[] args) {
        int path[][] = {{1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
            {1, 1, 0, 1, 1, 0, 1, 1, 0, 1},
            {1, 1, 1, 1, 1, 1, 1, 1, 1, 1}};
        LongestPathMatrix longestPathMatrix = new LongestPathMatrix();
        System.out.println(longestPathMatrix.findLongestPath(path, 0, 0, 1, 7));
    }

    private int findLongestPath(int[][] path, int sourceRow, int sourceColumn, int destRow, int destColumn) {
        int count = 0;
        getResult(path, sourceRow, sourceColumn, destRow, destColumn, count);
        return loggestPath;
    }

    private void getResult(int[][] path, int sourceRow, int sourceColumn, int destRow, int destColumn, int count) {

        if (sourceRow == destRow && sourceColumn == destColumn) {
            if(loggestPath < count) {
                loggestPath = count;
            }
            return;
        }

        for (int i = 0; i < 4; i++) {
            if (isEligible(sourceRow + row_movement[i], sourceColumn + column_movement[i], path)) {
                path[sourceRow + row_movement[i]][sourceColumn + column_movement[i]] = -1;
                getResult(path, sourceRow + row_movement[i], sourceColumn + column_movement[i], destRow, destColumn, count + 1);
                path[sourceRow + row_movement[i]][sourceColumn + column_movement[i]] = 1;
            }
        }
    }

    private boolean isEligible(int nextRow, int nextColumn, int[][] path) {
        if (nextRow < 0 || nextColumn < 0 || nextRow >= path.length || nextColumn >= path[0].length || path[nextRow][nextColumn] == 0 || path[nextRow][nextColumn] == -1) {
            return false;
        }
        return true;
    }
}
