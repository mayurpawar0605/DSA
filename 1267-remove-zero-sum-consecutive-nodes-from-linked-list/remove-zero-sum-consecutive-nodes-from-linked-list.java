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
    public ListNode removeZeroSumSublists(ListNode head) {
        Map<Integer,ListNode> map = new HashMap<>();
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode temp = dummy;
        int ps = 0;
        while(temp != null){
            ps += temp.val;
            map.put(ps,temp);
            temp = temp.next;
        }

        temp = dummy;
        ps = 0;
        while(temp != null){
            ps += temp.val;
            temp.next = map.get(ps).next;
            temp = temp.next;
        }
        return dummy.next;
    }
}