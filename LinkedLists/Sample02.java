package LinkedLists;

public class Sample02 {
    public static void main(String[] args) {
        NodeV2 e1 = new NodeV2(1);

        NodeV2 e2 = new NodeV2(2);
        e1.setNext(e2);
        e2.setPrev(e1);

        NodeV2 e3 = new NodeV2(3);
        e2.setNext(e3);
        e3.setPrev(e2);

        NodeV2 e4 = new NodeV2(4);
        e3.setNext(e4);
        e4.setPrev(e3);

        NodeV2 e5 = new NodeV2(5);
        e4.setNext(e5);
        e5.setPrev(e4);

        MyLinkedListV2 listV2 = new MyLinkedListV2(e1,e2);

        listV2.print();
        listV2.revert();
        listV2.print();
    }
}
