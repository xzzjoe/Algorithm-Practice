class Solution {
    public int strStr(String haystack, String needle) {
        if (haystack.length() == 0){
            return -1;
        }
        int n = haystack.length();
        int needleLen = needle.length();
        for (int i = 0; i < n; ++i){
            if (haystack.charAt(i) == needle.charAt(0) && (i + needleLen <= n)){
                for (int j = 0; j < needleLen; ++j){
                    if (j == needleLen - 1 && haystack.charAt(i+j) == needle.charAt(j)){
                        return i;
                    }
                    if (haystack.charAt(i+j) != needle.charAt(j)){
                        break;
                    }
                }
            }
        }
        return - 1;
        
    }
}