package MyHashTable;

/**
 * Моя хеш-таблица
 * @param <K> Ключ
 * @param <V> Значение
 */
public class MyHashTable<K, V> {

    private static int INIT_BUCKET_COUNT = 16;
    private Bucket<K, V>[] buckets;
    private  class Entity{

        private K key;
        private V value;

    }

    private class Bucket<K, V>{

        private Node head;
        private class Node{

            private Node next;
            private Entity value;

        }

        /**
         * Поиск значения элемента
         * @param key Ключ
         * @return Значение
         */
        public V get(K key){
            Node node = head;
            while (node != null){
                if(node.value.key.equals(key)){
                    return (V)node.value.value;
                }
                node = node.next;
            }
            return null;
        }

        /**
         * Добавление нового элемента
         * @param entity Элемент
         * @return Результат добавления нового элемента
         */
        public boolean add(Entity entity){
            Node node = new Node();
            node.value = entity;
            if (head != null){
                Node currentNode = head;
                while (true){
                    if (currentNode.value.key.equals(entity.key)) {
                        return false;
                    }
                    if (currentNode.next != null){
                        currentNode = currentNode.next;
                    }
                    else{
                        currentNode.next = node;
                        return true;
                    }
                }
            }
            else {
                head = node;
                return true;
            }
        }

        /**
         * Удаление элемента
         * @param key Ключ элемента
         * @return Результат удаления элемента
         */
        public boolean remove(K key){
            if (head == null)
                return false;

            if (head.value.key.equals(key)){
                head = head.next;
                return true;
            }
            else {
                Node node = head;
                while (node.next != null){
                    if (node.next.value.key.equals(key)){
                        node.next = node.next.next;
                        return true;
                    }
                    node = node.next;
                }
            }

            return false;
        }

    }

    public MyHashTable(){
        this(INIT_BUCKET_COUNT);
    }

    public MyHashTable(int initSize){
        buckets = new Bucket[initSize];
    }

    private int calculateBucketIndex(K key){
         return key.hashCode() % buckets.length;
    }

    /**
     * Поиск значения элемента по ключу
     * @param key Ключ
     * @return Значение элемента (null - элемент не найден)
     */
    public V get(K key){
        int index = calculateBucketIndex(key);
        Bucket<K, V> bucket = buckets[index];
        if (bucket != null){
            return bucket.get(key);
        }
        return null;
    }

    /**
     * Добавление нового элемента
     * @param key Ключ
     * @param value Значение
     * @return Результат добавления нового элемента
     */
    public boolean put(K key, V value){
        int index = calculateBucketIndex(key);
        Bucket<K, V> bucket = buckets[index];
        if (bucket == null){
            bucket = new Bucket<>();
            buckets[index] = bucket;
        }

        Entity entity = new Entity();
        entity.key = key;
        entity.value = value;

        return bucket.add(entity);

    }

    /**
     * Удаление элемента
     * @param key Ключ
     * @return Результат удаления элемента
     */
    public boolean remove(K key){
        int index = calculateBucketIndex(key);
        Bucket<K, V> bucket = buckets[index];
        if (bucket != null){
            return bucket.remove(key);
        }
        return false;
    }

}
