package practice1.model;

public abstract class Character {
    protected final int id;
    protected final String name;
    protected final int strength;
    protected final int agility;
    protected final int endurance;
    protected final int intellect;
    protected final int spirit;
    protected int lives = 3;

    public Character(int id, String name, int strength, int agility, int endurance, int intellect, int spirit){
        this.id = id;
        this.name = name;
        this.strength = strength;
        this.agility = agility;
        this.endurance = endurance;
        this.intellect = intellect;
        this.spirit = spirit;
    }

    public void loseLives(){
        lives--;
    }

    public abstract void lose();

    @Override
    public String toString() {
        return "id=" + id +
                ", name='" + name + '\'' +
                ", strength=" + strength +
                ", agility=" + agility +
                ", endurance=" + endurance +
                ", intellect=" + intellect +
                ", spirit=" + spirit +
                ", lives=" + lives;
    }
}
