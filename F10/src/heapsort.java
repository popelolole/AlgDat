import java.util.Arrays;

public class heapsort {
    public static void main(String[] args){
        int[] a = {1, 4, 2, 7, 3};
        heapSort(a);
        System.out.println(Arrays.toString(a));
    }

    public static void heapSort(int[] a){
        buildHeap(a);
        shrinkHeap(a);
    } // Jämförelser och tilldelningar: O(n log n)
    // Minne: O(1)
    // Ej stabil
    // Långsammare än quicksort, men worst O(n log n) - till skillnad från quicksorts O(n^2)
    // Föredras i inbyggda system och säkerhetssystem (Linux kärna).
    // MergeSort är bättre och stabil, men använder extra utrymme.

    private static void buildHeap(int[] a){
        int heapSize = 1;
        while(heapSize < a.length) {
            heapSize++;
            int child = heapSize - 1;
            int parent = (heapSize - 1) / 2;
            while (parent >= 0 && a[child] > a[parent]) {
                int tmp = a[parent];
                a[parent] = a[child];
                a[child] = tmp;
                child = parent;
                parent = (child - 1) / 2;
            }
        }
    }

    private static void shrinkHeap(int[] a){
        int heapSize = a.length;
        while(heapSize > 0){
            heapSize--;
            int tmp = a[heapSize];
            a[heapSize] = a[0];
            a[0] = tmp;

            int parent = 0;
            while(true){
                int left = 2 * parent + 1;
                if(left >= heapSize)
                    break;
                int right = left + 1;
                int max = left;
                if(right < heapSize && a[left] < a[right])
                    max = right;

                if(a[parent] < a[max]){
                    int tmp2 = a[parent];
                    a[parent] = a[max];
                    a[max] = tmp2;
                    parent = max;
                }
                else
                    break;
            }
        }
    }
}
