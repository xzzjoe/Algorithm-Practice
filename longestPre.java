class Solution {
    public String longestCommonPrefix(String[] strs) {
        String prefix = strs[0];
        int n = strs.length;

        for (int i = 1; i < n; i ++){
            while (strs[i].indexOf(prefix)!=0){
                prefix = prefix.substring(0, prefix.length()-1);
            }
            if (prefix.isEmpty()){
                return "";
            }
        }
        return prefix;
    }
}