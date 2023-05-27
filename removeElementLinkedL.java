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
    public ListNode removeElements(ListNode head, int val) {
        if (head == null) return head;
        ListNode pointer = head;
        ListNode prev = head;
        while (pointer != null){
            if(pointer == head){
                if (pointer.val == val){
                    head = pointer.next;
                }
                prev = pointer;
                pointer = pointer.next;
            }
            else{
                if (pointer.val == val){
                    prev.next = pointer.next;
                    pointer.next = null;
                    pointer = prev.next;
                }
                else {
                    prev = pointer;
                    pointer = pointer.next;
                }
            }
        }
        return head;
    }

    public ListNode recursivelyRemoveElements(ListNode head, int val){
        if (head == null) return head;
        head.next = recursivelyRemoveElements(head.next, val);
        return (head.val == val) ? head.next : head;
    }
}