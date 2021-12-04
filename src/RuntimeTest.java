/**
 * @author Elisabeth Bobrowski
 * @date 1.12.2021
 */

import java.util.Random;

import static java.util.Arrays.sort;

public class RuntimeTest {
    static int[] array;

    static NaturalMergeSort nms = new NaturalMergeSort();
    static MergeSort ms = new MergeSort();

    static Random ran = new Random();

    static public int [] randomArray(int length) {
        int [] a = new int[length];
        for (int i = 0; i < length; i++) {
            a[i] = ran.nextInt(length);
        }
        return a;
    }

    static public int [] descendingArray(int length){
        int [] a = new int[length];
        int j = 0;
        for (int i = length; i != 0; i--){
            a[j] = i;
            j++;
        }
        return a;
    }

    static public int [] ascendingArray(int length){
        int [] a = new int[length];
        for (int i = 0; i < length; i++){
            a[i] = i;
        }
        return a;
    }

    static public int [] RUNSArray(int length, int inv){ //inv = number of inversions to create sequences of ascending numbers. High inv = low presortedness.
        int [] a = new int[length];
        for (int i = 0; i < length; i++){ // create ascending array
            a[i] = i + 1;
        }
        int r1;
        int r2;
        int save;
        for (int i = 0; i < inv; i++){
            do {
                r1 = ran.nextInt(length);
                r2 = ran.nextInt(length);
            } while (r1 == r2); // can't invert same index

            //debug-print
            //System.out.println(r1 + " " + r2);

            // invert numbers on index r1 & r2
            save = a[r1];
            a[r1] = a[r2];
            a[r2] = save;
        }
        return a;
    }

    static void print(int [] a){
        for (int j : a) {
            System.out.print(j + " ");
        }
        System.out.println("\n");
    }

    public static void main(String[] args) {
        //test methods
        /*print(randomArray(10));
        print(descendingArray(10));
        print(RUNSArray(10, 1));
        print(RUNSArray(10, 5));
        print(RUNSArray(10, 9));*/

        /** Tests */
        long start;
        long end;

        array = randomArray(100);
        int [] copy = array;
        int [] timcopy = array;
        start = System.currentTimeMillis();
        ms.msort(array);
        end = System.currentTimeMillis() - start;
        System.out.format("%70s%10s","MergeSort, random array, 100: ", end + "ms\n");

        start = System.currentTimeMillis();
        nms.nmsort(copy);
        end = System.currentTimeMillis() - start;
        System.out.format("%70s%10s","Natural MergeSort, random array, 100: ", end + "ms\n");

        start = System.currentTimeMillis();
        sort(timcopy);
        end = System.currentTimeMillis() - start;
        System.out.format("%70s%11s","TimSort, random array, 100: ", end + "ms\n\n");

        array = randomArray(10000);
        copy = array;
        timcopy = array;
        start = System.currentTimeMillis();
        ms.msort(array);
        end = System.currentTimeMillis() - start;
        System.out.format("%70s%10s", "MergeSort, random array, 10,000: ", end + "ms\n");

        start = System.currentTimeMillis();
        nms.nmsort(copy);
        end = System.currentTimeMillis() - start;
        System.out.format("%70s%10s", "Natural MergeSort, random array, 10,000: ", end + "ms\n");

        start = System.currentTimeMillis();
        sort(timcopy);
        end = System.currentTimeMillis() - start;
        System.out.format("%70s%11s","TimSort, random array, 10,000: ", end + "ms\n\n");

        array = randomArray(1000000);
        copy = array;
        timcopy = array;
        start = System.currentTimeMillis();
        ms.msort(array);
        end = System.currentTimeMillis() - start;
        System.out.format("%70s%10s", "MergeSort, random array, 1,000,000: ", end + "ms\n");

        start = System.currentTimeMillis();
        nms.nmsort(copy);
        end = System.currentTimeMillis() - start;
        System.out.format("%70s%10s", "Natural MergeSort, random array, 1,000,000: ", end + "ms\n");

        start = System.currentTimeMillis();
        sort(timcopy);
        end = System.currentTimeMillis() - start;
        System.out.format("%70s%11s","TimSort, random array, 1,000,000: ", end + "ms\n\n");

        array = randomArray(50000000);
        copy = array;
        timcopy = array;
        start = System.currentTimeMillis();
        ms.msort(array);
        end = System.currentTimeMillis() - start;
        System.out.format("%70s%10s", "MergeSort, random array, 50,000,000: ", end + "ms\n");

        start = System.currentTimeMillis();
        nms.nmsort(copy);
        end = System.currentTimeMillis() - start;
        System.out.format("%70s%10s", "Natural MergeSort, random array, 50,000,000: ", end + "ms\n");

        start = System.currentTimeMillis();
        sort(timcopy);
        end = System.currentTimeMillis() - start;
        System.out.format("%70s%11s","TimSort, random array, 50,000,000: ", end + "ms\n\n");

        array = descendingArray(50000000);
        copy = array;
        timcopy = array;
        start = System.currentTimeMillis();
        ms.msort(array);
        end = System.currentTimeMillis() - start;
        System.out.format("%70s%10s", "MergeSort, descending array, 50,000,000: ", end + "ms\n");

        start = System.currentTimeMillis();
        nms.nmsort(copy);
        end = System.currentTimeMillis() - start;
        System.out.format("%70s%10s", "Natural MergeSort, descending array, 50,000,000: ", end + "ms\n");

        start = System.currentTimeMillis();
        sort(timcopy);
        end = System.currentTimeMillis() - start;
        System.out.format("%70s%11s","TimSort, descending array, 50,000,000: ", end + "ms\n\n");

        array = ascendingArray(50000000);
        copy = array;
        timcopy = array;
        start = System.currentTimeMillis();
        ms.msort(array);
        end = System.currentTimeMillis() - start;
        System.out.format("%70s%10s", "MergeSort, sorted array, 50,000,000: ", end + "ms\n");

        start = System.currentTimeMillis();
        nms.nmsort(copy);
        end = System.currentTimeMillis() - start;
        System.out.format("%70s%10s", "Natural MergeSort, sorted array, 50,000,000: ", end + "ms\n");

        start = System.currentTimeMillis();
        sort(timcopy);
        end = System.currentTimeMillis() - start;
        System.out.format("%70s%11s","TimSort, sorted array, 50,000,000: ", end + "ms\n\n");

        array = RUNSArray(50000000, 5000000); // ~90% ascending sequences
        copy = array;
        timcopy = array;
        start = System.currentTimeMillis();
        ms.msort(array);
        end = System.currentTimeMillis() - start;
        System.out.format("%70s%10s", "MergeSort, RUNS array, high presortedness, 50,000,000: ", end + "ms\n");

        start = System.currentTimeMillis();
        nms.nmsort(copy);
        end = System.currentTimeMillis() - start;
        System.out.format("%70s%10s", "Natural MergeSort, RUNS array, high presortedness, 50,000,000: ", end + "ms\n");

        start = System.currentTimeMillis();
        sort(timcopy);
        end = System.currentTimeMillis() - start;
        System.out.format("%70s%11s","TimSort, RUNS array, high presortedness, 50,000,000: ", end + "ms\n\n");

        array = RUNSArray(50000000, 25000000); // ~50% ascending sequences
        copy = array;
        timcopy = array;
        start = System.currentTimeMillis();
        ms.msort(array);
        end = System.currentTimeMillis() - start;
        System.out.format("%70s%10s", "MergeSort, RUNS array, medium presortendess, 50,000,000: ", end + "ms\n");

        start = System.currentTimeMillis();
        nms.nmsort(copy);
        end = System.currentTimeMillis() - start;
        System.out.format("%70s%10s", "Natural MergeSort, RUNS array, medium presortedness, 50,000,000: ", end + "ms\n");

        start = System.currentTimeMillis();
        sort(timcopy);
        end = System.currentTimeMillis() - start;
        System.out.format("%70s%11s","TimSort, RUNS array, medium presortedness, 50,000,000: ", end + "ms\n\n");

        array = RUNSArray(50000000, 40000000); // ~20% ascending sequences
        copy = array;
        timcopy = array;
        start = System.currentTimeMillis();
        ms.msort(array);
        end = System.currentTimeMillis() - start;
        System.out.format("%70s%10s", "MergeSort, RUNS array, low presortendess, 50,000,000: ", end + "ms\n");

        start = System.currentTimeMillis();
        nms.nmsort(copy);
        end = System.currentTimeMillis() - start;
        System.out.format("%70s%10s", "Natural MergeSort, RUNS array, low presortedness, 50,000,000: ", end + "ms\n");

        start = System.currentTimeMillis();
        sort(timcopy);
        end = System.currentTimeMillis() - start;
        System.out.format("%70s%11s","TimSort, RUNS array, low presortedness, 50,000,000: ", end + "ms\n\n");

    }
}
