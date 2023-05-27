    class Solution {
        public boolean searchMatrix(int[][] matrix, int target) {
            int m = matrix.length;
            int n = matrix[0].length;
            int targetArr = 0;

            for (int i = 0; i < m-1; i ++){
                if (target <= matrix[i][n-1] ){
                    // search at target arr
                    break;
                }
                else if (target > matrix[i][n-1] && i == m-1){
                    return false;
                }
                else if (target >= matrix[i+1][0]){
                    targetArr ++;

                }
                else if (target < matrix[i+1][0] && target > matrix[i][n-1]){
                    return false;
                }
            }
            int begin = 0;
            int end = n - 1;
            int mid = 0;
            while (begin <= end){
                mid = begin + (end - begin)/2;
                if (matrix[targetArr][mid] == target){
                    return true;
                }
                else if (matrix[targetArr][mid] < target){
                    begin = mid + 1;
                }
                else{
                    end = mid - 1;
                }
            }
            return false;
        }
    }