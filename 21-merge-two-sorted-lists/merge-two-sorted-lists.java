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
        //created a dummy node
        ListNode dummy = new ListNode(-1);
        ListNode tail = dummy;

        while(list1 != null && list2 != null){
            //compairing values of list1 and list2
            //jo choti hogi uskko ansList mai add karenge
            if(list1.val < list2.val){
                tail.next = list1;
                list1 = list1.next;
            }else{
                tail.next = list2;
                list2 = list2.next;
            }
            tail = tail.next;
        }

        //if any of the list have nodes that are not added in ansList
        if(list1 != null){
            tail.next = list1;
        }
        if(list2 != null){
            tail.next = list2;
        }

        ListNode head = dummy.next;
        dummy.next = null;
        return head;
    }
}