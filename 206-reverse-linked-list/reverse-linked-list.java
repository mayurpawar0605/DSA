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
    public ListNode solve(ListNode prev , ListNode curr){
        //base case
        if(curr == null){
            return prev;
        }

        //forward node 
        ListNode forward = curr.next;

        curr.next = prev;

        prev = curr;
        curr = forward;

        return solve(prev , curr);
    }
    public ListNode reverseList(ListNode head) {

        ListNode prev = null;
        ListNode curr = head;
        return solve(prev,curr);


        // ListNode prev = null;
        // ListNode curr = head;

        // while(curr != null){
        //     ListNode forward = curr.next;
            
        //     curr.next = prev;

        //     prev = curr;
        //     curr = forward;

        // }
        // head = prev;
        // return head;
    }
}