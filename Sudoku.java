package com.example.demo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Sudoku {

    int totalEmptyGrids = 0;
    Map<String, Integer> pointBoxMapping = new HashMap<>();
    Map<Integer, List<Point>> boxPointMapping = new HashMap<>();


    public static void main(String[] args) {
        Sudoku sudoku = new Sudoku();
//        int[][] input =
//            {
//                {3, 0, 6, 5, 0, 8, 4, 0, 0},
//                {5, 2, 0, 0, 0, 0, 0, 0, 0},
//                {0, 8, 7, 0, 0, 0, 0, 3, 1},
//                {0, 0, 3, 0, 1, 0, 0, 8, 0},
//                {9, 0, 0, 8, 6, 3, 0, 0, 5},
//                {0, 5, 0, 0, 9, 0, 6, 0, 0},
//                {1, 3, 0, 0, 0, 0, 2, 5, 0},
//                {0, 0, 0, 0, 0, 0, 0, 7, 4},
//                {0, 0, 5, 2, 0, 6, 3, 0, 0}
//            };

        int[][] input =
            {
                {0, 0, 0, 1, 0, 8, 7, 0, 0},
                {0, 0, 0, 0, 2, 6, 0, 1, 5},
                {0, 6, 0, 0, 4, 0, 0, 0, 0},
                {2, 0, 0, 0, 0, 9, 0, 5, 0},
                {5, 0, 7, 2, 0, 0, 0, 0, 6},
                {0, 0, 1, 0, 0, 0, 0, 8, 4},
                {7, 0, 2, 0, 9, 4, 0, 0, 0},
                {4, 0, 0, 5, 0, 0, 0, 7, 0},
                {0, 0, 0, 0, 7, 0, 0, 0, 9}
            };
        sudoku.solve(input);
    }


    private void solve(int[][] puzzle) {
        updateBoxesDetails();
     //   findEmptyGrids(puzzle);
        Point point = getEmptyGrid(puzzle);
        getResult(puzzle, point, 0);
    }



    private void getResult(int[][] puzzle, Point point, int numberOfFilledGrids) {


        if (point.x == -1 && point.y == -1) {
            printPuzzle(puzzle);
            return;
        }

        for (int i = 1; i <= 9; i++) {
            if (isValidValue(puzzle, point, i)) {

                puzzle[point.x][point.y] = i;
                numberOfFilledGrids = numberOfFilledGrids + 1;

                getResult(puzzle, getEmptyGrid(puzzle), numberOfFilledGrids);

                puzzle[point.x][point.y] = 0;
                numberOfFilledGrids = numberOfFilledGrids - 1;
            }
        }
    }

    private void printPuzzle(int[][] puzzle) {
        for (int i = 0; i < puzzle.length; i++) {
            for (int j = 0; j < puzzle[0].length; j++) {
                System.out.print(puzzle[i][j] + " | ");
            }
            System.out.println();
        }
    }

//    private void findEmptyGrids(int[][] puzzle) {
//        for (int i = 0; i < puzzle.length; i++) {
//            for (int j = 0; j < puzzle[0].length; j++) {
//                if (puzzle[i][j] == 0) {
//                    totalEmptyGrids++;
//                }
//            }
//        }
//    }

    private boolean isValidValue(int[][] puzzle, Point point, int value) {
        return point.rowValid(value, puzzle) && point.columnValid(value, puzzle) && point.boxValid(value, puzzle);
    }


    private Point getEmptyGrid(int[][] puzzle) {
        int rowLength = puzzle.length;
        int columnLength = puzzle[0].length;

        for (int i = 0; i < rowLength; i++) {
            for (int j = 0; j < columnLength; j++) {
                if (puzzle[i][j] == 0) {
                    return new Point(i, j);
                }
            }
        }
        return new Point(-1, -1); // Completed - can be Optimized
    }

    private void updateBoxesDetails() {

        for (int i = 0; i <= 8; i++) {
            for (int j = 0; j <= 8; j++) {
                if (i >= 0 && i <= 2 && j >= 0 && j <= 2) {
                    pointBoxMapping.put(i + "|" + j, 1);
                    update(1, new Point(i, j));
                }
                else if (i >= 0 && i <= 2 && j >= 3 && j <= 5) {
                    pointBoxMapping.put(i + "|" + j, 2);
                    update(2, new Point(i, j));

                }
                else if (i >= 0 && i <= 2 && j >= 6 && j <= 8) {
                    pointBoxMapping.put(i + "|" + j, 3);
                    update(3, new Point(i, j));

                }
                else if (i >= 3 && i <= 5 && j >= 0 && j <= 2) {
                    pointBoxMapping.put(i + "|" + j, 4);
                    update(4, new Point(i, j));

                }
                else if (i >= 3 && i <= 5 && j >= 3 && j <= 5) {
                    pointBoxMapping.put(i + "|" + j, 5);
                    update(5, new Point(i, j));

                }
                else if (i >= 3 && i <= 5 && j >= 6 && j <= 8) {
                    pointBoxMapping.put(i + "|" + j, 6);
                    update(6, new Point(i, j));

                }
                else if (i >= 6 && i <= 8 && j >= 0 && j <= 2) {
                    pointBoxMapping.put(i + "|" + j, 7);
                    update(7, new Point(i, j));

                }
                else if (i >= 6 && i <= 8 && j >= 3 && j <= 5) {
                    pointBoxMapping.put(i + "|" + j, 8);
                    update(8, new Point(i, j));

                }
                else if (i >= 6 && i <= 8 && j >= 6 && j <= 8) {
                    pointBoxMapping.put(i + "|" + j, 9);
                    update(9, new Point(i, j));
                }
            }
        }

    }

    private void update(int box, Point point) {
        if (boxPointMapping.containsKey(box)) {
            boxPointMapping.get(box).add(point);
        }
        else {
            List<Point> xx = new ArrayList<>();
            xx.add(point);
            boxPointMapping.put(box, xx);
        }
    }

    private class Point {
        int x;
        int y;
        int box;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
            if(x != -1 && y != -1) {
                this.box = pointBoxMapping.get(x + "|" + y);
            }
        }


        public boolean rowValid(int value, int[][] puzzle) {
            for (int i = 0; i < 9; i++) {
                if (puzzle[x][i] == value) {
                    return false;
                }
            }
            return true;
        }

        public boolean columnValid(int value, int[][] puzzle) {
            for (int i = 0; i < 9; i++) {
                if (puzzle[i][y] == value) {
                    return false;
                }
            }
            return true;
        }

        public boolean boxValid(int value, int[][] puzzle) {
            for (Point point : boxPointMapping.get(this.box)) {
                if (puzzle[point.x][point.y] == value) {
                    return false;
                }
            }
            return true;
        }
    }
}
