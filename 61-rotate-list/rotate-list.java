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
        /*

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
        */

        if(head == null || head.next == null){
            return head;
        }
        
        ListNode temp = head;
        int n = 0;
        while(temp != null){
            temp = temp .next;
            n++;
        }
        
        k = k % n;
        if(k ==0) return head;

        temp = head;
        ListNode forward = head;
        for(int i = 1; i <= n; i++){
            if(i == n-k){
                //link break
                forward = temp.next;
                temp.next = null;
                temp = forward;
            }else if(i == n){
                //circular connection
                temp.next = head;
            }else{
                temp = temp.next;
            }
        }

        return forward;
    }
}