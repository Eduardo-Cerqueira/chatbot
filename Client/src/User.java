public class User {
    String pseudo;
    String address;
    String port;

    public User(String pseudo,String address,String port) {
        this.pseudo = pseudo;
        this.address = address;
        this.port = port;
    }

    public String getPseudo() {
        return this.pseudo;
    }
    public String getAddress() {
        return this.address;
    }
    public String getPort() {
        return this.port;
    }

    public static String toString(User user) {
        String userString = "Name: " + user.getPseudo();
        return userString;
    }
}
