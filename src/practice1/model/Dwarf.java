package practice1.model;

public class Dwarf extends Character{
    public Dwarf(int id, String name) {
        super(id, name, 26, 17, 24, 17, 23);
    }

    @Override
    public void lose() {
        loseLives();
    }

    @Override
    public String toString() {
        return "Dwarf{" + super.toString() + "}";
    }
}
