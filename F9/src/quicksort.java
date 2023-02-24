import java.util.Arrays;

public class quicksort {
    public static void main(String[] args){
        int[] array = {5, 2, 8, 15, 2, 6, 45, 3, 1, 7, 4, 22, 13, 32, 123, 223, 42, 9, 23, 21, 29, 14, 54,
                42, 44, 12};
        quickSort(array);
        System.out.println(Arrays.toString(array));
    }

    public static void quickSort(int[] a){
        quickSort(a, 0, a.length - 1);
    } // O(n log n)

    private static void quickSort(int[] a, int first, int last){
        if(first < last){
            int pivIndex = partition(a, first, last);
            quickSort(a, first, pivIndex - 1);
            quickSort(a, pivIndex + 1, last);
        }
    }

    private static int partition(int[] a, int first, int last){
        //Bubble sort first, middle and last to find median
        int middle = (first + last) / 2;
        if(a[middle] < a[first])
            swap(a, first, middle);
        if(a[last] < a[middle])
            swap(a, middle, last);
        if(a[middle] < a[first])
            swap(a, first, middle);

        //put the median in the first position...
        swap(a, first, middle);

        //... and partition
        int pivot = a[first];
        int up = first;
        int down = last;
        do{
            while(a[up] <= pivot && up < last){
                up++;
            }
            while(a[down] > pivot && down > first){
                down--;
            }

            if(up < down) {
                swap(a, up, down);
            }
        } while(up < down);
        swap(a, first, down);
        return down;
    }

    private static void swap(int[] a, int first, int last){
        int tmp = a[first];
        a[first] = a[last];
        a[last] = tmp;
    }
}
