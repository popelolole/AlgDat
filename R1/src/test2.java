public class test2 {
    public static void main(String[] args){
        LinkedList2<String> l = new LinkedList2<>();
        for(int i=0; i<4; i++){l.add("e" + i);}
        l.remove(3);
        l.add(0, "först");
        l.add("sist");
        System.out.println(l);
    }
}
