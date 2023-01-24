import java.util.concurrent.atomic.AtomicInteger;

/*
 * Ханойские башни. Башня "from" - 1, "to" - 2, "free" - 3
 */


public class HanoiTowers{

    public static void move (String from, String to, String free, int n, AtomicInteger counter){
        counter.getAndIncrement();
        if (n==1){
            System.out.printf ("переместить кольцо с башни %s на башню %s\n", from, to);
        } else {
            move (from,free,to,n-1,counter);
            System.out.printf ("переместить кольцо с башни %s на башню %s\n", from, to);
            move (free, to, from,n-1, counter);
        }
    }


    public static void main(String[] args) {
        int n = 3;
        AtomicInteger counter = new AtomicInteger();
        move ("1","2","3", n, counter);
        System.out.println(counter);
    }
}