package session4.term1.exercise3;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String args[]) {

        Queue<Bicycle> list = new LinkedList<>();

        Bicycle bicycle = new Bicycle(true, BicycleType.HYBRID);
        Bicycle bicycle2 = new Bicycle(true, BicycleType.TRIATLON);
        Bicycle bicycle3 = new Bicycle(false, BicycleType.MOUNTAIN);
        Bicycle bicycle4 = new Bicycle(false, BicycleType.ROAD);
        Bicycle bicycle5 = new Bicycle(true, BicycleType.CYCLOCROSS);
        Bicycle bicycle6 = new Bicycle(false, BicycleType.COMMUTING);

        list.add(bicycle);
        list.add(bicycle2);
        list.add(bicycle3);
        list.add(bicycle4);
        list.add(bicycle5);
        list.add(bicycle6);

        while (true) {
            Bicycle bike = list.poll();
            if (bike.isAppovedBudget()) {
                switch (bike.getBicycleType()) {
                    case MOUNTAIN:
                    case ROAD:
                    case TRIATLON:
                    case BMX:
                        System.out.println("Se repara in situ");
                        break;
                    case HYBRID:
                    case COMMUTING:
                    case CYCLOCROSS:
                        System.out.println("Se manda a fabrica");
                        break;
                }
            } else {
                list.offer(bike);
            }
            if (list.isEmpty()){
                break;
            }

        }
    }
}

