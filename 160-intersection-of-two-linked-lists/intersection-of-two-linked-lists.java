/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        /*
        if(headA == null || headB == null){
            return null;
        }

        ListNode a = headA;
        ListNode b = headB;
        while(a != null &&  b != null){
            if(a == b){
                return a;
            }
            a = a.next;
            b = b.next;
        }
        if(a == null && b == null){
            return null;
        }

        int extraLenA = 0;
        while(a != null){
            a = a.next;
            extraLenA ++;
        }
        int extraLenB = 0;
        while(b != null){
            b = b.next;
            extraLenB ++;
        }

        if(extraLenA != 0){
            a = headA;
            b = headB;
            for(int i = 1; i <= extraLenA; i++){
                a = a.next;
            }
            while(a != null &&  b != null){
                if(a == b){
                return a;
                }
                a = a.next;
                b = b.next;
            }
        }else{
            a = headA;
            b = headB;
            for(int i = 1; i <= extraLenB; i++){
                b = b.next;
            }
            while(a != null &&  b != null){
                if(a == b){
                return a;
                }
                a = a.next;
                b = b.next;
            }
        }
        return null;

        */

        if(headA == null || headB == null){
            return null;
        }
        ListNode a = headA;
        ListNode b = headB;

        while(a != null && b != null){
            a = a.next;
            b = b.next;
        }

        if(a == null){
            //b bada hai ya equal hai
            int bExtraLen = 0;
            while(b != null){
                b = b.next;
                bExtraLen++;
            }
            while(bExtraLen-- > 0){
                headB = headB.next;
            }
        }else{
            //b == null
            // a bada hai ya equal hai;
            int aExtraLen = 0;
            while(a != null){
                aExtraLen++;
                a = a.next;
            }
            while(aExtraLen-- > 0){
                headA = headA.next;
            }

        }

        a = headA;
        b = headB;
        while(a != null && b != null){
            if(a == b){
                return a;
            }
            a = a.next;
            b = b.next;
        }
        return null;
    }
}