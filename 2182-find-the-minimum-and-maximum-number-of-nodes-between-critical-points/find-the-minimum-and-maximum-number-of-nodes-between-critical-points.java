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
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        if(head == null){
            return new int [] {-1,-1};
        }
        ListNode prev = head;
        ListNode curr = head.next;
        int index = 1;
        List<Integer> list = new ArrayList<>();

        while(curr != null && curr.next != null){
            //compare for local maxima
            if(curr.val > prev.val && curr.val > curr.next.val){
                list.add(index);
            }
            if(curr.val < prev.val && curr.val < curr.next.val){
                list.add(index);
            }
            prev = prev.next;
            curr = curr.next;
            index++;
        }
        if(list.size() < 2){
            return new int [] {-1,-1};
        }

        //critical points list ready
        int minDistance = Integer.MAX_VALUE;
        int maxDistance = Integer.MIN_VALUE;

        for(int i = 1 ; i < list.size(); i++){
            minDistance = Math.min(list.get(i) - list.get(i-1) , minDistance);
        }
        maxDistance = list.get(list.size() -1) - list.get(0);

        return new int[] {minDistance,maxDistance};
    }
}