package session4.term1.exercise3;

public class Bicycle {
    boolean appovedBudget;
    BicycleType bicycleType;

    public Bicycle(boolean appovedBudget, BicycleType bicycleType){
        this.appovedBudget = appovedBudget;
        this.bicycleType = bicycleType;
    }

    @Override
    public String toString() {
        return "Bicycle{" +
                "appovedBudget=" + appovedBudget +
                ", bicycleType=" + bicycleType +
                '}';
    }

    public boolean isAppovedBudget() {
        return appovedBudget;
    }

    public BicycleType getBicycleType() {
        return bicycleType;
    }

    public void setAppovedBudget(boolean appovedBudget) {
        this.appovedBudget = appovedBudget;
    }

    public void setBicycleType(BicycleType bicycleType) {
        this.bicycleType = bicycleType;
    }
}
