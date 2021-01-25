package session4.term2.exercise1;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Main {
    private static int[] anArray;

    public static void main(String args[]) throws Exception {
        Random rand = new Random();
        anArray = new int[rand.nextInt(20)]; //Get an array with a random length 
        // Let's fill the array 
        for (int j = 0; j < anArray.length; j++) {
            anArray[j] = rand.nextInt(100); //Get a random integer between 0 and 99 
        }
        Scanner entry = new Scanner(System.in);
        boolean yn = true;
        while (yn) {
            System.out.println("Here is our Integer Array:");
            System.out.println(Arrays.toString(anArray));
            System.out.print("Enter the index you want to display: ");
            try {
                int selection = entry.nextInt();
                System.out.println("Your selction:[" + anArray[selection] + "]");
            }
            catch (InputMismatchException e){
                entry.nextLine();
                System.out.println("Lo que has introducido no es un numero");
            }
            catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("El numero introducido no es valido");
            }
            catch (Exception e) {
                System.out.println("Exception general");
            }

            System.out.println("Exit application?: yes or no");
            String decision = entry.next();
            switch (decision) {
                case "yes":
                    yn = false;
                    break;
                case "no":
                    yn = true;
                    break;
                default:
                    System.out.println("please enter again ");
            }
        }
    }
}

