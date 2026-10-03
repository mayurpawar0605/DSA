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

        /*

        HashSet<ListNode> set = new HashSet<>();
        ListNode temp = head;
        while(!set.contains(temp)){
            set.add(temp);
            temp = temp.next;

            if(temp == null){
                return null;
            }   
        }
        return temp;
        */
        ListNode slow = head;
        ListNode fast = head;
        boolean hasCycle = false;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                //cycle present
                hasCycle = true;
                break;
            }
        }

        if(hasCycle == false){
            return null;
        }
        //cycle exists -> detect starting node
        // fast is on meeting point 
        slow = head;
        //x =  kz - y
        while(slow != fast){
            slow = slow.next;
            fast = fast.next;
        }
        
        return slow;
    }
}