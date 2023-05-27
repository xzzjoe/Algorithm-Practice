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

public class Solution {
    public boolean isPalindrome(ListNode head){
        if (head == null) return false;
        ListNode endFirstHalf = firstHalfEnd(head);
        ListNode startSecondHalf = reverseListNode(endFirstHalf.next);

        ListNode p1 = head;
        ListNode p2 = startSecondHalf;
        while (p1 != null && p2 != null ){
            if (p1.val == p2.val){
                p1 = p1.next;
                p2 = p2.next;
            }
            else{
                endFirstHalf.next = reverseListNode(startSecondHalf);
                return false;
            }
        }
        return true;
        
    }

    public ListNode reverseListNode (ListNode head){
        if (head == null || head.next == null){
            return head;
        }
        ListNode newHead = reverseListNode(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }

    private ListNode firstHalfEnd (ListNode head){
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next !=null && fast.next.next != null){
            fast = fast.next.next;
            slow = slow.next; 
        }
        return slow;
    }
    
}
