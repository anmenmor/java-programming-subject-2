package session4.term1.exercise2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        // Creating object of List<Integer>
        List<Integer> arrlist = new ArrayList<>();

        // adding element to arrlist
        arrlist.add(1);
        arrlist.add(3);
        arrlist.add(34);
        arrlist.add(9);
        arrlist.add(3);
        arrlist.add(12);
        arrlist.add(5);
        arrlist.add(12);

        for (Integer elem : arrlist) {
            System.out.println(elem);
        }

        Collections.sort(arrlist);
        for (Integer elem : arrlist) {
            System.out.println(elem);
        }
        Collections.reverse(arrlist);
        for (Integer elem : arrlist) {
            System.out.println(elem);
        }
    }
}
