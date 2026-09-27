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


    public ListNode oddEvenList(ListNode head) {

        /*

        //check for empty list , 1 Node , 2 Node 
        if(head == null || head.next == null || head.next.next == null){
            return head;
        }

        //Pointers
        ListNode oddHead = head;
        ListNode oddTail = head;
        ListNode evenHead = head.next;
        ListNode evenTail = head.next;

        //chances of mistake in condition 
        // evenTail ka next null nahi hona chahiye
        while(evenTail != null && evenTail.next != null){
            oddTail.next = evenTail.next;
            oddTail = evenTail.next;

            evenTail.next = oddTail.next;
            evenTail = oddTail.next;
        }
        //connect both odd and even lists 
        //odd first even later
        oddTail.next = evenHead;
        return oddHead;

        */

        ListNode newHead = null;
        ListNode newTail = null;

        ListNode temp = head;
        int pos = 1;

        while(temp != null){
            if(pos % 2 != 0){
                if(newHead == null){
                    ListNode newNode = new ListNode(temp.val);
                    newHead = newNode;
                    newTail = newNode;
                }else{
                    ListNode newNode = new ListNode(temp.val);
                    newTail.next = newNode;
                    newTail = newTail.next;
                }
            }
            temp = temp.next;
            pos++;
        }

        temp = head;
        pos = 1;
        while(temp != null){
            if(pos % 2 == 0){ 
                ListNode newNode = new ListNode(temp.val);
                newTail.next = newNode;
                newTail = newTail.next;    
            }
            temp = temp.next;
            pos++;
        }

        return newHead;
    }
}