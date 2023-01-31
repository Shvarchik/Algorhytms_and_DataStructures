package MyHashTable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.TreeMap;

public class Sample01 {

    public static void main(String[] args) {

        MyHashTable<Integer, String> myHashTable = new MyHashTable<>();
        myHashTable.put(1, "Value 1");
        myHashTable.put(2, "Value 2");
        myHashTable.put(3, "Value 3");
        myHashTable.put(1, "Value 123456");
        myHashTable.remove(12);
        myHashTable.remove(2);
        myHashTable.remove(2);
        String value1 = myHashTable.get(3);
        String value2 = myHashTable.get(33);
    }

}

