package session2.Exercise3.task1;

public abstract class Employee {

    protected String name;
    protected String address;
    protected String phoneNumber;
    protected float experience;
    protected int facebookID;

    public Employee(String name, String address, String phoneNumber, float experience, int facebookID) {
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.experience = experience;
        this.facebookID = facebookID;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public float getExperience() {
        return experience;
    }

    public int getFacebookID() {
        return facebookID;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setExperience(float experience) {
        this.experience = experience;
    }

    public void setFacebookID(int facebookID) {
        this.facebookID = facebookID;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", experience=" + experience +
                ", facebookID=" + facebookID +
                '}';
    }

    public String display() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", experience=" + experience +
                ", facebookID=" + facebookID +
                '}';
    }
}