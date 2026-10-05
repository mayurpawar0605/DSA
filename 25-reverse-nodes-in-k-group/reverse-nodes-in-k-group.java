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
    public ListNode reverseKGroup(ListNode head, int k) {
        int len = 0;
        ListNode temp = head;
        while(temp != null){
            temp = temp.next;
            len++;
        }
        if(len < k){
            return head;
        }

        ListNode prev = null;
        ListNode curr = head;

        for(int i =1 ; i <= k; i++){
            ListNode forward = curr.next;
            curr.next = prev;
            prev = curr;
            curr = forward;
        }

        // remaining list ko recursion se solcvce kro
        ListNode recursionHead = reverseKGroup(curr,k);
        
        head.next = recursionHead;

        //Linked List reversed
        return prev;

    }
}