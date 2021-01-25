package practice3.model;

import practice3.FightGame;

import java.sql.*;
import java.util.ArrayList;

public class DBManager {
    Connection con;

    public DBManager (Connection con) {
        this.con = con;
    }

    public void createTables() {
        String charactersQuery = "CREATE TABLE IF NOT EXISTS characters" +
                "( NOM VARCHAR(30) UNIQUE NOT NULL, LIVES INT NOT NULL DEFAULT 3, TYPE VARCHAR(20) NOT NULL" +
                ", PRIMARY KEY (NOM));";
        String fightsQuery = "CREATE TABLE IF NOT EXISTS fights" +
                "( WINNER VARCHAR(20) NOT NULL, LOSER VARCHAR(20) NOT NULL, ID INT NOT NULL AUTO_INCREMENT" +
                ", PRIMARY KEY (ID), FOREIGN KEY (WINNER) REFERENCES characters (NOM), FOREIGN KEY (LOSER) REFERENCES characters (NOM));";
        String fightersResultQuery = "CREATE TABLE IF NOT EXISTS fighters_results" +
                "( NOM VARCHAR(20) UNIQUE NOT NULL, VICTORIES INT NOT NULL DEFAULT 0, DEFEATS INT NOT NULL DEFAULT 0" +
                ", PRIMARY KEY (NOM), FOREIGN KEY (NOM) REFERENCES characters (NOM));";
        try {
            Statement stmt = con.createStatement();
            stmt.executeUpdate(charactersQuery);
            stmt.executeUpdate(fightsQuery);
            stmt.executeUpdate(fightersResultQuery);
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }

    public ArrayList<Character> getCharacters() {
        ArrayList<Character> personatges = new ArrayList<>();
        String query = "SELECT * FROM characters";
        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                String nom = rs.getString("NOM");
                int lives = rs.getInt("LIVES");
                String type = rs.getString("TYPE");
                Character personaje = null;
                switch (type) {
                    case "Human":
                        Human human = new Human(nom);
                        human.setLives(lives);
                        personaje = human;
                        break;
                    case "Nan":
                        Nan nan = new Nan(nom);
                        nan.setLives(lives);
                        personaje = nan;
                        break;
                    case "Orc":
                        Orc orc = new Orc(nom);
                        orc.setLives(lives);
                        personaje = orc;
                        break;
                    case "Troll":
                        Troll troll = new Troll(nom);
                        troll.setLives(lives);
                        personaje = troll;
                        break;
                }
                if (personaje != null) {
                    personatges.add(personaje);
                }
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return personatges;
    }

    public void createCharacter(Character character, String type) throws Exception {
        Statement stmt = con.createStatement();
            String query = "INSERT INTO characters VALUES (" + "'" + character.getNom() + "',"
                    + character.getLives() + "," + "'" + type + "')";
            if (stmt.executeUpdate(query) != 1) {
                throw new Exception("Error adding character");
            }
    }

    public void createFightingResult(Character character) throws Exception {
        Statement stmt = con.createStatement();
        String query = "INSERT INTO fighters_results(NOM) VALUES (" + "'" + character.getNom() + "')";
        if (stmt.executeUpdate(query) != 1) {
            throw new Exception("Error adding fighting result");
        }
    }

    public void registerFights(Character character1, Character character2) throws Exception {
        Statement stmt = con.createStatement();
        String query = "INSERT INTO fights(WINNER, LOSER) VALUES (" + "'" + character1.getNom() + "',"
                + "'" + character2.getNom() + "')";
        if (stmt.executeUpdate(query) != 1) {
            throw new Exception("Error adding figth registers");
        }
    }

    public void updateLives(Character character) throws Exception {
        String query = "UPDATE characters SET LIVES = ? WHERE NOM = ?";
        PreparedStatement stmt = con.prepareStatement(query);
        stmt.setInt(1, character.getLives());
        stmt.setString(2, character.getNom());
        if (stmt.executeUpdate() != 1) {
            throw new Exception("Error updating lives");
        }
    }

    public void updateFightingResults(Fighter fighter) throws Exception {
        String query = "UPDATE fighters_results SET VICTORIES = ?, DEFEATS = ? WHERE NOM = ?";
        PreparedStatement stmt = con.prepareStatement(query);
        stmt.setInt(1, fighter.getVictories());
        stmt.setInt(2, fighter.getDefeats());
        stmt.setString(3, fighter.getNom());
        if (stmt.executeUpdate() != 1) {
            throw new Exception("Error updating results");
        }
    }

    public boolean nameExists (String nom) throws SQLException {
        String query = "SELECT * FROM characters WHERE NOM = ?";
        PreparedStatement stmt = con.prepareStatement(query);
        stmt.setString(1, nom);
        ResultSet rs = stmt.executeQuery();
        return rs.next();
    }

    public void deleteCharacter (Character character) throws Exception {
        String fightersResultQuery = "DELETE FROM fighters_results WHERE NOM = ?";
        String fightQuery = "DELETE FROM fights WHERE WINNER = ? OR LOSER = ?";
        String charactersQuery = "DELETE FROM characters WHERE NOM = ?";
        PreparedStatement fightersResultStmt = con.prepareStatement(fightersResultQuery);
        fightersResultStmt.setString(1, character.getNom());
        PreparedStatement fightStmt = con.prepareStatement(fightQuery);
        fightStmt.setString(1,character.getNom());
        fightStmt.setString(2,character.getNom());
        PreparedStatement chatacterStmt = con.prepareStatement(charactersQuery);
        chatacterStmt.setString(1, character.getNom());
        fightersResultStmt.executeUpdate();
        fightStmt.executeUpdate();
        if (chatacterStmt.executeUpdate() != 1) {
            throw new Exception("Error deleting character");
        }
    }
}



