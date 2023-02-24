public class NB25 {
    public static void main(String[] args){
        HashTableBucket<String, Integer> hash = new HashTableBucket<>(37);
        System.out.println(hash.space());
        for(int i = 0;i < 25;i++)
            hash.put("x" + i, i);
        System.out.println(hash.toString());
        System.out.println(hash.space());
        for(int i = 25;i < 50;i++)
            hash.put("x" + i, i);
        System.out.println(hash.toString());
        System.out.println(hash.space());

    }
}
