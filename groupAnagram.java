import java.util.*;

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        if(strs.length == 0) return new ArrayList<>();
        HashMap<String, List> ref = new HashMap<>();
        for(String s: strs){
            char[] cArray = s.toCharArray();
            Arrays.sort(cArray);
            String key = String.valueOf(cArray);
            if (!ref.containsKey(key)) ref.put(key, new ArrayList<String>());
            ref.get(key).add(s);
        }
        List<List<String>>retArray = new ArrayList(ref.values());
        return retArray;

    }
}