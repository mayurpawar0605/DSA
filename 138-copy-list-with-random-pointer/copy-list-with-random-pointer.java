/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if(head == null){
            return head;
        }

        //step 1 : clone nodes add
        Node temp = head;
        while(temp != null){
            Node cloneNode = new Node(temp.val);
            cloneNode.next = temp.next;
            temp.next = cloneNode;
            temp = cloneNode.next;
        }

        //copy Random pointers
        temp = head;

        while(temp != null){
            Node oldNode = temp;
            Node newNode = temp.next;

            //observations : newNode random = oldnode random . next
            if(oldNode.random != null){
                newNode.random = oldNode.random.next;
            }

            temp = newNode.next;
        }


        //step 3 : detach old and new Lists
        temp = head;
        Node newHead = temp.next;

        while(temp != null){
            Node oldNode = temp;
            Node newNode =  temp.next;

            temp.next = newNode.next;
            if(newNode.next != null){
                newNode.next = newNode.next.next;
            }

            temp = temp.next;
        }

        return newHead;

    }
}