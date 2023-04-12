import java.util.Scanner;

public class Menu {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choix = 0;

        while (choix != 4) {
            System.out.println("=== Menu ===");
            System.out.println("1. Liste des utilisateurs connectées");
            System.out.println("2. Ecrire un message publique");
            System.out.println("3. Ecrire un message privé");
            System.out.println("4. Créer un groupe");
            System.out.println("5. Se déconnecter du serveur");
            System.out.print("Entrez votre choix : ");
            choix = scanner.nextInt();

            switch (choix) {
                case 1:
                    System.out.println("Utilisateurs connectés");
                    break;
                case 2:
                    System.out.println("Saisissez votre message");
                    break;
                case 3:
                    System.out.println("Saisissez votre message");
                    break;
                case 4:
                    System.out.println("Choisissez des utilisateurs");
                    break;
                case 5:
                    System.out.println("Au revoir !");
                    break;
                default:
                    System.out.println("Choix invalide, veuillez réessayer");
                    break;
            }

            System.out.println();
        }

        scanner.close();
    }

}
