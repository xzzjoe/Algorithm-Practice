class Solution{
    int[] globalNums;
    public boolean canSwap (int[] nums){
        globalNums = nums;
        int n = nums.length;
        boolean haveSwapped = false;
        for (int i = 0; i < n; ++i){
            if(globalNums[i] < globalNums[i+1]) continue;
            else{
                if (haveSwapped) return false;
                if (!swapHelper(i)) return false;
                haveSwapped = true;
            }
        }
        return true;
    }
    
    public boolean swapHelper(int currNumIndex){
        int currNum = globalNums[currNumIndex];
        String numStr = Integer.toString(currNum);
        char[] charArr = numStr.toCharArray();
        int n = charArr.length;
        int next;
        int prev;
        if (currNumIndex == 0){
            next = globalNums[currNumIndex+1];
            prev = -1;
        }
        else {
            next = globalNums[currNumIndex+1];
            prev = globalNums[currNumIndex-1];
        }
        for (int i = 0; i < n; ++i){
            for (int j = 0; j< n ; ++j){
                if (i == j){
                    continue;
                }
                char[] modifiedArr = charArr;
                modifiedArr[i] = charArr[j];
                modifiedArr[j] = charArr[i];
                int modifiedInt = Integer.parseInt(String.valueOf(modifiedArr));
                if (modifiedInt > prev && modifiedInt < next){
                    globalNums[currNumIndex] = modifiedInt;
                    return true;
                }
            }
        }
        return false;
    }
}