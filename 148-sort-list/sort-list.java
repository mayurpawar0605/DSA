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
    //tortoise and hare algo
    static ListNode findMid(ListNode head){
        ListNode fast = head.next; // mistake chances
        ListNode slow = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast= fast.next.next;
        }
        return slow;
    }

    //merge two sorted LL
    static ListNode merge(ListNode left,ListNode right){
        if(left == null){
            return right;
        }
        if(right == null){
            return left;
        }

        ListNode dummy = new ListNode(0);
        ListNode temp = dummy;

        while(left != null && right != null){
            if(left.val < right.val){
                temp.next = left;
                temp = temp.next;
                left = left.next;
            }else{
                temp.next = right;
                temp = temp.next;
                right = right.next;
            }
        }
        while(left != null){
            temp.next = left;
            temp = temp.next;
            left = left.next;
        }
        while(right != null){
            temp.next = right;
            temp = temp.next;
            right = right.next;
        }

        return dummy.next;
    }
    

    //sort using recursion
    public ListNode sortList(ListNode head) {

        //return when you get singlt node or empty list
        if(head == null || head.next == null){
            return head;
        }

        //fing mid ans seperate two halves
        ListNode mid = findMid(head);
        ListNode left = head;
        ListNode right = mid.next;
        //seperation
        mid.next = null;

        //sort left and rigth halves  using recursion
        left = sortList(left);
        right = sortList(right);

        //merge both soeted halves -> return head of merge halves
        ListNode result = merge(left,right);
        return result;
    }
}