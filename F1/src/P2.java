import java.util.ArrayList;

public class P2 {

    /** Deletes the first occurrence of target in aList. **/
    public static void delete(ArrayList<String> aList, String target){
        for(int i = 0;i < aList.size();i++){
            if(aList.get(i).equals(target))
                aList.remove(i);
        }
    }

    public static void main(String[] args){

    }
}
