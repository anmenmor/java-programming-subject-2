package session1.term2.Exercise10;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        VideoLibrary myVideoLibrary = new VideoLibrary();

        int option;
        do{
            System.out.println("Menú Videoteca: 1.Nueva película. 2.Busca película. 3.Lista película." +
                    "4.Vota película. 5.Salir. Introduce una opción.");
            option = input.nextInt();
            input.nextLine();
            switch (option) {
                case 1: {
                    System.out.println("Introduzca el título");
                    String title = input.nextLine();
                    System.out.println("Introduzca los votos");
                    int vote = input.nextInt();
                    input.nextLine();
                    Film film = new Film(title, vote);
                    myVideoLibrary.addFilm(film);
                    break;
                }
                case 2: {
                    System.out.println("Introduce el título a buscar");
                    String title = input.nextLine();
                    Film film = myVideoLibrary.seekFilm(title);
                    if(film != null) {
                        System.out.println(film.toString());
                    } else {
                        System.out.println("la película no existe");
                    }
                    break;
                }
                case 3: {
                    myVideoLibrary.listFilms();
                    break;
                }
                case 4: {
                    System.out.println("Introduce el título a buscar");
                    String title = input.nextLine();
                    System.out.println("Introduce el voto");
                    int vote = input.nextInt();
                    System.out.println("Los votos totales son: "+myVideoLibrary.voteFilm(title, vote));
                    break;
                }
                case 5:
                    break;
            }
        }while(option != 5);

    }
}
