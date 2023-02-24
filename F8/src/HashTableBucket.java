import java.util.Iterator;

public class HashTableBucket<K,V> {
    private static class Entry<K,V>{
        public K key;
        public V value;
        public Entry(K k, V v){
            key = k;
            value = v;
        }

        @Override
        public String toString(){
            StringBuilder sb = new StringBuilder("[");
            sb.append(key).append(" : ").append(value).append("]");
            return sb.toString();
        }
    }

    private SingleLinkedList<Entry<K,V>>[] table;
    int size;

    @SuppressWarnings("unchecked")
    public HashTableBucket(int size){
        table = new SingleLinkedList[size];
    }

    public V put(K key, V value){
        if(size >= 0.75 * table.length)
            rehash();
        int index = key.hashCode()%table.length;
        if(index < 0)
            index += table.length;
        if(table[index] == null) {
            table[index] = new SingleLinkedList<Entry<K,V>>();
            table[index].add(new Entry<K,V>(key, value));
            size++;
            return null;
        }
        else{
            V oldValue;
            for(Entry<K,V> e : table[index]){
                if(e.key.equals(key)){
                    oldValue = e.value;
                    e.value = value;
                    return oldValue;
                }
            }
            table[index].add(0, new Entry<K,V>(key,value));
            return null;
        }
    }

    public V get(K key){
        int index = key.hashCode() & table.length;
        if(index < 0)
            index += table.length;
        if(table[index] == null)
            return null;
        for(Entry<K,V> e : table[index]){
            if(e.key.equals(key))
                return e.value;
        }
        return null;
    }

    public V remove(K key){
        int index = key.hashCode() % table.length;
        if(index < 0)
            index += table.length;
        if(table[index] == null)
            return null;
        Iterator<Entry<K,V>> iter = table[index].iterator();
        while(iter.hasNext()){
            Entry<K,V> e = iter.next();
            if(e.key.equals(key)) {
                iter.remove();
                if(table[index].size() == 0) {
                    table[index] = null;
                    size--;
                }
                return e.value;
            }
        }
        return null;
    }

    public int space(){
        return table.length;
    }

    @SuppressWarnings("unchecked")
    private void rehash(){
        SingleLinkedList<Entry<K,V>>[] copy = new SingleLinkedList[table.length * 2];
        for(int i = 0;i < table.length;i++){
            if(table[i] != null) {
                for (Entry<K, V> e : table[i]) {
                    int index = e.key.hashCode() % copy.length;
                    if (index < 0)
                        index += copy.length;
                    if (copy[index] == null) {
                        copy[index] = new SingleLinkedList<Entry<K, V>>();
                        copy[index].add(new Entry<K, V>(e.key, e.value));
                    } else {
                        copy[index].add(0, new Entry<K, V>(e.key, e.value));
                    }
                }
            }
        }
        table = copy;
    }

    @Override
    public String toString(){
        StringBuilder info = new StringBuilder();
        for(int i = 0;i < table.length;i++){
            if(table[i] != null) {
                info.append(i).append(": ");
                for (Entry<K, V> e : table[i]) {
                    if (e != null)
                        info.append(e.toString()).append(", ");
                }
                info.append("\n");
            }
        }
        return info.toString();
    }
}
