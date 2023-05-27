import java.util.*;
class Solution {
    List <String> retList = new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        String curr = "(";
        Stack<String> stack = new Stack<String>();
        stack.push(")");
        backtrack(n-1, stack, curr);
    }
    
    public void backtrack (int n, Stack<String> stack, String curr){
        if (n == 0){
            while(!stack.isEmpty()){
                curr += stack.pop();
            }
            retList.add(curr);
            return;
        }
        for (int i = n; n >= 0; i--){
            curr += "(";
            stack.push(")");
            -

        }
    }
}