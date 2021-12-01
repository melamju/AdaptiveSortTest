/**
 * @author Elisabeth Bobrowski
 * @date 1.12.2021
 */

import java.util.Random;

public class RuntimeTest {
    static public int [] arrayR1 = new int[100]; // random
    static public int [] arrayR2 = new int[10000];
    static public int [] arrayR3 = new int[1000000];
    static public int [] arrayR4 = new int[10000000];

    static public int [] arrayD = new int[10000000]; // descending

    static public int [] arrayRUNSh = new int[10000000]; // consequtive sequence, high presortedness
    static public int [] arrayRUNSm = new int[10000000]; // middle presortedness
    static public int [] arrayRUNSl = new int[10000000]; // low presortedness

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

        /** fill arrays */
        //random
        arrayR1 = randomArray(100);
        arrayR2 = randomArray(10000);
        arrayR3 = randomArray(10000000);
        arrayR4 = randomArray(500000000);

        //descending
        arrayD = descendingArray(500000000);

        //Runs, presortedness high
        arrayRUNSh = RUNSArray(500000000, 50000000); // 10% not sorted
        arrayRUNSm = RUNSArray(500000000, 250000000); // 50% not sorted
        arrayRUNSl = RUNSArray(500000000, 400000000); // 80% not sorted

        //long end = System.currentTimeMillis()-start;
        //System.out.println(end);

        /** Tests */
        long start;
        long end;

        int [] copy = arrayR1;
        start = System.currentTimeMillis();
        ms.msort(arrayR1);
        end = System.currentTimeMillis() - start;
        System.out.println("MergeSort, random array, 100: " + end + "ms");

        start = System.currentTimeMillis();
        nms.nmsort(copy);
        end = System.currentTimeMillis() - start;
        System.out.println("Natural MergeSort: random array, 100" + end + "ms");

        copy = arrayR2;
        start = System.currentTimeMillis();
        ms.msort(arrayR2);
        end = System.currentTimeMillis() - start;
        System.out.println("MergeSort, random array, 10.000: " + end + "ms");

        start = System.currentTimeMillis();
        nms.nmsort(copy);
        end = System.currentTimeMillis() - start;
        System.out.println("Natural MergeSort: random array, 10.000" + end + "ms");

        copy = arrayR3;
        start = System.currentTimeMillis();
        ms.msort(arrayR3);
        end = System.currentTimeMillis() - start;
        System.out.println("MergeSort, random array, 1.000.000: " + end + "ms");

        start = System.currentTimeMillis();
        nms.nmsort(copy);
        end = System.currentTimeMillis() - start;
        System.out.println("Natural MergeSort: random array, 1.000.000" + end + "ms");

        copy = arrayR4;
        start = System.currentTimeMillis();
        ms.msort(arrayR4);
        end = System.currentTimeMillis() - start;
        System.out.println("MergeSort, random array, 10.000.000: " + end + "ms");

        start = System.currentTimeMillis();
        nms.nmsort(copy);
        end = System.currentTimeMillis() - start;
        System.out.println("Natural MergeSort: random array, 10.000.000" + end + "ms");


    }
}
