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
        /*
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode prev = dummy ;
        ListNode curr = dummy.next;

        while(curr != null){
            if(curr.val == val){
                prev.next = curr.next;
                curr = curr.next;
            }else{
                prev = prev.next;
                curr = curr.next;
            }
            
        }
        return dummy.next;
        */

        ListNode dummy = new ListNode(-1);
        ListNode tail = dummy;

        ListNode temp = head;
        while(temp != null){
            if(temp.val != val){
                tail.next = temp;
                tail= temp;
                temp = temp.next;
                tail.next = null;
            }
            else{
                temp = temp.next;
            }
            
        }
        return dummy.next;
    }
}