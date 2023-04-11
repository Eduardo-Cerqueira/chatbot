import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Entrez votre pseudo : ");
        String pseudo = scanner.nextLine();

        try {
            User user = new User(pseudo);
            System.out.println("Votre pseudo est : " + user.getPseudo());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
