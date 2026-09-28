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
    public ListNode mergeNodes(ListNode head) {
        ListNode write = head;
        ListNode read = head.next;

        while(read != null){
            int sum = 0;
            //calculate sum val tiil read not 0
            while(read.val != 0){
                sum += read.val;
                read = read.next;
            }
            //insert sum on write position
            write.val = sum;
            //delete unnecessay nodes;
            write.next = read.next;
            //move read and write one step
            read = read.next;
            write = write.next;
        }
        return head;
    }
}