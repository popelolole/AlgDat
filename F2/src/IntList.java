import java.util.Arrays;

public class IntList {
    private int size;
    private int space;
    private int[] array;

    public IntList(int initialCapacity){
        size = 0;
        space = initialCapacity;
        array = new int[space];
    }

    public boolean add(int element){
        if(size == space)
            reallocate();
        array[size++] = element;
        return true;
    }

    public void add(int index, int element){
        if(index < 0 || index > size)
            throw new ArrayIndexOutOfBoundsException(index);
        if(size == space)
            reallocate();
        for(int i = size;i > index;i--)
            array[i] = array[i - 1];
        array[index] = element;
        size++;
    }

    public int get(int index){
        if(index < 0 || index > size)
            throw new ArrayIndexOutOfBoundsException(index);
        return array[index];
    }

    public int indexOf(int element){
        for(int i = 0;i < size;i++) {
            if (array[i] == element)
                return i;
        }
        return -1;
    }

    public int remove(int index){
        if(index < 0 || index > size)
            throw new ArrayIndexOutOfBoundsException(index);
        if(size <= space / 4)
            scale();
        int data = array[index];
        for(int i = index;i < size - 1;i++)
            array[i] = array[i+1];
        size--;
        return data;
    }

    public int set(int index, int element){
        if(index < 0 || index > size)
            throw new ArrayIndexOutOfBoundsException(index);
        int data = array[index];
        array[index] = element;
        return data;
    }

    public int size(){
        return size;
    }

    public int space(){
        return space;
    }

    @Override
    public String toString(){
        StringBuilder info = new StringBuilder("[");
        for(int i = 0;i < size;i++){
            info.append(array[i]);
            if(i < size - 1)
                info.append(", ");
        }
        info.append("]");
        return info.toString();
    }

    private void reallocate(){
        space *= 2;
        array = Arrays.copyOf(array, space);
    }

    private void scale(){
        space /= 4;
        array = Arrays.copyOf(array, space);
    }
}
