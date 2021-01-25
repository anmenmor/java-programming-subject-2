package session4.term2.exercise3;

import java.util.*;

public class Main {

    private static String[] users;
    private static int userLimitLength = 15;
    private static List<String> names = Arrays.asList("ANTONIO","JOSE","...");
    private static List<String> surnames = Arrays.asList("GARCIA","GONZALEZ","...");
    private static List<String> checkedUsers = new ArrayList<>();

    public static void main(String[] args) {
        Scanner entry = new Scanner(System.in);
        System.out.println("Wellcome to the users generator.");
        System.out.println("How many users do you need?");
        int quantity = entry.nextInt();
        users = generate(quantity);
        for (String user : users) {
            try {
                String verifiedUser = checkUser(user);
                checkedUsers.add(verifiedUser);
            } catch (Checked ignored) {

            } catch (Unchecked e) {
                System.exit(-1);
            }
        }

    }
    private static String[] generate(int quantity) {
        String[] usersnew = new String[quantity];
        for (int j = 0; j < usersnew.length; j++) usersnew[j] = getName();
        return usersnew;
    }
    private static String getName() {
        Random rand = new Random();
        return String.format("%s %s %s", names.get(rand.nextInt(names.size())),
                surnames.get(rand.nextInt(surnames.size())),
                surnames.get(rand.nextInt(surnames.size())));
    }

    private static String checkUser(String name) throws Checked, Unchecked {
        if(checkedUsers.contains(name)) {
            throw new Checked();
        } else if ( name.length() > userLimitLength) {
            throw new Unchecked();
        } else {
            return name;
        }
    }
}


