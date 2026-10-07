class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(head == null || head.next == null || left == right){
            return head;
        }

        ListNode curr = head;
        ListNode prev = null;
        int i = 1;
        while(curr != null && i != left){
            prev = curr;
            curr = curr.next;
            i++;
        }
        ListNode pointerToStart = prev;
        ListNode start = curr;

        while(i != right + 1){
            //reverse
            ListNode forward = curr.next;
            curr.next = prev;
            prev = curr;
            curr = forward;
            i++;
        }
        start.next = curr;
        if(pointerToStart != null){
            pointerToStart.next = prev;
        }else{
            return prev;
        }

        return head;
    }
}