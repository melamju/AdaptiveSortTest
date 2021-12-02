/**
 * @author Elisabeth Bobrowski
 * @date 1.12.2021
 */

import java.util.Random;

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
        /*int [] a = new int[10];
        print(randomArray(a));
        print(descendingArray(a));
        print(RUNSArray(a, 1));
        print(RUNSArray(a, 5));
        print(RUNSArray(a, 9));*/

        /** Tests */
        long start;
        long end;

        array = randomArray(100);
        int [] copy = array;
        start = System.currentTimeMillis();
        ms.msort(array);
        end = System.currentTimeMillis() - start;
        System.out.println("MergeSort, random array, 100: " + end + "ms");

        start = System.currentTimeMillis();
        nms.nmsort(copy);
        end = System.currentTimeMillis() - start;
        System.out.println("Natural MergeSort: random array, 100: " + end + "ms");

        array = randomArray(10000);
        copy = array;
        start = System.currentTimeMillis();
        ms.msort(array);
        end = System.currentTimeMillis() - start;
        System.out.println("MergeSort, random array, 10.000: " + end + "ms");

        start = System.currentTimeMillis();
        nms.nmsort(copy);
        end = System.currentTimeMillis() - start;
        System.out.println("Natural MergeSort: random array, 10.000: " + end + "ms");

        array = randomArray(1000000);
        copy = array;
        start = System.currentTimeMillis();
        ms.msort(array);
        end = System.currentTimeMillis() - start;
        System.out.println("MergeSort, random array, 1.000.000: " + end + "ms");

        start = System.currentTimeMillis();
        nms.nmsort(copy);
        end = System.currentTimeMillis() - start;
        System.out.println("Natural MergeSort: random array, 1.000.000: " + end + "ms");

        array = randomArray(50000000);
        copy = array;
        start = System.currentTimeMillis();
        ms.msort(array);
        end = System.currentTimeMillis() - start;
        System.out.println("MergeSort, random array, 50.000.000: " + end + "ms");

        start = System.currentTimeMillis();
        nms.nmsort(copy);
        end = System.currentTimeMillis() - start;
        System.out.println("Natural MergeSort: random array, 50.000.000: " + end + "ms");

        array = descendingArray(50000000);
        copy = array;
        start = System.currentTimeMillis();
        ms.msort(array);
        end = System.currentTimeMillis() - start;
        System.out.println("MergeSort, descending array, 50.000.000: " + end + "ms");

        start = System.currentTimeMillis();
        nms.nmsort(copy);
        end = System.currentTimeMillis() - start;
        System.out.println("Natural MergeSort: descending array, 50.000.000: " + end + "ms");

        array = RUNSArray(50000000, 5000000); // ~10% not sorted
        copy = array;
        start = System.currentTimeMillis();
        ms.msort(array);
        end = System.currentTimeMillis() - start;
        System.out.println("MergeSort, RUNS array, high presortedness, 50.000.000: " + end + "ms");

        start = System.currentTimeMillis();
        nms.nmsort(copy);
        end = System.currentTimeMillis() - start;
        System.out.println("Natural MergeSort: RUNS array, high presortedness, 50.000.000: " + end + "ms");

        array = RUNSArray(50000000, 25000000); // ~50% not sorted
        copy = array;
        start = System.currentTimeMillis();
        ms.msort(array);
        end = System.currentTimeMillis() - start;
        System.out.println("MergeSort, RUNS array, medium presortendess, 50.000.000: " + end + "ms");

        start = System.currentTimeMillis();
        nms.nmsort(copy);
        end = System.currentTimeMillis() - start;
        System.out.println("Natural MergeSort: RUNS array, medium presortedness, 50.000.000: " + end + "ms");

        array = RUNSArray(50000000, 40000000); // ~80% not sorted
        copy = array;
        start = System.currentTimeMillis();
        ms.msort(array);
        end = System.currentTimeMillis() - start;
        System.out.println("MergeSort, RUNS array, low presortendess, 50.000.000: " + end + "ms");

        start = System.currentTimeMillis();
        nms.nmsort(copy);
        end = System.currentTimeMillis() - start;
        System.out.println("Natural MergeSort: RUNS array, low presortedness, 50.000.000: " + end + "ms");


    }
}
