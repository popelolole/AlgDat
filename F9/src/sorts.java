import java.util.Arrays;

public class sorts {
    public static void main(String[] args){
        int[] array = {5, 2, 8, 15, 2, 6, 45, 3, 1, 7, 4, 22, 13, 32, 123, 223, 42, 9, 23, 21, 29, 14, 54,
        42, 44, 12};
        //selectionSort(array);
        //insertionSort(array);
        //shellSort(array);
        mergeSort(array);
        System.out.println(Arrays.toString(array));
    }

    public static void mergeSort(int[] a){
        if(a.length == 1)
            return;
        int clength;
        if(a.length % 2 == 0)
            clength = a.length/2;
        else
            clength = a.length/2 + 1;
        int[] b = new int[a.length/2];
        int[] c = new int[clength];
        for(int i = 0;i < a.length/2;i++) {
            b[i] = a[i];
        }
        for(int i = 0;i < clength;i++) {
            c[i] = a[i + a.length/2];
        }
        mergeSort(b);
        mergeSort(c);
        merge(b, c, a);
    } // Jämförelser: Worst O(nlogn), Best O(n)
    // Tilldelningar: O(n logn)
    // Minne: O(n)
    // Stabil

    private static void merge(int[] a, int[] b, int[] c){
        int indexa = 0, indexb = 0, indexc = 0;
        while(indexa < a.length && indexb < b.length){
            if(a[indexa] <= b[indexb])
                c[indexc++] = a[indexa++];
            else
                c[indexc++] = b[indexb++];
        }
        while(indexa < a.length)
            c[indexc++] = a[indexa++];
        while(indexb < b.length)
            c[indexc++] = b[indexb++];
    } // Prestanda: O(n+m)
    // Minne: O(n+m)

    public static void shellSort(int[] a){
        int gap = a.length / 2;
        while(gap > 0){
            for(int index = gap;index < a.length;index++){
                int data = a[index];
                int dataIndex = index;
                while(dataIndex > gap - 1 && data < a[dataIndex - gap]){
                    a[dataIndex] = a[dataIndex - gap];
                    dataIndex -= gap;
                }
                a[dataIndex] = data;
            }
            if(gap == 2)
                gap = 1;
            else
                gap = (int) Math.round(gap / 2.2);
        }
    }// Jämförelser: Beror på gap. Detta ger O(n^5/4) eller O(n^7/6) (nästan n). Sämre än n log n.
    // Platsbyten: Samma
    // Minneskrav: O(1)
    // Ej stabil
    // Är inte optimal i prestanda men använder inte extra utrymme och är därför
    // användbar i inbyggda system.

    public static void insertionSort(int[] a){
        for(int index = 1;index < a.length;index++){
            int data = a[index];
            int dataIndex = index;
            while(dataIndex > 0 && data < a[dataIndex - 1]){
                a[dataIndex] = a[dataIndex - 1];
                dataIndex--;
            }
            a[dataIndex] = data;
        }
    } // Jämförelser: Worst O(n^2), Best O(n)
    // Tilldelningar ("platsbyten"): Worst O(n^2), Best O(n)
    // Minneskrav: O(1)
    // Stabil
    // Snabb för små arrayer

    public static void selectionSort(int[] a){
        for(int index = 0;index < a.length - 1;index++){
            int minIndex = index;
            for(int i = index + 1;i < a.length;i++){
                if(a[i] < a[minIndex])
                    minIndex = i;
            }
            int tmp = a[index];
            a[index] = a[minIndex];
            a[minIndex] = tmp;
        }
    }
} // Jämförelser: O(n^2)
// Platsbyten: O(n)
// Minneskrav: O(1)
// Ej stabil
// Bra för stora data
