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
                    System.out.println("Message publique");

                    int Choix2 = 0;
                    while (Choix2 != 3) {
                        System.out.println("1. Envoyer un message");
                        System.out.println("2. Retourner au menu principal");
                        System.out.print("Entrez votre choix: ");
                        Choix2 = scanner.nextInt();
                    }
                    break;
                case 3:
                    System.out.println("Message privée");
                    int Choix3 = 0;
                    while (Choix3 != 3) {
                        System.out.println("1. Envoyer un message");
                        System.out.println("2. Retourner au menu principal");
                        System.out.print("Entrez votre choix:");
                        Choix3 = scanner.nextInt();
                    }
                    break;
                case 4:
                    System.out.println("Créer un groupe");
                    int Choix4 = 0;
                    while (Choix4 != 3) {
                        System.out.println("1. Ajouter un utilisateur");
                        System.out.println("2. Retirer un utilisateur (admin only)");
                        System.out.println("3. Quitter le groupe");
                        System.out.println("Retourner au menu principal");
                        System.out.print("Entrez votre choix)");
                        Choix4 = scanner.nextInt();
                    }

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
