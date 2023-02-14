import java.util.Arrays;
import java.util.EmptyStackException;

public class ArrayStack<E> implements StackInt<E>{
    private E[] data;
    private int top;
    private int space;

    public ArrayStack(){
        top = -1;
        space = 10;
        data = (E[]) new Object[space];
    }

    @Override
    public E push(E obj){
        if(top == space - 1)
            reallocate();
        data[++top] = obj;
        return obj;
    }

    @Override
    public E peek() {
        if(empty()){
            throw new EmptyStackException();
        }
        return data[top];
    }

    @Override
    public E pop() {
        if(empty()){
            throw new EmptyStackException();
        }
        return data[top--];
    }

    @Override
    public boolean empty() {
        return top == -1;
    }

    private void reallocate(){
        space *= 2;
        data = Arrays.copyOf(data, space);
    }
}
