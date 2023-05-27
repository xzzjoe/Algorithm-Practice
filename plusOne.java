class Solution {
    public int[] plusOne(int[] digits) {
        int n = digits.length;
        int[] retArray = new int[n+1];


        for (int i = n-1; i>= 0; i --){
            if (digits[i] != 9){
                digits[i] ++;
                return digits;
            }
            else {
                digits[i] = 0;
            }
        }

        retArray[0] = 1;
        return retArray;
        
    }
}