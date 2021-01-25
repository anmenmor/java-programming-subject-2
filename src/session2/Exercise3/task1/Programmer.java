package session2.Exercise3.task1;

import java.util.Arrays;

public class Programmer extends session2.Exercise3.task1.Employee {

    private String[] programmingLanguages;

    public Programmer(String name, String address, String phoneNumber, float experience, int facebookID) {
        super(name, address, phoneNumber, experience, facebookID);
    }
    public Programmer(String name, String address, String phoneNumber, float experience, int facebookID,
                      String[] programmingLanguages) {
        super(name, address, phoneNumber, experience, facebookID);
        this.programmingLanguages = programmingLanguages;
    }

    public void writeCode(){
        System.out.println("Writing code");
    }

    public String[] getProgrammingLanguages() {
        return programmingLanguages;
    }

    public void setProgrammingLanguages(String[] programmingLanguages) {
        this.programmingLanguages = programmingLanguages;
    }

    public String display() {
        return "Programmer{" + super.display()+
                "programmingLanguages=" + Arrays.toString(programmingLanguages) +
                '}';
    }
}
