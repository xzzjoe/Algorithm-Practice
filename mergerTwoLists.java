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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null){
            return list2;
        }
        else if (list2 == null){
            return list1;
        }
        if (list1.val > list2.val){
            list2.next = mergeTwoLists(list1, list2.next);
            return list2;
        }
        else {
            list1.nextl = mergeTwoLists(list1.next, list2);
            return list1;
        }
    }


    public ListNode mergeTwoLists2(ListNode list1, ListNode list2) {
        ListNode preHead = new ListNode(-1);
        ListNode iter = preHead;

        while (list1 != null && list2 != null){
            if (list1.val < list2.val){
                iter.next = list1;
                list1 = list1.next;
            }
            else{
                iter.next = list2;
                list2 = list2.next;
            }
            iter = iter.next;
        }
        iter.next = list1 == null ? list1 : list2;
        return preHead.next;
    }
}