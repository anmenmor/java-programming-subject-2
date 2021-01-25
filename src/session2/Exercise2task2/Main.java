package session2.Exercise2task2;

import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        Programmer programmer = new Programmer();
        programmer.name = "maría";
        System.out.println(programmer.name);
        programmer.writeCode();
        programmer.programmingLanguages = new String[]{"a", "b"};
        for(int x = 0; x < programmer.programmingLanguages.length; x++) {
            System.out.println(programmer.programmingLanguages[x]);
        }

        Manager manager = new Manager();
        manager.phoneNumber = "45678";
        System.out.println(manager.phoneNumber);
        manager.reportProjectStatus();
        manager.teamSize = 7;
        System.out.println(manager.teamSize);
    }
}
