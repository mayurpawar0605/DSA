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
    public ListNode[] splitListToParts(ListNode head, int k) {
        ListNode temp = head;
        int n = 0;
        while(temp != null){
            temp = temp.next;
            n ++;
        }

        int baseSize = n / k;
        int extraNode = n % k;

        ListNode curr = head;
        ListNode prev = null;

        ListNode[] ans = new ListNode[k];
        
        int index = 0;

        while(curr != null){
            ans[index] = curr;
            index ++;

            int width = baseSize;
            if(extraNode > 0){
                width += 1;
                extraNode --;
            }
            for(int i = 1 ; i <= width; i++){
                prev = curr;
                curr = curr.next;
            }
            
            prev.next = null;
        }
        return ans;
    }
}