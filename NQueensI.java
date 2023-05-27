import java.util.*;
class Solution {
    List<List<String>> solutions;
    int size;
    public List<List<String>> solveNQueens(int n) {
        size = n;
        solutions = new ArrayList<>();
        char[][] emptyBoard = new char[n][n];
        for (int i = 0; i < n; ++i){
            for (int j = 0; j < n; ++j){
                emptyBoard[i][j] = '.';
            }
        }
        backtrack(0, new HashSet<>(), new HashSet<>(), new HashSet<>(), emptyBoard);
        return solutions;

    }

    private List<String> createBoard (char[][] state){
        List <String> retList = new ArrayList<String>();
        for (int i = 0; i < size; ++i){
            retList.add(new String(state[i]));
        }
        return retList;
    }

    private void backtrack (int row, Set<Integer> cols, Set<Integer> diags, Set<Integer> antiDiags, char[][] state){
        if (row == size){
            solutions.add(createBoard(state));
            return;
        }
        for (int col = 0; col < size; ++col){
            int diag = row - col;
            int antiDiag = row + col;
            if (cols.contains(col) || antiDiags.contains(antiDiag) || diags.contains(diag)){
                continue;
            }
            cols.add(col);
            diags.add(diag);
            antiDiags.add(antiDiag);
            state[row][col] = 'Q';
            backtrack(row+1, cols, diags, antiDiags, state);
            cols.remove(col);
            diags.remove(diag);
            antiDiags.remove(antiDiag);
            state[row][col] = '.';
        }
    }
}