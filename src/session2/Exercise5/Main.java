package session2.Exercise5;

import java.awt.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Figure r = new Rectangle(3,5, Color.black,Color.blue,12, 7, 8);
        r.draw();
        Figure c = new Circle(7, 5, Color.cyan, Color.green,25, 6);
        c.draw();
        Figure t = new Triangle(9, 4, Color.magenta, Color.red,16, 8, 2);
        t.draw();
        ((Rectangle)r).setHeigth(10);
        r.draw();
        Figure[] arrayFigure = new Figure[3];
        arrayFigure[0] = new Rectangle(3,5, Color.black,Color.blue,12, 7, 8);
        arrayFigure[1] = new Circle(7, 5, Color.cyan, Color.green,25, 6);
        arrayFigure[2] = new Triangle(9, 4, Color.magenta, Color.red,16, 8, 2);
        for(int i = 0; i < arrayFigure.length; i++){
            System.out.println(arrayFigure[i].getClass().getSimpleName() + ", area: " + arrayFigure[i].getArea());
        }
        Arrays.sort(arrayFigure);
        for(int i = 0; i < arrayFigure.length; i++){
            System.out.println(arrayFigure[i].getClass().getSimpleName() + ", area: " + arrayFigure[i].getArea());
        }
    }
}
