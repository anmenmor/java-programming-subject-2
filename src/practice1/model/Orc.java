package practice1.model;

public class Orc extends Fighter {
    public Orc(int id, String name) {
        super(id, name, 24, 22, 23, 16, 21, "strength");
    }

    @Override
    public String toString() {
        return "Orc{" + super.toString() + '}';
    }
}
