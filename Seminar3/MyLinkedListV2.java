package Seminar3;

public class MyLinkedListV2 {

    private NodeV2 head;
    private NodeV2 tail;

    public MyLinkedListV2(NodeV2 head, NodeV2 tail) {
        this.head = head;
        this.tail = tail;
    }

    public void addFirst(int value){
        NodeV2 node = new NodeV2(value);
        if (head != null){
            node.setNext(head);
            head.setPrev(node);
        }
        else  {
            tail = node;
        }
        head = node;
    } // addFirst

    public void removeFirst(){
        if(head != null && head.getNext() != null){
            head.getNext().setPrev(null);
            head = head.getNext();
        }
        else {
            head = null;
            tail = null;
        }

    } // removeFirst

    public void print (){
        NodeV2 node = head;
        while (node!= null)
        {
            System.out.print(node);
            node = node.getNext();
        }
        System.out.println();
    }

    public void revert(){
        NodeV2 node = head;
        while (node != null){
            NodeV2 prev = node.getPrev();
            NodeV2 next = node.getNext();
            node.setPrev(next);
            node.setNext(prev);
            if (prev == null)
             tail = node;
            if (next == null)
             head = node;
            node = next;
        }
    }
    

}
