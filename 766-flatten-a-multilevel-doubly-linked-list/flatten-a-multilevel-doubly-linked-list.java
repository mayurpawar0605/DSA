/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
*/

class Solution {
    public Node flatten(Node head) {
        if(head == null){
            return head;
        }

        Node p = head;
        while(p != null){
            if(p.child == null){
                //p has no child -> move forward
                p = p.next;
            }else{
                //current node has child
                Node temp = p.child;
                while(temp.next != null){
                    temp = temp.next;
                }
                //link mainipulation 
                temp.next = p.next;
                if(p.next != null){
                    p.next.prev = temp;
                }
                p.next = p.child;
                p.child.prev = p;
                p.child = null;
            }
        }
        return head;
    }
}