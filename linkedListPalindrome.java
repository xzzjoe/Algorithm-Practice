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
    private ListNode frontNode;
    private boolean recursiveCheck(ListNode curr){
        if (curr != null){
            if (!recursiveCheck(curr)) return false;
            if (curr.val != frontNode.val) return false;
            frontNode = frontNode.next;
        }
        return false;
    }

    public boolean isPalindrome(ListNode head) {
        frontNode = head;
        return recursiveCheck(head);
    }
}