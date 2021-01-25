package session7.exercise1;


    import java.util.Date;

    public class Game {
        private Date when;
        private Sport sport;
        private Team team1;
        private Team team2;
        private String result;


        public Game(Date when, Sport sport, Team team1, Team team2) {
            this.when = when;
            this.sport = sport;
            this.team1 = team1;
            this.team2 = team2;
        }
        public String getResult() {
            return result;
        }
        public void setResult(String result) {
            this.result = result;
        }
        public Sport getSport() {
            return sport;
        }
        public void setSport(Sport sport) {
            this.sport = sport;
        }
        public Team getTeam1() {
            return team1;
        }
        public void setTeam1(Team team1) {
            this.team1 = team1;
        }
        public Team getTeam2() {
            return team2;
        }
        public void setTeam2(Team team2) {
            this.team2 = team2;
        }
        public String toString() {
            StringBuffer buffer = new StringBuffer();
            buffer.append(when).append(" : Game of ").append(sport).append(" between ").append(team1.getName()).append(" and ").append(team2.getName());
            return buffer.toString();
        }
    }

