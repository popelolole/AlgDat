import java.util.Arrays;

public class PArrayList<E> {
    private E[] array;
    private int size;
    private int space;

    public PArrayList(){
        size = 0;
        space = 10;
        array = (E[]) new Object[space];
    }

    public boolean add(E element){
        if(size == space){
            reallocate();
        }
        array[size++] = element;
        return true;
    }

    public void add(int index, E element){
        if(0 <= index && index < size) {
            if (size == space) {
                reallocate();
            }
            for (int i = size; i > index; i--)
                array[i] = array[i - 1];
            array[index] = element;
            size++;
            return;
        }
        throw new ArrayIndexOutOfBoundsException(index);
    }

    public E get(int index){
        if(0 <= index && index < size)
            return array[index];
        throw new ArrayIndexOutOfBoundsException(index);
    }

    public E set(int index, E element){
        if(0 <= index && index < size) {
            E data = array[index];
            array[index] = element;
            return data;
        }
        throw new ArrayIndexOutOfBoundsException(index);
    }

    public E remove(int index){
        if(0 <= index && index < size) {
            E data = array[index];
            for (int i = size; i > index; i--) {
                array[i] = array[i - 1];
            }
            size--;
            return data;
        }
        throw new ArrayIndexOutOfBoundsException(index);
    }

    public int indexOf(Object o){
        for(int i = 0;i < size;i++){
            if(array[i].equals(o))
                return i;
        }
        return -1;
    }

    private void reallocate(){
        space *= 2;
        array = Arrays.copyOf(array, space);
    }

    @Override
    public String toString(){
        String info = "[";
        for(int i = 0;i < size;i++){
            info += array[i].toString();
            if(i != size - 1)
                info += ", ";
        }
        info += "]";

        return info;
    }
}
