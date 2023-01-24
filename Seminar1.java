import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Seminar1 {
    
    //static int counter = 4;

    /**
     * ДОМАШНЯЯ РАБОТА
     * Разработать рекурсивный алгоритм решения задачи "Ханойская Башня"
     * @param args
     */
    public static void main(String[] args) {

        int lastNumber = 13;

        // 1 2 3 4 5
        System.out.printf("Сумма чисел от 1 до %d = %d\n",5,  sum(lastNumber));


        AtomicInteger counter = new AtomicInteger();
        List<Integer> simpleNumberList = findSimpleNumbers(lastNumber, counter);
        for (int number: simpleNumberList) {
            System.out.println(number);
        }

        System.out.printf("Простые числа в диапазоне от 1 до %d; Итого: %d; Кол-во итераций: %d\n",
                lastNumber, simpleNumberList.size(), counter.get());

        int lastNumber2 = 20;
        AtomicInteger counter2 = new AtomicInteger();
        List<Integer> simpleNumberList2 = findSimpleNumbers(lastNumber2, counter2);
        for (int number: simpleNumberList2) {
            System.out.println(number);
        }

        System.out.printf("Простые числа в диапазоне от 1 до %d; Итого: %d; Кол-во итераций: %d\n",
                lastNumber2, simpleNumberList2.size(), counter2.get());

       /* int counter3 = 0;
        while (true){
            counter3++;
            if (counter3 == 5)
                break;
        }

        for(;;){

        }*/

        f(4);

        System.out.println();

        long startTime = System.currentTimeMillis();
        System.out.printf("Число Фибоначчи для значения %d = %d (рекурсия)\n", 10,  fb1(10));
        long endTime = System.currentTimeMillis();
        long processingTime = endTime - startTime;
        System.out.printf("(1) Операция выполнена за %d мс.\n", processingTime);

        startTime = System.currentTimeMillis();
        System.out.printf("Число Фибоначчи для значения %d = %d\n", 10,  fb2(10));
        endTime = System.currentTimeMillis();
        processingTime = endTime - startTime;
        System.out.printf("(1) Операция выполнена за %d мс.\n", processingTime);

        startTime = System.currentTimeMillis();
        System.out.printf("Число Фибоначчи для значения %d = %d (рекурсия)\n", 30,  fb1(30));
        endTime = System.currentTimeMillis();
        processingTime = endTime - startTime;
        System.out.printf("(2) Операция выполнена за %d мс.\n", processingTime);

        startTime = System.currentTimeMillis();
        System.out.printf("Число Фибоначчи для значения %d = %d\n", 30,  fb2(30));
        endTime = System.currentTimeMillis();
        processingTime = endTime - startTime;
        System.out.printf("(2) Операция выполнена за %d мс.\n", processingTime);





        startTime = System.currentTimeMillis();
        System.out.printf("Число Фибоначчи для значения %d = %d (рекурсия)\n", 50,  fb1(50));
        endTime = System.currentTimeMillis();
        processingTime = endTime - startTime;
        System.out.printf("(3) Операция выполнена за %d мс.\n", processingTime);

        startTime = System.currentTimeMillis();
        System.out.printf("Число Фибоначчи для значения %d = %d\n", 50,  fb2(50));
        endTime = System.currentTimeMillis();
        processingTime = endTime - startTime;
        System.out.printf("(3) Операция выполнена за %d мс.\n", processingTime);

    }

    /**
     * [1] Необходимо написать алгоритм, считающий сумму всех чисел от 1 до N.
     * Согласно свойствам линейной сложности O(n), количество итераций цикла
     * будет линейно изменяться относительно изменения размера N.
     */
    public static int sum(int lastNumber){
        int sum = 0;

        for (int i = 1; i <= lastNumber; i++){
            sum = sum + i;
        }
        return sum;
    }

    /**
     * [2] Написать алгоритм поиска простых чисел (делятся только на себя и на 1)
     * в диапазоне от 1 до N.
     *
     * O = (f(n^2))
     */
    public static List<Integer> findSimpleNumbers(int lastNumber, AtomicInteger counter){
        List<Integer> result = new ArrayList<>();
        boolean simple;
        for (int i = 1; i <= lastNumber; i++){
            simple = true; // Число изначально является простым
            for (int j = 2; j < i; j++){
                counter.getAndIncrement();
                if (i % j == 0){
                    simple = false;
                    break;
                }
            }

            if (simple){
                result.add(i);
            }
        }

        return result;
    }

    /**
     * f(4);
     * @param n
     */
    static void f(int n){
        System.out.println(n);
        if (n >= 3){
            f(n - 1);
            f(n - 2);
            f(n - 2);
        }
    }

    /**
     * 0 1 2 3 4 5 6 7  8
     * 0 1 1 2 3 5 8 13 21 ...
     *
     * O(2^n)
     *
     * @param num
     * @return
     */
    public static int fb1(int num){ // n
        if (num == 0 || num == 1) return num;
        return fb1(num - 1) + fb1(num - 2); // 2 ^(n - 1)
    }

    public static  int fb2(int num){ // 8
        if (num == 0 || num == 1) return num;
        int[] numbers = new int[num + 1];
        numbers[0] = 0;
        numbers[1] = 1;
        for (int i = 2; i <= num; i++){
            numbers[i] = numbers[i - 1] + numbers[i - 2];
        }
        return numbers[num];
    }


}


