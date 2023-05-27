import java.util.*;
class Solution {
    private int size;
    public int totalNQueens(int n) {
        size = n;
        return backtrack(0, new HashSet<Integer>(), new HashSet<Integer>(), new HashSet<Integer>());
    }
    
    private int backtrack (int row, Set<Integer> cols, Set<Integer> diagonals, Set<Integer> antiDiags){
        if (row == size){
            return 1;
        }
        int solution = 0;

        for (int col = 0; col < size ; ++col){
            int diag = row - col;
            int antiDiag = row + col;
            if (cols.contains(col) || diagonals.contains(diag) || antiDiags.contains(antiDiag)){
                continue;
            }
            cols.add(col);
            diagonals.add(diag);
            antiDiags.add(antiDiag);
            solution += backtrack(row+1, cols, diagonals, antiDiags);
            cols.remove(col);
            diagonals.remove(diag);
            antiDiags.remove(antiDiag);
        }
        return solution;
       }
}