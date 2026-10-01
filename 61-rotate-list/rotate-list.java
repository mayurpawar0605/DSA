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
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null){
            return head;
        }

        ListNode temp = head;
        int len = 1;
        while(temp.next != null){
            temp = temp.next;
            len++;
        }

        int m = k % len;

        if(k == 0){
            return head;
        }

        //make it circular
        temp.next = head;

        //break 
        for(int i = 1 ; i <= len - m - 1; i++){
            head = head.next;
        }
        ListNode forward = head.next;
        head.next = null;

        return forward;
    }
}