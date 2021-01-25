package session1.term2.Exercise3;

public class Person {
    private String name;

    public Person(String name){
        this.name = name;
    }

    private String getName(){
        return name;
    }

    public void sleep(){
        System.out.println("zzzzzzz");
    }

    public void speak(){
        System.out.println("bla, bla, bla");
    }

    public void tellName(){
        System.out.println("Mi nombre es "+ name);
    }
}
