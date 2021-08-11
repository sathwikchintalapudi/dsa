package com.example.demo;

public class RateAndMazeProblem {

    int result = 0;

    public static void main(String[] args) {
        RateAndMazeProblem rateAndMazeProblem = new RateAndMazeProblem();
        int[][] m = {{1, 1, 0, 0},
            {1, 1, 0, 1},
            {1, 1, 0, 0},
            {0, 1, 1, 1}};
        rateAndMazeProblem.getResult(m, 4);
    }

    public void getResult(int[][] m, int n) {

        calculateDirection(m, 0, 0, n);
        System.out.println(result);

    }

    private void calculateDirection(int[][] maze, int currentx, int currenty, int size) {
        int[] xaxis = {1, 0, -1, 0};
        int[] yaxis = {0, -1, 0, 1};

        // final destination reached
        if((currentx == size - 1) && (currenty == size - 1)) {
            result++;
            return;
        }

        // move in all 4 directions - apply DFS
        for(int i = 0; i < 4; i++) {
            if(isValidStep(maze, currentx + xaxis[i], currenty + yaxis[i])) {
                maze[currentx][currenty] = 0;
                calculateDirection(maze, currentx + xaxis[i], currenty + yaxis[i], size);
                maze[currentx][currenty] = 1;
            }
        }

    }

    // validate the next available move for the rat
    private boolean isValidStep(int[][] maze,  int xNextMove, int yNextMove) {
        if((xNextMove < maze.length && xNextMove >= 0 && yNextMove >= 0 && yNextMove < maze.length) && maze[xNextMove][yNextMove] == 1) {
            return true;
        }
        return false;
    }
}
