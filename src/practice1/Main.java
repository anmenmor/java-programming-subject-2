package practice1;

import practice1.model.Menu;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Menu menu = new Menu(new Scanner(System.in));
        menu.display();
    }
}
