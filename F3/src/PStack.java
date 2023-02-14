import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.List;

public class PStack<E> implements StackInt<E>{
    private List<E> list;

    public PStack(){
        list = new ArrayList<>();
    }

    @Override
    public E push(E obj) {
        list.add(obj);
        return obj;
    }

    @Override
    public E peek() {
        if(empty())
            throw new EmptyStackException();
        return list.get(list.size() - 1);
    }

    @Override
    public E pop() {
        if(empty())
            throw new EmptyStackException();
        return list.remove(list.size() - 1);
    }

    @Override
    public boolean empty() {
        return list.size() == 0;
    }
}
