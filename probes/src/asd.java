import java.util.LinkedHashMap;
import java.util.Map;

public class asd {


    public static void main(String[] args) {


        int a = 2147483647;
        int b = a + a;

        Map<Integer, String> cars = new LinkedHashMap<>();

        cars.put(new Integer(1),"krowa");
        cars.put(new Integer(2),"masło");
        cars.put(new Integer(3),"leszcz");
        System.out.println(cars);
        cars.remove(2);

        System.out.println(cars);
    }

}
