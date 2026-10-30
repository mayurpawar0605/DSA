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

        // O(n*2)

        // ListNode temp = head;
        // int index = 0;
        // int size = 0;
        // while(temp != null){
        //     temp = temp.next;
        //     size ++;
        // }
        // int ans[] = new int[size];
        // temp = head;

        // while(temp != null){
        //     int curr = temp.val;
        //     ListNode temp1 = temp;

        //     while(temp1 != null){
        //         if(curr < temp1.val){
        //             ans[index] = temp1.val;
        //             break;
        //         }
        //         temp1 = temp1.next;
        //     }
        //     temp = temp.next;
        //     index++;
        // }
        // return ans;






        //optimize o(n) ans o(n)
        
        //list ko array mai convert karenge
        List<Integer> list = new ArrayList<>();

        ListNode temp = head;
        while(temp != null){
            list.add(temp.val);
            temp = temp.next;
        }
        int n = list.size();
        int[] ans = new int[n];

        Deque<Integer> st = new ArrayDeque<>();

        for(int i = 0; i < n; i++){
            //agar mera currentr element stack ke top se bada hai to ans mil gaya
            while(!st.isEmpty() && list.get(i) > list.get(st.peek())){
                ans[st.pop()] = list.get(i);
            }
            st.push(i);
        }
        return ans;


    }
}