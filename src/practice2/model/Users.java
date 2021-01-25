package practice2.model;

import java.io.IOException;
import java.util.ArrayList;

public class Users {
    ArrayList<User> users;

    public Users() throws IOException {
        FilesReader reader = new FilesReader();
        users  = reader.readUsersFile();
    }

    public boolean userExist(String username, String password) {
        boolean validCredentials = false;
        for(User user : users) {
            if(user.validCredentials(username, password) ) {
                validCredentials = true;
                break;
            }
        }
        return validCredentials;
    }
}
