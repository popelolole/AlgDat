public class NB24 {
    public static void main(String[] args){
        HashTableBucket<String, Integer> hash = new HashTableBucket<>(37);
        hash.put("Cat", 15);
        hash.put("Fire", 21);
        hash.put("Cool", 1111111);
        hash.put("Michelle", 29);
        hash.put("Abbabdb", 51515);
        System.out.println(hash.toString());
        hash.remove("Fire");
        System.out.println(hash.toString());
    }
}
