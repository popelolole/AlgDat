import java.util.Iterator;
import java.util.NoSuchElementException;

public class SingleLinkedList<E> implements Iterable<E>{

    private static class Node<E> {
        private E data;
        private Node<E> next;

        public Node(E data, Node<E> next){
            this.data = data;
            this.next = next;
        }
    }

    private Node<E> head;

    public SingleLinkedList(){
        head = null;
    }

    public boolean add(E item){
        add(size(), item);
        return true;
    }

    public void add(int index, E item){
        if (index < 0 || index > size()) {
            throw new IndexOutOfBoundsException(Integer.toString(index));
        }
        if(index == 0){
            addFirst(item);
        }else{
            Node<E> node = getNode(index - 1);
            addAfter(node, item);
        }
    }

    private void addFirst(E item){
        head = new Node<E>(item, head);
    }

    private void addAfter(Node<E> node, E item){
        node.next = new Node<E>(item, node.next);
    }

    private Node<E> getNode(int index){
        Node<E> node = head;
        for(int i = 0;i < index && node != null;i++){
            node = node.next;
        }
        return node;
    }

    public E get(int index){
        if(index < 0 || index >= size()){
            throw new IndexOutOfBoundsException(Integer.toString(index));
        }
        Node<E> node = getNode(index);
        return node.data;
    }

    public int size(){
        int size = 0;
        Node<E> node = head;
        while(node != null){
            node = node.next;
            size++;
        }
        return size;
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder("[");
        Node<E> p = head;
        if(p != null){
            while(p.next != null){
                sb.append(p.data.toString());
                sb.append(" ==> ");
                p = p.next;
            }
            sb.append(p.data.toString());
        }
        sb.append("]");
        return sb.toString();
    }

    public Iterator<E> iterator(){
        return new Itr(head);
    }

    private class Itr implements Iterator<E> {
        int index;
        boolean canRemove;
        Node<E> current;
        Node<E> bc;
        Node<E> bbc;

        public Itr(Node<E> start){
            current = start;
            canRemove = false;
            index = 0;
        }

        @Override
        public boolean hasNext(){
            return current != null;
        }

        @Override
        public E next(){
            if(current == null){
                throw new NoSuchElementException();
            }
            index++;
            E returnValue = current.data;
            bbc = bc;
            bc = current;
            current = current.next;
            canRemove = true;
            return returnValue;
        }

        @Override
        public void remove(){
            if(!canRemove)
                throw new IllegalStateException();
            if(index == 1) {
                head = current;
            }
            else {
                bbc.next = current;
                bc = bbc;
            }
            canRemove = false;
            index--;
            if(size() == 0){
                bc = null;
                bbc = null;
            }
        }
    }
}
