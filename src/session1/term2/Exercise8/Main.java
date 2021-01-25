package session1.term2.Exercise8;

public class Main {
    public static void main(String[] args) {

        Person person1 = new Person();
        System.out.println(Person.instanceCount);
        System.out.println(person1.localCount);
        Person person2 = new Person();
        System.out.println(Person.instanceCount);
        System.out.println(person2.localCount);
        Person person3 = new Person();
        System.out.println(Person.instanceCount);
        System.out.println(person3.localCount);

    }
}
