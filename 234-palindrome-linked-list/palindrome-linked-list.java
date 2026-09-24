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
    public ListNode getMidPoint(ListNode head){
        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }
    public ListNode reverseLL(ListNode head){
        ListNode prev = null;
        ListNode curr = head;

        while(curr != null){
            ListNode forward = curr.next;

            curr.next = prev;
            prev = curr;
            curr = forward;
        }
        //prev head ke upar hoga 
        //In reverse LL
        return prev;
    }
    public boolean isPalindrome(ListNode head) {

        if(head == null){
            return true;
        }
        if(head.next == null){
            return true;
        }

        
        //find mid of Linked List
        ListNode list2 = getMidPoint(head);

        //seperate L1 and L2 form  mid
        ListNode temp = head;
        while(temp.next != list2){
            temp = temp.next;
        }  
        temp.next = null;

        //reverse L2
        ListNode head2 = reverseLL(list2);

        //cpmpare L1 and L2 -> return true or false
        ListNode temp1 = head;
        ListNode temp2 = head2;

        while(temp1 != null && temp2 != null){
            if(temp1.val != temp2.val){
                return false;
            }
            temp1= temp1.next;
            temp2 = temp2.next;
        }
        return true;

    }
}