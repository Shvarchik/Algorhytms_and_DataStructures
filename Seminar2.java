import java.util.Arrays;
import java.util.Random;

public class Seminar2 {

    public static void main(String[] args) {

        int[] arr = ArrayUtils.prepareArray();
        ArrayUtils.printArray(arr);
        
        //int[] testArray = ArrayUtils.prepareArray(1000);
        
        // int res = SearchUtils.binarySearch(testArray2, 11);
        // System.out.printf("Элемент %d %s\n", 11,
        //         res >= 0 ? String.format("найден в массиве по индексу %d", res) : "не найден в массиве");


        long startTime = System.currentTimeMillis();
        SortUtils.heapSort(arr);
        long endTime = System.currentTimeMillis();
        ArrayUtils.printArray(arr);
        long processingTime = endTime - startTime;
        System.out.printf("Время работы пирамидальной сортировки: %d мс.\n", processingTime);
        
    }

    static class SearchUtils{

        static  int binarySearch(int[] array,  int value){
            return  binarySearch(array, value, 0, array.length - 1);
        }

        static int binarySearch(int[] array,  int value, int min, int max){
            int middle;         // Индекс середины массива
            if (max < min)
            {
                return -1;
            }
            else {
                middle = (max - min) / 2 + min;
            }

            if (array[middle] < value){
                return binarySearch(array, value, middle + 1, max);
            }
            else {
                if (array[middle] > value){
                    return binarySearch(array, value, min, middle - 1);
                }
                else {
                    return middle;
                }
            }
        }
    }

    static class  SortUtils{

        /**
         * Сортировка выбором   O(n^2)
         * @param array
         */
        static void directSort(int[] array){
            for (int i = 0; i < array.length; i++){
                int min = i;
                for(int j = i + 1; j < array.length; j++){
                    if (array[j] < array[min]){
                            min = j;
                    }
                }
                if (min != i){
                    int buf = array[i];
                    array[i] = array[min];
                    array[min] = buf;

                    // array[i] = array[i] + array[min];
                    // array[min] = array[i] - array[min];
                    // array[i] = array[i] - array[min];
                }
            }
        }

        /*
         * Быстрая сортировка
         */
        static  void quickSort(int[] array){
            quickSort(array, 0, array.length - 1);
        }

        static void quickSort(int[] array, int startPosition, int endPosition){
            int leftPosition = startPosition;
            int rightPosition = endPosition;
            int pivot = array[(startPosition + endPosition) / 2];

            do {
                while (array[leftPosition] < pivot)
                    leftPosition++;
                while (array[rightPosition] > pivot)
                    rightPosition--;
                if (leftPosition <= rightPosition){
                    if (leftPosition < rightPosition){
                        int buf = array[leftPosition];
                        array[leftPosition] = array[rightPosition];
                        array[rightPosition] = buf;
                    }
                    leftPosition++;
                    rightPosition--;
                }
            }while (leftPosition <= rightPosition);

            if(leftPosition < endPosition){
                quickSort(array, leftPosition, endPosition);
            }
            if(startPosition < rightPosition){
                quickSort(array, startPosition, rightPosition);
            }
        }
        /*
         * Домашнаяя работа
         * Пирамидальная сортировка
         */
        static void heapSort (int[] array){
            for (int i = array.length/2 - 1; i >=0; i--)
                heapify(array, array.length, i);
            for (int i = array.length-1; i > 0; i--)
            {
                int temp = array[0];
                array[0] = array [i];
                array[i] = temp;
                heapify (array, i, 0);
            }
        }

        /*
         * Построение кучи
         */
        static void heapify (int[] array, int size, int root)
        {
            int max = root;
            int leftChild = 2*root + 1;
            int rightChild = 2*root + 2;
            if (leftChild < size && array[leftChild] > array[max])
                max = leftChild;
            if (rightChild < size && array[rightChild] > array[max])
                max = rightChild;
            if (max != root)
            {
                int temp = array[root];
                array[root] = array[max];
                array[max] = temp;
                heapify(array,size, max);
            }
        }
    }

    static class ArrayUtils{

        private static final Random random = new Random();

        static int[] prepareArray(){
            int[]  arr = new int[random.nextInt(16) + 5];
            for (int i = 0; i < arr.length; i++){
                arr[i] = random.nextInt(100);
            }
            return arr;
        }

        static int[] prepareArray(int length){
            int[]  arr = new int[length];
            for (int i = 0; i < arr.length; i++){
                arr[i] = random.nextInt(100);
            }
            return arr;
        }

        static void printArray(int[] arr){
            for (int element: arr) {
                System.out.printf("%d  ", element);
            }
            System.out.println();
        }
    }
}
