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
    public ListNode swapPairs(ListNode head) {
        
        if(head == null || head.next == null){
            return head;
        }
        ListNode dummy = new ListNode(-1);
        ListNode prev = dummy;
        prev.next = head;
    

        

        while(prev.next != null && prev.next.next != null){
            ListNode curr = prev.next;
            ListNode forward = curr.next;

            curr.next = forward.next;
            prev.next = forward;
            forward.next = curr;

            prev = curr;
        }

        return dummy.next;
    }
}