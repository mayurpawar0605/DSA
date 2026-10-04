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
    public ListNode partition(ListNode head, int x) {
        ListNode lessThanHead = new ListNode(-1);
        ListNode lessThanTail = lessThanHead;

        ListNode greaterThanHead = new ListNode(-1);
        ListNode greaterThanTail = greaterThanHead;

        ListNode temp = head;
        while(temp != null){
            ListNode nextNode = temp.next;
            if(temp.val < x){
                lessThanTail.next = temp;
                lessThanTail = temp;
                temp.next = null;
            }else{
                greaterThanTail.next = temp;
                greaterThanTail = temp;
                temp.next = null;
            }
            temp = nextNode;
        }
        //connection
        lessThanTail.next = greaterThanHead.next;

        return lessThanHead.next;
        
    }
}