package com.example.demo;


import java.time.LocalDateTime;

public class LandMines {

    int shortestDistance = Integer.MAX_VALUE;

    int[] row_axis = new int[]{1, 0, -1, 0};
    int[] column_axis = new int[]{0, 1, 0, -1};

    public static void main(String[] args) {
        int[][] input = {
            {1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
            {1, 0, 1, 1, 1, 1, 1, 1, 1, 1},
            {1, 1, 1, 0, 1, 1, 1, 1, 1, 1},
            {1, 1, 1, 1, 0, 1, 1, 1, 1, 1},
            {1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
            {1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
            {1, 0, 1, 1, 1, 1, 1, 1, 0, 1},
            {1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
            {1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
            {0, 1, 1, 1, 1, 0, 1, 1, 1, 1},
            {1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
            {1, 1, 1, 0, 1, 1, 1, 1, 1, 1}
        };
        LandMines landMines = new LandMines();
        landMines.updateRiskArea(input);
        long initial = java.lang.System.currentTimeMillis();
        landMines.findShortestPath(input);
        System.out.println(java.lang.System.currentTimeMillis() - initial);
        if (landMines.shortestDistance == Integer.MAX_VALUE) {
            System.out.println("There is not path to the destination");
        }
        else {
            System.out.println(landMines.shortestDistance);
        }
    }

    private void updateRiskArea(int[][] input) {
        for (int i = 0; i < input.length; i++) {
            for (int j = 0; j < input[0].length; j++) {
                if (input[i][j] == 0) {
                    for (int k = 0; k < 4; k++) {
                        if (!(i + row_axis[k] < 0 || i + row_axis[k] >= input.length || j + column_axis[k] < 0 || j + column_axis[k] >= input[0].length)) {
                            input[i + row_axis[k]][j + column_axis[k]] = 2;
                        }
                    }
                }
            }
        }
        printUpdated(input);
    }

    private void printUpdated(int[][] input) {
        for (int i = 0; i < input.length; i++) {
            for (int j = 0; j < input[0].length; j++) {
                System.out.print(input[i][j] + " ");
            }
            System.out.println();
        }
    }

    private void findShortestPath(int[][] input) {
        for (int i = 0; i < input[0].length; i++) {
            if (isSafePosition(input, 0, i)) {
                input[0][i] = 5;
                getResult(input, 0, i, 0);
                input[0][i] = 1;
            }
        }
    }

    private void getResult(int[][] input, int currentRow, int currentColumn, int distanceTravelled) {

        if (currentRow == input.length - 1) {
            if (shortestDistance > distanceTravelled) {
                shortestDistance = distanceTravelled;
                printUpdated(input);
                System.out.println();
            }
            return;
        }

        for (int i = 0; i < 4; i++) {
            int newRow = currentRow + row_axis[i];
            int newColumn = currentColumn + column_axis[i];
            if (isSafePosition(input, newRow, newColumn) && distanceTravelled < shortestDistance) {
                input[newRow][newColumn] = 5;
                getResult(input, newRow, newColumn, distanceTravelled + 1);
                input[newRow][newColumn] = 1;
            }
        }
    }

    private boolean isSafePosition(int[][] input, int newRow, int newColumn) {
        if (newRow < 0 || newRow >= input.length || newColumn >= input[0].length || newColumn < 0 || input[newRow][newColumn] == 0 || input[newRow][newColumn] == 2 || input[newRow][newColumn] == 5) {
            return false;
        }
        return true;
    }
}
