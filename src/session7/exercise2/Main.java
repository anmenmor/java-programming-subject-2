package session7.exercise2;

import org.neodatis.odb.ODB;
import org.neodatis.odb.ODBFactory;
import org.neodatis.odb.Objects;
import org.neodatis.odb.core.query.IQuery;
import org.neodatis.odb.core.query.criteria.ICriterion;
import org.neodatis.odb.core.query.criteria.Where;
import org.neodatis.odb.impl.core.query.criteria.CriteriaQuery;
import session7.exercise1.Player;

public class Main {

    public static void main(String[] args) {
        //displayTennisPlayers();
        //displayPlayers();
        //display14YearsOldPlayers();
        displayNamesStartingWithM();
    }

    public static void createPlayers() {
        ODB odb= null;
        try{
        odb = ODBFactory.open("neodatis.jugadores");
        Jugador j1= new Jugador("María", "voleibol", "Madrid", 14);
        Jugador j2= new Jugador("Miguel", "tenis", "Madrid", 15);
        Jugador j3= new Jugador("Mario", "baloncesto", "Guadalajara", 15);
        Jugador j4= new Jugador("Alicia", "tenis", "Madrid", 14);
        // Inserto los objetos
        odb.store(j1);
        odb.store(j2);
        odb.store(j3);
        odb.store(j4);
        }finally {
            if(odb != null) {
                odb.close();
            }
        }
    }

    public static void displayPlayers() {
        ODB odb= null;
        try{
            odb= ODBFactory.open("neodatis.jugadores");
            Objects<Jugador> jugador = odb.getObjects(Jugador.class);
            while (jugador.hasNext()) {
                System.out.println(jugador.next());
            }
        }finally {
            if(odb != null) {
                odb.close();
            }
        }
    }

    public static void displayTennisPlayers() {
        ODB odb= null;
        try{
            odb= ODBFactory.open("neodatis.jugadores");
            ICriterion criterio = Where.equal("deporte", "tenis");
            IQuery query = new CriteriaQuery(Jugador.class,criterio);
            query.orderByDesc("nombre");
            query.orderByDesc("edad");
            Objects<Jugador> jugador = odb.getObjects(query);
            while (jugador.hasNext()) {
                System.out.println(jugador.next());
            }
        }finally {
            if(odb != null) {
                odb.close();
            }
        }
    }

    public static void display14YearsOldPlayers() {
        ODB odb= null;
        try{
            odb= ODBFactory.open("neodatis.jugadores");
            ICriterion criterio = Where.equal("edad", 14);
            IQuery query = new CriteriaQuery(Jugador.class,criterio);
            Objects<Jugador> jugador = odb.getObjects(query);
            while (jugador.hasNext()) {
                System.out.println(jugador.next());
            }
        }finally {
            if(odb != null) {
                odb.close();
            }
        }
    }

    public static void displayNamesStartingWithM() {
        ODB odb= null;
        try{
            odb= ODBFactory.open("neodatis.jugadores");
            ICriterion criterio = Where.like("nombre", "M%");
            IQuery query = new CriteriaQuery(Jugador.class,criterio);
            Objects<Jugador> jugador = odb.getObjects(query);
            while (jugador.hasNext()) {
                System.out.println(jugador.next());
            }
        }finally {
            if(odb != null) {
                odb.close();
            }
        }
    }
}
