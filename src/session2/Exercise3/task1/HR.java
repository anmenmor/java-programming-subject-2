package session2.Exercise3.task1;

public class HR extends session2.Exercise3.task1.Employee {

    public HR(String name, String address, String phoneNumber, float experience, int facebookID) {
        super(name, address, phoneNumber, experience, facebookID);
    }

    public void managePayroll(){
        System.out.println("Managing Payroll");
    }

    public String display() {
        return "HR{"+super.display()+"}";
    }
}
