import java.util.Stack;
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    ListNode mid;
    public void reorderList(ListNode head) {
        Stack<ListNode> secondHalf = new Stack<>();
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null || fast.next.next != null ){
            slow = slow.next;
            fast = fast.next.next;
        }
        mid = slow;
        slow = slow.next;
        mid.next = null; 
        while (slow.next != null){
            secondHalf.add(slow);
            slow = slow.next;
        }
        ListNode dummy = new ListNode();
        dummy.next = recursion(head, secondHalf);
    }

    public ListNode recursion (ListNode curr, Stack<ListNode> secondHalf){
        if (curr == mid && secondHalf.isEmpty()){
            return curr;
        }
        if (curr == null){
            return null;
        }
        ListNode nextIter = curr.next;
        curr.next = secondHalf.pop();
        curr.next.next = recursion(nextIter, secondHalf);
        return curr;
    }

    }