
//   Definition for singly-linked list.
private class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
 


class Solution {
public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    int num1 = 0;
    int mul1 = 1;
    do{
        num1 += l1.val * mul1;
        mul1 *= 10;
        l1 = l1.next;
    }while(Object.NonNull(l1.next));
    int num2 = 0;
    int mul2 = 1;
    do{
        num2 += l2.val * mul2;
        mul2 *= 10;
        l2 = l2.next;
    }while(Object.NonNull(l2.next));
    int sum = num1 + num2;
    ListNode currNode = new ListNode();
    ListNode headNode = currNode;
    do{
        currNode.val = sum % 10;
        sum /= 10;
        if (sum > 0){
            currNode.next = new ListNode();
            currNode = currNode.next;
        }
    }while(sum/10 != 0);
    return headNode;   
}    
}
