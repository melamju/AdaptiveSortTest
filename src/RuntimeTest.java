import java.util.Random;

public class RuntimeTest {
    public int [] arrayR100 = new int[100]; // random
    public int [] arrayR1000 = new int[1000];
    public int [] arrayR10000 = new int[10000];
    public int [] arrayR100000 = new int[100000];

    public int [] arrayD100 = new int[100]; // descending
    public int [] arrayD1000 = new int[1000];
    public int [] arrayD10000 = new int[10000];
    public int [] arrayD100000 = new int[100000];

    public int [] arrayRUNS100 = new int[100]; // consequtive sequence
    public int [] arrayRUNS1000 = new int[1000];
    public int [] arrayRUNS10000 = new int[10000];
    public int [] arrayRUNS100000 = new int[100000];

    NaturalMergeSort nms;
    MergeSort ms;

    static Random ran = new Random();

    static public int [] randomArray(int [] a) {
        for (int i = 0; i < a.length; i++) {
            a[i] = ran.nextInt(a.length);
        }
        return a;
    }

    static public int [] descendingArray(int [] a){
        int j = 0;
        for (int i = a.length; i != 0; i--){
            a[j] = i;
            j++;
        }
        return a;
    }

    static public int [] RUNSArray(int [] a, int inv){ //inv = number of inversions to create sequences of ascending numbers. High inv = low presortedness.
        for (int i = 0; i < a.length; i++){ // create ascending array
            a[i] = i + 1;
        }
        int r1;
        int r2;
        int save;
        for (int i = 0; i < inv; i++){
            do {
                r1 = ran.nextInt(a.length);
                r2 = ran.nextInt(a.length);
            } while (r1 == r2); // can't invert same index

            //debug-print
            System.out.println(r1 + " " + r2);

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


    }
}
