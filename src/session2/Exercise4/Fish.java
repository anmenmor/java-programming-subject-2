package session2.Exercise4;

public class Fish extends Animal implements Pet {

    private String name;

    public Fish(String name) {
        super(0);
        this.name = name;
    }

    @Override
    public void eat() {
        System.out.println("Fish eat pond srum");
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void play() {
        System.out.println("Just keep swimming");
    }

    @Override
    public void walk() {
        super.walk();
        System.out.println("Fish, of course, can`t walk, they swim");
    }
}
