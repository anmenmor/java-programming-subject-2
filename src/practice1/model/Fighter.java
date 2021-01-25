package practice1.model;

public abstract class Fighter extends Character {
    protected int victories = 0;
    protected int defeats = 0;
    private final String referenceAbility;

    public Fighter(int id, String name, int strength, int agility, int endurance,
                   int intellect, int spirit, String referenceAbility) {
        super(id, name, strength, agility, endurance, intellect, spirit);
        this.referenceAbility = referenceAbility;
    }

    public void win() {
        incrementVictories();
    }

    @Override
    public void lose() {
        incrementDefeats();
        loseLives();
    }

    public Character figth(Character oponent) {
        int characterAbilityValue = -1;
        int opponentAbilityValue = -1;
        switch (referenceAbility) {
            case "strength": characterAbilityValue = strength;
                opponentAbilityValue = oponent.strength;
                break;
            case "agility": characterAbilityValue = agility;
                opponentAbilityValue = oponent.agility;
                break;
            case "endurance": characterAbilityValue = endurance;
                opponentAbilityValue = oponent.endurance;
                break;
            case "intellect": characterAbilityValue = intellect;
                opponentAbilityValue = oponent.intellect;
                break;
            case "spirit": characterAbilityValue = spirit;
                opponentAbilityValue = oponent.spirit;
                break;
        }
        if(characterAbilityValue >= opponentAbilityValue) {
            win();
            oponent.lose();
            return this;

        } else {
            if (oponent instanceof Fighter) {
                ((Fighter)oponent).win();
            }
            lose();
            return oponent;
        }
    }

    public void incrementVictories() {
        victories++;
    }

    public void incrementDefeats() {
        defeats++;
    }

    @Override
    public String toString() {
        return super.toString() +
                "victories=" + victories +
                ", defeats=" + defeats;
    }
}
