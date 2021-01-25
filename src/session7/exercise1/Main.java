package session7.exercise1;
import org.neodatis.odb.ODB;
import org.neodatis.odb.ODBFactory;
import org.neodatis.odb.Objects;
import org.neodatis.odb.core.query.IQuery;
import org.neodatis.odb.core.query.criteria.ICriterion;
import org.neodatis.odb.core.query.criteria.Where;
import org.neodatis.odb.impl.core.query.criteria.CriteriaQuery;

import java.util.Date;

public class Main {
    public static void main(String[] args) {

        ODB odb =null;
        try{
            odb= ODBFactory.open("neodatis.example");

            Sport volleyball = new Sport("volley-ball");
            Sport football = new Sport("football");
            Sport equitation = new Sport("tennis");

            Player player1 = new Player("Maria", new Date(), volleyball);
            Player player2 = new Player("Pierre", new Date(), volleyball);
            Player player3 = new Player("Andrea", new Date(), volleyball);
            Player player4 = new Player("Sara", new Date(), volleyball);
            Player player5 = new Player("Marcia", new Date(), equitation);
            Player player6 = new Player("Oliver", new Date(), football);

            Team team1 = new Team("Paris");
            Team team2 = new Team("Montpellier");
            Team team3 = new Team("Hartpury College");
            Team team4 = new Team("Atlético Central");

            team1.addPlayer(player1);
            team1.addPlayer(player2);
            team2.addPlayer(player3);
            team2.addPlayer(player4);
            team3.addPlayer(player5);
            team4.addPlayer(player6);

            odb.store(team1);
            odb.store(team2);
            odb.store(team3);
            odb.store(team4);

            //displayPlayers(odb);
            displayTeams(odb);

        }finally {
            if(odb != null) {
                odb.close();
            }
        }

        //Update object
        try{
            odb= ODBFactory.open("neodatis.example");
            ICriterion criterio = Where.equal("name", "Oliver");
            IQuery query = new CriteriaQuery(Player.class,criterio);
            Objects<Player> players = odb.getObjects(query);
            Player player = (Player) players.getFirst();
            player.setName("Eric");
            odb.store(player);

            //displayPlayers(odb);

        }finally {
            if(odb != null) {
                odb.close();
            }
        }

        //delete object
        try{
            odb= ODBFactory.open("neodatis.example");
            ICriterion criterio = Where.equal("name", "Eric");
            IQuery query = new CriteriaQuery(Player.class,criterio);
            Objects<Player> players = odb.getObjects(query);
            Player player = (Player) players.getFirst();
            odb.delete(player);

            //displayPlayers(odb);

        }finally {
            if(odb != null) {
                odb.close();
            }
        }


    }

    private static void displayPlayers(ODB odb) {
        Objects<Player> players = odb.getObjects(Player.class);
        // display each object
        System.out.println("_____Players______");
        int i = 1;
        while (players.hasNext()) {
            System.out.println((i++) + "\t: " + players.next());
        }
        System.out.println("___________________");
    }

    private static void displayTeams(ODB odb) {
        Objects<Team> teams = odb.getObjects(Team.class);
        while (teams.hasNext()) {
            System.out.println(teams.next());
        }
    }
}

