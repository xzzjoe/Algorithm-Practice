class MinStack {
    int global_min;
    stackNode head;
    

    class stackNode{
        int value;
        stackNode next;
        int min;


        public stackNode(int val){
            this.value = val;
        }
    }

    public MinStack() {
        this.global_min = Integer.MAX_VALUE;
    }
    
    public void push(int val) {
        stackNode newHead = new stackNode(val);
        if(global_min < val){
            newHead.min = global_min;
        }
        else{
            global_min = val;
            newHead.min = val;
        }
        stackNode temp = this.head;
        this.head = newHead;
        newHead.next = temp;
    }
    
    public void pop() {
        stackNode newHead = this.head.next;
        if (this.head.value == global_min && newHead != null){
            global_min = newHead.min;
        }
        else if (newHead == null){
            global_min = Integer.MAX_VALUE;
        }
        this.head = newHead;
    }
    
    public int top() {
        return this.head.value;
    }
    
    public int getMin() {
        return global_min;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */