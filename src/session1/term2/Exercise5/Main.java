package session1.term2.Exercise5;

public class Main {
    public static void main(String[] args) {
        Rectangle rectangle1 = new Rectangle(3, 5);
        Rectangle rectangle2 = new Rectangle(5, 5, 6,8 );
        Point point = new Point(1 , 2);
        Rectangle rectangle3 = new Rectangle(7, 7, point);
        rectangle1.displayInformation();
        rectangle2.displayInformation();
        rectangle3.displayInformation();
    }
}
