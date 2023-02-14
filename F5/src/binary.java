public class binary {
    public static void main(String[] args){
        int[] array = new int[30];
        for(int i = 0;i < 30;i++){
            array[i] = i + 1;
        }
        System.out.println(binarysearch(array, 25));
    }

    static Object binarysearch(int[] array, Comparable target){
        return binarySearch(array, target, 0, array.length - 1);
    } //O(log(n))

    private static Object binarySearch(int[] array, Comparable target, int first, int last){
        if(first > last)
            return -1;
        else {
            int middle = (first + last) / 2;
            int compResult = target.compareTo(array[middle]);
            if(compResult == 0)
                return middle;
            else if(compResult < 0)
                return (binarySearch(array, target, first, middle - 1));
            else {
                return (binarySearch(array, target, middle + 1, last));
            }
        }

    }
}
