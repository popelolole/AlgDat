public class linear {
    public static void main(String[] args){

    }

    static Object linearsearch(Object[] array, Object target){
        return linearSearch(array, target, 0);
    }

    private static Object linearSearch(Object[] array, Object target, int position){
        if(position == array.length)
            return -1;
        else if(target.equals(array[position]))
            return position;
        else
            return linearSearch(array, target, position+1);
    }
}
