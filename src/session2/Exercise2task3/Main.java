package session2.Exercise2task3;

public class Main {
    public static void main(String[] args) {
        Programmer programmer = new Programmer();
        programmer.name = "maría";
        System.out.println(programmer.name);
        programmer.writeCode();

        Manager manager = new Manager();
        manager.phoneNumber = "45678";
        System.out.println(manager.phoneNumber);
        manager.reportProjectStatus();
        manager.teamSize = 7;
        System.out.println(manager.teamSize);

        HR hr = new HR();
        hr.facebookID = 3;
        manager.facebookID = 4;
        hr.experience = 8;
        hr.managePayroll();
        System.out.println(hr.facebookID);
        System.out.println(manager.facebookID);
        System.out.println(hr.experience);
    }
}