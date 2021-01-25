package session2.Exercise5;

import java.awt.*;
import java.lang.reflect.Array;
import java.util.Arrays;

public class Rectangle extends Figure {
    private int base;
    private int heigth;

    public Rectangle(int x, int y, Color backgroundColor, Color lineColor, int lineWidth, int base, int heigth) {
        super(x, y, backgroundColor, lineColor, lineWidth);
        this.base = base;
        this.heigth = heigth;
    }

    public void setBase(int base) {
        this.base = base;
    }

    public void setHeigth(int heigth) {
        this.heigth = heigth;
    }

    @Override
    public void draw() {
        System.out.println("Drawing Rectangle: x -> " + x + ", y -> " + y + ", backgroundColor -> " + backgroundColor +
                ", lineColor -> " + lineColor + ", lineWidth -> " + lineWidth  + ", base -> " + base +
                ", heigth -> " + heigth);

    }

    @Override
    public double getArea() {
        return base * heigth;
    }

    @Override
    public double getPerimeter() {
        return base * 2 + heigth * 2;
    }


    @Override
    public int compareTo(Figure o) {
        return Double.compare(getArea(), o.getArea());
    }
}
