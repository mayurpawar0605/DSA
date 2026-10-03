/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        if(head == null){
            return null;
        }

        HashMap<ListNode,Boolean> map = new HashMap<>();
        ListNode temp = head;
        while(!map.containsKey(temp)){
            map.put(temp,true);
            temp = temp.next;
            if(temp == null){
                return null;
            }
        }
        return temp;
    }
}