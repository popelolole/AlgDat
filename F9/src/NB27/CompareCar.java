package NB27;

import java.util.Comparator;

public class CompareCar implements Comparator<Car> {

    @Override
    public int compare(Car o1, Car o2) {
        return o1.getYear().compareTo(o2.getYear());
    }
}
