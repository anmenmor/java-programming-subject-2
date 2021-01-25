package session1.term2.Exercise10;

import java.util.ArrayList;

public class VideoLibrary {

    private ArrayList<Film> films;

    public VideoLibrary() {
        films = new ArrayList<>();
    }

    public void addFilm(Film film) {
        boolean exit = false;
        if (films.isEmpty()) {
            films.add(film);
            System.out.println("Película introducida");
        } else {
            for (int i = 0; i < films.size(); i++) {
                if (films.get(i).getTitle().equals(film.getTitle())) {
                    exit = true;
                }
            }
            if (!exit) {
                films.add(film);
                System.out.println("Película introducida");
            } else {
                System.out.println("La película ya había sido añadida");
            }
        }
    }

    public Film seekFilm(String title) {
        for (int i = 0; i < films.size(); i++) {
            if (films.get(i).getTitle().equalsIgnoreCase(title)) {
                return films.get(i);
            }
        }
        return null;
    }

    public void listFilms() {
        for (int i = 0; i < films.size(); i++) {
            System.out.println(films.get(i).toString());
        }
    }

    public int voteFilm(String title, int vote) {
        int votes = 0;
        for (int i = 0; i < films.size(); i++) {
            if (films.get(i).getTitle().equals(title)) {
                votes = films.get(i).getNumberVotes();
                votes += vote;
                films.get(i).setNumberVotes(votes);
            }
        }
        return votes;

    }
}
