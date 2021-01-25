package session2.Exercise3.task1;

public class Manager extends session2.Exercise3.task1.Employee {

    private int teamSize;

    public Manager(String name, String address, String phoneNumber, float experience, int facebookID, int teamSize) {
        super(name, address, phoneNumber, experience, facebookID);
        this.teamSize = teamSize;
    }

    public void reportProjectStatus(){
        System.out.println("Reporting Project status");
    }

    public int getTeamSize() {
        return teamSize;
    }

    public void setTeamSize(int teamSize) {
        this.teamSize = teamSize;
    }

    @Override
    public String toString() {
        return "Manager{" +
                "teamSize=" + teamSize +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", experience=" + experience +
                ", facebookID=" + facebookID +
                '}';
    }

    public String display() {
        return "Manager{"+super.display()+
                "teamSize=" + teamSize +
                '}';
    }
}
