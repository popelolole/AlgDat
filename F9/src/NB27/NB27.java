package NB27;

import java.io.*;
import java.util.ArrayList;

import static java.util.Collections.sort;

public class NB27 {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        try {
            ObjectInputStream in = new ObjectInputStream(new FileInputStream("cars.txt"));

            //ArrayList<Car> list = new ArrayList<>();
            ArrayList<Car> list = (ArrayList<Car>) in.readObject();
            in.close();

            System.out.println(list.toString());
            //Collections.sort(list);
            //Collections.sort(list, new CompareCar());

            /*list.add(new Car("Volvo", "2002-11-21", 300000));
            list.add(new Car("Saab", "1996-12-22", 50000));
            list.add(new Car("Volkswagen", "2002-10-29", 1000));
            list.add(new Car("BMW", "1972-01-12", 500000000));
            list.add(new Car("Renault", "1974-06-16", 440000));*/

            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("cars.txt"));
            out.writeObject(list);
            out.close();
        }catch(IOException io){
            throw new IOException(io);
        }
    }
}
