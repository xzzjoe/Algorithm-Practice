import java.util.*;
class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int s1Len = s1.length();
        int s2Len = s2.length();
        if (s1Len > s2Len){
            return false;
        }
        HashMap <Character, Integer> s1Freq = new HashMap<>();
        for (int i = 0; i < s1Len; ++ i){
            s1Freq.put(s1.charAt(i), s1Freq.getOrDefault(s1.charAt(i),0)+1);
        }
        for (int j = 0; j <= s2Len - s1Len; ++j){
            // if (s1Freq.containsKey(s2.charAt(j))){
            HashMap<Character, Integer> s2Freq = new HashMap<>();
            for (int k = 0; k < s1Len; ++k){
                s2Freq.put(s2.charAt(j+k), s2Freq.getOrDefault(s2.charAt(j+k), 0)+1);
            }
            if (match(s1Freq, s2Freq)) return true; 
            // }
        }
        return false; 
    }

    private boolean match (HashMap<Character, Integer> map1, HashMap<Character, Integer> map2){
        for (char key1 : map1.keySet()){
            // Why does this not work? Long string test case.
            // if (map1.get(key1) == map2.getOrDefault(key1, -1))
            if (map1.get(key1) - map2.getOrDefault(key1, -1) != 0){
                return false;
            }
        }
        return true;
    }
}