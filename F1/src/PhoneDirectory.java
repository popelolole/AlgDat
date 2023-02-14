import java.util.*;
import javax.swing.*;

public class PhoneDirectory {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        List<DirectoryEntry> phoneList = new ArrayList<DirectoryEntry>();
        while(true){
            String name = JOptionPane.showInputDialog("Vänligen ange namn eller enter för att avsluta");
            if(name.equals(""))
                break;
            String number = JOptionPane.showInputDialog("Vänligen ange nummer");
            phoneList.add(new DirectoryEntry(name,number));
        }
        while(true){
            String name = JOptionPane.showInputDialog("Vem vill du söka efter?");
            if(name.equals(""))
                break;
            int index = phoneList.indexOf(new DirectoryEntry(name,""));
            if(index!=-1)
                System.out.println("Nummer: "+phoneList.get(index).number);
            else
                System.out.println("Saknas");
        }
        System.out.println("Hej då");
    }
    
}
