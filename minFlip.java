class Solution {
    public int minFlipsMonoIncr(String s) {
        int flipCounts = 0;
        int oneCounts = 0;
        for (int i = 0; i < s.length(); i++){
            char curr = s.charAt(i);
            if (curr == '0'){
                if (oneCounts == 0){
                    continue;
                }
                else{
                    flipCounts ++;
                }
            }
            else if (curr == '1') {
                oneCounts ++;
            }
            if (flipCounts > oneCounts){
                flipCounts = oneCounts;
            }
        }
        return flipCounts;
    }
}