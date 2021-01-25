package session2.Exercise5;

import java.awt.*;

public class Circle extends Figure {
    private int radius;

    public Circle(int x, int y, Color backgroundColor, Color lineColor, int lineWidth, int radius) {
        super(x, y, backgroundColor, lineColor, lineWidth);
        this.radius = radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    @Override
    public void draw() {
        System.out.println("Drawing Circle: x -> " + x + ", y -> " + y + ", backgroundColor -> " + backgroundColor +
                ", lineColor -> " + lineColor + ", lineWidth -> " + lineWidth  + ", radius -> " + radius);

    }

    @Override
    public double getArea() {
        return Math.PI * (radius * radius);
    }

    @Override
    public double getPerimeter() {
        return 2 * Math.PI * radius;
    }

    @Override
    public int compareTo(Figure o) {
        return Double.compare(getArea(), o.getArea());
    }
}
