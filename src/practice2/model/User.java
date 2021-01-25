package practice2.model;

public class User {
    private final String username;
    private final String password;



    public User (String username, String password) {
        this.username = username;
        this.password = password;
    }

    public boolean validCredentials(String username, String password){
        return this.username.equals(username) && this.password.equals(password);
    }

    @Override
    public String toString() {
        return "User{" +
                "userName='" + username + '\'' +
                ", password=" + password +
                '}';
    }
}
