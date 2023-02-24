public class Heap <E extends Comparable<E>> {
    int size;
    E[] data;
    int nextPos;

    @SuppressWarnings("unchecked")
    public Heap(int size){
        this.size = size;
        data = (E[]) new Comparable[size];
        nextPos = 0;
    }

    @SuppressWarnings("All")
    public boolean insert(E data){
        if(nextPos > size){
           resize();
        }
        this.data[nextPos++] = data;

        int child = nextPos - 1;
        int parent = (child - 1) / 2;
        while(parent >= 0 && this.data[child].compareTo(this.data[parent]) < 0){
            swap(child, parent);
            child = parent;
            parent = (child - 1) / 2;
        }
        return true;
    }

    public E extract(){
        E data = this.data[0];

        int parent = 0;

        swap(parent, nextPos - 1);
        while(true){
            int left = parent * 2 + 1;
            if(left >= nextPos)
                break;
            int right = left + 1;
            int min = left;
            if(right < nextPos && this.data[left].compareTo(this.data[right]) > 0)
                min = right;

            if(this.data[parent].compareTo(this.data[min]) > 0){
                swap(parent, min);
                parent = min;
            }
            else
                break;
        }
        nextPos--;
        return data;
    }

    @SuppressWarnings("unchecked")
    private void resize(){
        size *= 2;
        E[] copy = (E[]) new Comparable[size];
        System.arraycopy(data, 0, copy, 0, data.length);
        data = copy;
    }

    private void swap(int a, int b){
        E tmp = data[a];
        data[a] = data[b];
        data[b] = tmp;
    }

    public String toString(){
        StringBuilder sb = new StringBuilder("[");
        for(int i = 0;i < nextPos;i++){
            sb.append(data[i]);
            if(i != nextPos - 1)
                sb.append(", ");
        }
        sb.append("]");
        return sb.toString();
    }
}
