import java.util.*;

class Solution {
    private HashMap<String, Integer> wordCount = new HashMap<String, Integer> ();
    private int wordLen;
    private int substringLen;
    private int k; 
    public List<Integer> findSubstring(String s, String[] words) {
        wordLen = words[0].length();
        k = words.length;
        substringLen = wordLen * k;
        int n = s.length();
        for (String word : words){
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }
        List <Integer> indexAns = new ArrayList<>();
        for (int i = 0; i < n - substringLen + 1; i ++){
            if (check(s, i)){
                indexAns.add(i);
            }
        }
        return indexAns; 
    }
    

    public boolean check(String s, int index){
        HashMap <String,Integer> localCopy = new HashMap<String, Integer>(wordCount);
        int wordUsed = 0;
        for (int j = index; j < index + substringLen; j += wordLen ){
            String word = s.substring(j, j + wordLen);
            if (localCopy.getOrDefault(word, 0) != 0){
                localCopy.put(word, localCopy.get(word) - 1);
                wordUsed ++;
            }
            else{
                break;
            }
        }
        return wordUsed == k;

    }
}