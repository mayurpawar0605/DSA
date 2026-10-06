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
    static ListNode reverse(ListNode head){
        ListNode prev = null;
        ListNode curr = head;

        while(curr != null){
            ListNode forward = curr.next;
            curr.next = prev;
            prev = curr;
            curr = forward;
        }
        return prev;
    }

    public ListNode doubleIt(ListNode head) {
        //reverse 
        head = reverse(head);

        //logic
        ListNode temp = head;

        int carry = 0;

        while(temp != null){

            int sum = (2*temp.val) + carry;
            temp.val = sum % 10;
            carry = sum / 10;
            
            if(temp.next == null && carry != 0){
                temp.next = new ListNode(carry);
                break;
            }

            temp = temp.next;
            
        }

        //reverse 
        head = reverse(head);

        return head;
    }
}