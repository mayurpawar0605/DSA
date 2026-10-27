class MyHashSet {

    class Node {
        int data;
        Node next;

        Node(int data){
            this.data = data;
            this.next = null;
        }
    }

    public Node head = null;

    public MyHashSet() {
        this.head = null;
    }
    
    public void add(int key) {

        if (contains(key)) {
            return;
        }

        Node temp = head;
        Node newNode = new Node(key);

        if(head == null){
            head = newNode;
            return;
        }

         while (temp.next != null) {
            temp = temp.next;
        }
        
        temp.next = newNode;
    }
    
    public void remove(int key) {
        Node temp = head;
        Node prev = temp;
        while(temp != null){
            if(temp.data == key){
                if(temp == head){
                    //for removing single element
                    head = head.next;
                    return;
                }
                prev.next = temp.next;
                return;
            }
            prev = temp;
            temp = temp.next;
        }
    }
    
    public boolean contains(int key) {
        Node temp = head;
        while(temp != null){
            if(temp.data == key){
                return true;
            }
            temp = temp.next;
        }
        return false;
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */