package LinkedLists;
public class Sample01 {

    public static void main(String[] args) {

        Node e1 = new Node(1);

        Node e2 = new Node(2);
        e1.setNext(e2);

        Node e3 = new Node(3);
        e2.setNext(e3);

        Node e4 = new Node(4);
        e3.setNext(e4);

        Node e5 = new Node(5);
        e4.setNext(e5);

        Node e6 = new Node(6);
        e5.setNext(e6);

        MyLinkedList listV1 = new MyLinkedList(e1);

        listV1.print();
        listV1.revert();
        listV1.print();

        // Node node = middleNode(e1);

    }

    public static Node middleNode(Node head){
        int length = 1;
        Node node = head;
        while (node.getNext() != null){
            length++;
            node = node.getNext();
        }

        length = length / 2 + 1;

        node = head;
        for(int i = 0; i < length - 1; i++){
            node = node.getNext();
        }
        return node;
    }
}
