package session7.exercise1;
import java.util.Date;

public class Player {
    private String name;
    private Date birthDate;
    private Sport favoriteSport;

    public Player(String name, Date birthDate, Sport favoriteSport) {
        this.name = name;
        this.birthDate = birthDate;
        this.favoriteSport = favoriteSport;
    }
    public Date getBirthDate() {
        return birthDate;
    }
    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }
    public Sport getFavoriteSport() {
        return favoriteSport;
    }
    public void setFavoriteSport(Sport favoriteSport) {
        this.favoriteSport = favoriteSport;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String toString() {
        return name;
    }

}
