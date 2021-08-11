package com.example.demo;

import java.util.ArrayList;
import java.util.List;


public class RatAndMazePath {

    List<String> result = new ArrayList<>();

    public static void main(String[] args) {
        RatAndMazePath ratAndMazePath = new RatAndMazePath();
        int[][] m = {{1, 1, 0, 0},
            {1, 1, 0, 1},
            {1, 1, 0, 0},
            {0, 1, 1, 1}};
        ratAndMazePath.getResult(m, 4);
    }

    public void getResult(int[][] m, int n) {
        List<Character> currentPath = new ArrayList<>();
        calculateDirection(m, 0, 0, n, currentPath);
        System.out.println(result);

    }

    private void calculateDirection(int[][] maze, int currentx, int currenty, int size, List<Character> currentPath) {
        int[] xaxis = {1, 0, -1, 0};
        int[] yaxis = {0, -1, 0, 1};
        char[] direction = {'D','L','U','R'};

        // final destination reached
        if((currentx == size - 1) && (currenty == size - 1)) {
            String completedPath = formPath(currentPath);
            result.add(completedPath);
            return;
        }

        // move in all 4 directions - apply DFS
        for(int i = 0; i < 4; i++) {
            if(isValidStep(maze, currentx + xaxis[i], currenty + yaxis[i])) {
                // Block the current step
                maze[currentx][currenty] = 0;
                currentPath.add(direction[i]);

                calculateDirection(maze, currentx + xaxis[i], currenty + yaxis[i], size, currentPath);

                currentPath.remove(currentPath.size()-1);
                maze[currentx][currenty] = 1;
            }
        }

    }

    private String formPath(List<Character> currentPath) {
        StringBuffer name = new StringBuffer();
        for(Character x : currentPath) {
            name.append(x);
        }
        return name.toString();
    }

    // validate the next available move for the rat
    private boolean isValidStep(int[][] maze,  int xNextMove, int yNextMove) {
        if((xNextMove < maze.length && xNextMove >= 0 && yNextMove >= 0 && yNextMove < maze.length) && maze[xNextMove][yNextMove] == 1) {
            return true;
        }
        return false;
    }
}
