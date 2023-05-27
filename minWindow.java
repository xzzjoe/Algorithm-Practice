import java.util.HashMap;


class Solution {
    public String minWindow(String s, String t) {
        int sLen = s.length();
        int tLen = t.length();
        if (tLen > sLen){
            return "";
        }
        HashMap<Character, Integer> tMap = new HashMap<>();
        for (int i = 0; i < tLen; i++){
            tMap.put(t.charAt(i), tMap.getOrDefault(t.charAt(i), 0)+1);
        }
        HashMap<Integer, String> validSub = new HashMap<>();
        int globalMin = Integer.MAX_VALUE;
        for (int i = 0; i <= sLen - tLen; i++){
            if(tMap.containsKey(s.charAt(i))){
                HashMap<Character, Integer> sMap = new HashMap<>();
                for (int j = i; j < sLen; j++){
                    sMap.put(s.charAt(j), sMap.getOrDefault(s.charAt(j),0)+1);
                    if (containAll(tMap, sMap)){
                        String valid = s.substring(i, j+1);
                        int winLen = j-i+1;
                        globalMin = Math.min(globalMin, winLen);
                        validSub.put(winLen, valid);
                        break;
                    }
                }
            }
        }
        if (validSub.containsKey(globalMin)){
            return validSub.get(globalMin);
        }
        else {
            return "";
        }
    }


    private boolean containAll(HashMap<Character, Integer> tMap, HashMap <Character, Integer> sMap){
        for (char key : tMap.keySet()){
            if (!sMap.containsKey(key) || sMap.get(key) < tMap.get(key)){
                return false;
            }
        }
        return true;
    }
}