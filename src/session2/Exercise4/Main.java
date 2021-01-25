package session2.Exercise4;

public class Main {

    public static void main(String[] args) {

        Main programa = new Main();
        programa.inicio();

    }

    public void inicio(){
        Animal a;
        //test a spider with a spider reference
        Spider s = new Spider();
        s.eat();
        s.walk();
        //test a spider with an animal reference
        a = new Spider();
        a.eat();
        a.walk();
        Cat c = new Cat();
        Animal f = new Fish("Nemo");
        c.eat();
        c.walk();
        c.play();
        f.eat();
        f.walk();
        ((Fish)f).play();
        playWithAnimal(c);
        playWithAnimal(s);
        playWithAnimal(f);
    }

    public void playWithAnimal(Animal a) {
        if (a instanceof Pet){
            ((Pet) a).play();
        }else{
            System.out.println("Danger! Wild animal");
        }

    }

}
