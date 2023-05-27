import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int distance = 1;
        if(grid[0][0] == 1 || grid[row-1][col-1] == 1){
            return -1;
        }
        List<int[]> currentLayer = new ArrayList<>();
        List<int[]> nextLayer = new ArrayList<>();
        currentLayer.add(new int[] {0,0});
        boolean[][] seen = new boolean[row][col];
        for (boolean[] iter : seen){
            Arrays.fill (iter,false);
        }
        seen[0][0] = true; 
        int[][] offsets = new int[][] {{-1,-1},{-1,0},{-1,1},{0,1},{1,1},{1,0},{1,-1},{0,-1}};
        while (!currentLayer.isEmpty()){
            for (int[] currPos : currentLayer){
                int xPos = currPos[0];
                int yPos = currPos[1];
                if (xPos == row -1 && yPos == col -1){
                    return distance;
                }
                for (int[]offset : offsets){
                    int offsetX = offset[0];
                    int offsetY = offset[1];
                    int newX = xPos + offsetX;
                    int newY = yPos + offsetY;
                    if (newX < 0 || newX >= row || newY < 0 || newY >= col || grid[newX][newY] == 1){
                        continue;
                    }
                    if (newX == row - 1 && newY == col -1){
                        distance ++;
                        return distance;
                    }
                    if (!seen[newX][newY]){
                        nextLayer.add(new int[] {newX,newY});
                        seen[newX][newY] = true;
                    }
                }        
            }
            currentLayer = nextLayer;
            nextLayer = new ArrayList<int[]>();
            distance ++;
        }
        return -1;

        
    }
}