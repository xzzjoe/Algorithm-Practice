import java.util.*;

class longestSub {
    public static void main(String[] args){
        String test = " ";
        int res = lengthOfLongestSubstring(test);
        System.out.print(res);
    }

    public static int lengthOfLongestSubstring(String s) {
        Map <Character, Integer> map = new HashMap<>();
        int n = s.length();
        int ans = 0;

        for (int j = 0, i = 0; j < n ; j++){
            char curr = s.charAt(j);
            if (map.containsKey(curr)){
                i = map.get(curr);
            }
            ans = Math.max(ans, j-i+1);
            map.put(curr, j);
        }
        return ans;
    }
}