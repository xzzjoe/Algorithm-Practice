import java.util.*;
class BrowserHistory {
    Stack<String> forward;
    Stack<String> back;
    String curr;

    public BrowserHistory(String homepage) {
        curr = homepage;
        back = new Stack<String>();
        forward = new Stack<String>();
    }
    
    public void visit(String url) {
        back.push(curr);
        curr = url;
        forward.clear();
    }
    
    public String back(int steps) {
        int iter = steps;
        if(back.size() == 0){
            return curr;
        }
        if(back.size() < steps){
            iter = back.size();                                                                  
        }
        forward.push(curr);
        for (int i = 0; i < iter-1; i++){
            forward.push(back.pop());
        }
        curr = back.pop();
        return curr;
    }
    
    public String forward(int steps) {
        int iter = steps;
        if(forward.size() == 0){
            return curr;
        }
        if(forward.size() < steps){
            iter = forward.size();
        }
        back.push(curr);
        for (int i = 0; i < iter-1; i++){
            back.push(forward.pop());
        }
        curr = forward.pop();
        return curr;
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */