import java.util.EmptyStackException;

public class LinkedStack<E> implements StackInt<E>{
    private static class Node<E>{
        private E data;
        private Node<E> next;

        private Node(E dataItem, Node<E> nodeRef){
            data = dataItem;
            next = nodeRef;
        }
    }

    private Node<E> top;

    public LinkedStack(){
        top = null;
    }

    public int size(){
        int size = 0;
        Node<E> p = top;
        while(p != null){
            size++;
            p = p.next;
        }
        return size;
    }

    @Override
    public E push(E obj) {
        top = new Node<E>(obj, top);
        return obj;
    }

    @Override
    public E peek(){
        if(empty()){
            throw new EmptyStackException();
        }
        return top.data;
    }

    public E peek(int n){
        if(empty())
            throw new EmptyStackException();
        Node<E> p = top;
        for(int i = 0;i < n;i++){
            if(p.next == null)
                throw new IndexOutOfBoundsException();
            p = p.next;
        }
        return p.data;
    }

    @Override
    public E pop() {
        if(empty())
            throw new EmptyStackException();
        E result = top.data;
        top = top.next;
        return result;
    }

    @Override
    public boolean empty() {
        return top == null;
    }

    public E flush(){
        if(empty())
            throw new EmptyStackException();
        Node<E> p = top;
        while(p.next != null){
            p = p.next;
        }
        top = null;
        return p.data;
    }
}
