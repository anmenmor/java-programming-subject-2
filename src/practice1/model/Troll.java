package practice1.model;

public class Troll extends Fighter {
    public Troll(int id, String name) {
        super(id, name, 15, 9, 22, 7, 19, "endurance");
    }

    @Override
    public String toString() {
        return "Troll{" + super.toString() + '}';
    }
}
