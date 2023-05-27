import java.util.*;
class Solution {
    int size;
    boolean solved;
    public void solveSudoku(char[][] board) {
        if (board == null || board.length == 0){
            return;
        }
        int h = board.length;
        size = h;
        solved = false;
        backtrack(board, 0, 0);
    }

    private void nextFill (char[][] board, int row, int col){
        if (row == size - 1 && col == size - 1){
            solved = true; 
            return;
        }
        if (col == size - 1){
            backtrack(board, row+1, 0);
        }
        else{
            backtrack(board, row, col+1);
        }
    }

    private void backtrack (char[][] board, int row, int col){
        if(board[row][col] == '.'){
            for (int iter = 1; iter <= 9; ++iter){
                char digit = Character.forDigit(iter, 10);
                if(canPlace(board, digit, row, col)){
                    board[row][col] = digit;
                    nextFill(board, row, col);
                    if(!solved){
                        board[row][col] = '.';
                    }
                    else{
                        return;
                    }
                }
            }
        }
        else nextFill(board, row, col);
    }

    private boolean canPlace (char[][] board, char c, int row, int col){
        // int currBox = (row/3)*3 + col/3;
        for (int i = 0; i < 9; i ++){
            if (board[row][i] == c) return false;
            if (board[i][col] == c) return false;
            if (board[(row/3)*3 + i/3][(col/3)*3 + i%3] == c) return false;
        }
        return true;

    }
}