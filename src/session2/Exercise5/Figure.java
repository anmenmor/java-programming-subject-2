package session2.Exercise5;

import java.awt.*;

public abstract class Figure implements Measurable, Comparable<Figure> {
    protected int x;
    protected int y;
    protected Color backgroundColor;
    protected Color lineColor;
    protected int lineWidth;

    public Figure(int x, int y, Color backgroundColor, Color lineColor, int lineWidth){
        this.x = x;
        this.y = y;
        this.backgroundColor = backgroundColor;
        this.lineColor = lineColor;
        this.lineWidth = lineWidth;
    }

    public abstract void draw();

    public void setPosition(int newX, int newY){
        this.x = newX;
        this.y = newY;
    }

    public void setBackgroundColor(Color newColor){
        this.backgroundColor = newColor;
    }

    public void setLineColor(Color newColor){
        this.lineColor = newColor;
    }

    public void setLineWidth(int newWidth){
        this.lineWidth = newWidth;
    }

    @Override
    public String toString() {
        return "Figure{" +
                "x=" + x +
                ", y=" + y +
                ", backgroundColor=" + backgroundColor +
                ", lineColor=" + lineColor +
                ", lineWidth=" + lineWidth +
                '}';
    }



}
