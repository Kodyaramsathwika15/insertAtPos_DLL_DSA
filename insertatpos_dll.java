class Dblyll {
    Node head;

    class Node {
        int data;
        Node next;
        Node prev;

        Node(int data) {
            this.data = data;
            next = null;
            prev = null;
        }
    }
    public void insertAtEnd(int data){
        Node newnode=new Node(data);
         if (head == null) {
            head = newnode;
            return;
        }
        Node temp=head;
        while(temp.next!=null){
            temp=temp.next;
        }
            newnode.prev=temp;
            temp.next=newnode;
        
    }
     public void insertAtPosition(int data, int position) {
        Node newnode = new Node(data);
        if (position <= 1) {
            newnode.next = head;
            if (head != null) {
                head.prev = newnode;
            }
            head = newnode;
        }
        Node temp = head;
        int count = 1;
        while (temp != null && count < position - 1) {
            temp = temp.next;
            count++;
        }
        if (temp == null) {
            System.out.println("Position out of bounds");
        }
        newnode.next = temp.next;
        if (temp.next != null) {
            temp.next.prev = newnode;
        }
        temp.next = newnode;
        newnode.prev = temp;
    }

    
    public void printAll() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Dblyll list = new Dblyll();
        list.insertAtEnd(100);
        list.insertAtEnd(300);
        list.insertAtEnd(380);
        list.printAll();
        list.insertAtPosition(180,2);
        list.printAll();
    }
}
