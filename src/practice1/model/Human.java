package practice1.model;

public class Human extends Character{
    public Human(int id, String name) {
        super(id, name, 12, 17, 11, 20, 23);
    }

    @Override
    public void lose() {
        loseLives();
    }

    @Override
    public String toString() {
        return "Human{" + super.toString() + '}';
    }
}
