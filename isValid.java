import java.util.HashMap;

import java.util.*;
class Solution {
    
    public boolean isValid(String s) {
        Map <Character, Character> ref = new HashMap <>();  
        ref.put('(', ')');
        ref.put('[', ']');
        ref.put('{', '}');
        
        int n = s.length();
        Stack<Character> stack = new Stack<Character>();

        for (int i = 0; i < n; i++){
            char curr = s.charAt(i);
            if (ref.containsKey(curr)){
                stack.push(curr);
            }
            else if (ref.containsValue(curr)){
                if (stack.empty()){
                    return false;
                }
                char top = stack.pop();
                if (ref.get(top) == curr){
                    continue;
                }
                else{
                    return false;
                }
            }
        }
        return stack.empty() ? true : false;
    }
}