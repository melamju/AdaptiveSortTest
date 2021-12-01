// source:
// https://www.inf.hs-flensburg.de/lang/algorithmen/sortieren/merge/natmerge.htm

public class NaturalMergeSort {
    private int[] a;
    private int[] b;    // Hilfsarray
    private int n;

    public void nmsort(int[] a)
    {
        this.a=a;
        n=a.length;
        b=new int[n];
        naturalmergesort();
    }

    private boolean mergeruns(int[] a, int[] b)
    {
        int i=0, k=0, x;
        boolean asc=true;

        while (i<n)
        {
            k=i;
            do x=a[i++]; while (i<n && x<=a[i]);  // aufsteigender Teil
            while (i<n && x>=a[i]) x=a[i++];      // absteigender Teil
            merge (a, b, k, i-1, asc);
            asc=!asc;
        }
        return k==0;
    }

    private void merge(int[] a, int[] b, int lo, int hi, boolean asc)
    {
        int k=asc? lo: hi;
        int c=asc? 1: -1;
        int i=lo, j=hi;

        // jeweils das nächstgrößte Element zurückkopieren,
        // bis i und j sich überkreuzen
        while (i<=j)
        {
            if (a[i]<=a[j])
                b[k]=a[i++];
            else
                b[k]=a[j--];
            k+=c;
        }
    }

    private void naturalmergesort()
    {
        // abwechselnd von a nach b und von b nach a verschmelzen
        while (!mergeruns(a, b) & !mergeruns(b, a));
    }
}
