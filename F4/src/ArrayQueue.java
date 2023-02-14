import java.util.AbstractQueue;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Queue;

public class ArrayQueue<E> extends AbstractQueue<E> implements Queue<E> {
    private int front, rear, size, space;
    private E[] data;

    @SuppressWarnings("unchecked")
    public ArrayQueue(int initialSpace){
        size = 0;
        front = 0;
        space = initialSpace;
        rear = space - 1;
        data = (E[]) new Object[space];
    }

    @Override
    public boolean offer(E element){
        if(size == space)
            reallocate();
        rear = (rear + 1) % space;
        data[rear] = element;
        size++;
        return true;
    }

    @Override
    public E peek(){
        if(size == 0)
            return null;
        return data[front];
    }

    @Override
    public E poll(){
        if(size == 0)
            return null;
        if(size == space / 4)
            scale();
        E result = data[front];
        front = (front + 1) % space;
        size--;
        return result;
    }

    @SuppressWarnings("unchecked")
    private void reallocate(){
        int newSpace = space * 2;
        E[] copy = (E[]) new Object[newSpace];
        int j = front;
        for(int i = 0;i < size;i++){
            copy[i] = data[j];
            j = (j + 1) % space;
        }
        front = 0;
        rear = size - 1;
        space = newSpace;
        data = copy;
    }

    @SuppressWarnings("unchecked")
    private void scale(){
        int newSpace = space / 2;
        E[] copy = (E[]) new Object[newSpace];
        int j = front;
        for(int i = 0;i < size;i++){
            copy[i] = data[j];
            j = (j + 1) % space;
        }
        front = 0;
        rear = size - 1;
        space = newSpace;
        data = copy;
    }

    @Override
    public Iterator<E> iterator(){
        return new Iter();
    }

    @Override
    public int size(){
        return size;
    }

    public int space(){
        return space;
    }

    private class Iter implements Iterator<E> {
        private int index;
        private int count = 0;
        public Iter(){
            index = front;
        }
        @Override
        public boolean hasNext(){
            return count < size;
        }
        @Override
        public E next(){
            if(!hasNext()){
                throw new NoSuchElementException();
            }
            E returnValue = data[index];
            index = (index + 1) % space;
            count++;
            return returnValue;
        }
        @Override
        public void remove(){
            throw new UnsupportedOperationException();
        }
    }
}
