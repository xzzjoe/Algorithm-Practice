class Solution {
    public void reverseString(char[] s) {
        int n = s.length;
        helper(s, 0, n-1);
    }

    public void helper (char[] s, int left, int right){
        if (left >= right){
            return;
        }
        helper(s, left+1, right-1);
        char temp = s[left];
        s[left] = s[right];
        s[right] = temp;
    }
}