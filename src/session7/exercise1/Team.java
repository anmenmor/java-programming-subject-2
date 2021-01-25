package session7.exercise1;

import java.util.ArrayList;
import java.util.List;

public class Team {
    private String name;
    private List<Player> players;
    public Team(String name) {
        this.name = name;
        players = new ArrayList<Player>();
    }
    /**
     * @return the name
     */
    public String getName() {
        return name;
    }
    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }
    /**
     * @return the players
     */
    public List<Player> getPlayers() {
        return players;
    }
    /**
     * @param players the players to set
     */
    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public void addPlayer(Player player){
        players.add(player);
    }

    public String toString() {
        StringBuffer buffer = new StringBuffer();
        buffer.append("Team ").append(name).append(" ").append(players);
        return buffer.toString();
    }

}
