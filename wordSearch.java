class Solution {
    private int COL;
    private int ROW;
    private char[][] board;

    public boolean exist(char[][] board, String word) {
        this.ROW = board.length;
        this.COL = board[0].length; 
        this.board = board;

        for (int row = 0; row < this.ROW; row ++){
            for (int col = 0; col < this.COL; col ++){
                if(this.backtrack(word, row, col, 0)) return true;
            }
        }
        return false;
    }

    protected boolean backtrack (String word, int row, int col, int index){
        if (index >= word.length()){
            // base case
            return true;
        }
        if (row < 0 || row == this.ROW || col < 0 || col == this.COL || 
                this.board[row][col] != word.charAt(index)){
            return false;
        }
        this.board[row][col] = '#';
        int[] rowOffset = {1,0,-1,0};
        int[] colOffset = {0,1,0,-1};

        for (int d = 0; d < 4; d++){
            if (this.backtrack(word, row + rowOffset[d], col + colOffset[d], index+1)){
                return true;
            }
        }

        this.board[row][col] = word.charAt(index);
        return false;


    }
}