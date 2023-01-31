package LinkedLists;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class Sample00 {

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>(100);
        list.add(1);
        list.add(2);
        list.ensureCapacity(1000);

        HashSet<Integer> list2 = new HashSet<>();

        LinkedList<Integer> list3 = new LinkedList<>();
        list3.add(1);
        list3.add(2);

        //list3.addFirst();
        //list3.offerFirst()
        list3.peekFirst();
        list3.peekLast(); // Возвращают, НО НЕ УДАЛЯЮТ
        list3.pollFirst(); // Возвращают и УДАЛЯЮТ элемент из коллекции
    }

}

