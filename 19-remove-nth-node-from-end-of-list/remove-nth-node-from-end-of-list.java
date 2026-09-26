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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null || head.next == null){
            head = null;
            return head;
        }
        ListNode prev = head;
        ListNode curr = head;

        for(int i=1; i <= n; i++){
            curr = curr.next;
        }
        ListNode temp = prev;
        while(curr != null){
            curr = curr.next;
            temp = prev;
            prev= prev.next;
        }

        if(prev == head){
            head = head.next;
        }
        temp.next = prev.next;
        prev.next = null;

        return head;
    }
}