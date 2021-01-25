package session1.term2.Exercise5;

public class Rectangle {

    private Point origin;
    private int width;
    int heigth;

    public Rectangle(int x, int y, int width, int heigth){
        this.origin = new Point(x, y);
        this.width = width;
        this.heigth = heigth;
    }
    public Rectangle(int width, int heigth){
        this.origin = new Point(0, 0);
        this.width = width;
        this.heigth = heigth;
    }
    public Rectangle(int width, int heigth, Point point){
        this.origin = point;
        this.width = width;
        this.heigth = heigth;
    }

    public int area(){
        return width * heigth;
    }

    @Override
    public String toString() {
        return "Rectangle{" +
                "origin=" + origin +
                ", width=" + width +
                ", heigth=" + heigth +
                '}'+"\nArea: "+area();
    }

    public void displayInformation(){
        System.out.println(toString());

    }
}
