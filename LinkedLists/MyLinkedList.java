package LinkedLists;
public class MyLinkedList {

    private Node head; // Ссылка на первый элемент

    public MyLinkedList(Node head) {
        this.head = head;
    }

    public void addFirst(int value){
        Node node = new Node(value);
        if (head != null){
            node.setNext(head);
        }
        head = node;
    }

    public void removeFirst(){
        if(head != null)
            head = head.getNext();
    }

    public Node contains(int value){
        Node node = head;
        while (node != null){ // O(n)
            if (node.getValue() == value){
                return node;
            }
            node = node.getNext();
        }
        return null;
    }

    public void addLast(int value){
        Node node = new Node(value);
        if (head == null){
            head = node;
        }
        {
            Node last = head;
            while (last.getNext() != null){
                last = last.getNext();
            }
            last.setNext(node);
        }
    }

    public void removeLast(){
        if (head == null)
            return;

        Node node = head;
        while (node.getNext() != null){
            if (node.getNext().getNext() == null){
                node.setNext(null);
                return;
            }
            node = node.getNext();
        }
        head = null;
    }

    public void revert(){
        if (head!= null && head.getNext() != null){
            Node current = head;
            Node next = current.getNext();
            Node prev;
            while ( next != null){
                prev = current;
                current = next;
                next = current.getNext();
                current.setNext(prev);
            }
            head.setNext(null);
            head = current;
        }
    }

    public void print (){
        Node node = head;
        while (node!= null)
        {
            System.out.print(node);
            node = node.getNext();
        }
        System.out.println();
    }

}
