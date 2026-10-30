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
    public int[] nextLargerNodes(ListNode head) {
        ListNode temp = head;
        int index = 0;
        int size = 0;
        while(temp != null){
            temp = temp.next;
            size ++;
        }
        int ans[] = new int[size];
        temp = head;

        while(temp != null){
            int curr = temp.val;
            ListNode temp1 = temp;

            while(temp1 != null){
                if(curr < temp1.val){
                    ans[index] = temp1.val;
                    break;
                }
                temp1 = temp1.next;
            }
            temp = temp.next;
            index++;
        }
        return ans;
    }
}