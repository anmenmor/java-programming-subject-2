package session2.Exercise3.task1;

public class Main {
    public static void main(String[] args) {

        Manager manager = new Manager("ana","calle flor", "12345", 8, 78,
                6);
        System.out.println(manager.display());
        Programmer programmer = new Programmer("juan", "calle sol", "34567",
                5, 34);
        System.out.println(programmer.display());
        programmer.setProgrammingLanguages(new String[]{"a", "b"});
        for(int x = 0; x < programmer.getProgrammingLanguages().length; x++) {
            System.out.println(programmer.getProgrammingLanguages()[x]);
        }
        System.out.println(programmer.display());
    }
}
