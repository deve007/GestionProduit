import java.util.Scanner;

public class PersonneV2 {

    public static void main(String[] args) {
        final int taille = 100;
        Scanner sc = new Scanner(System.in);
        String[] noms = new String[taille];
        String[] prenoms = new String[taille];
        int[] ages = new int[taille];
        int cpt = 0;
        int choix;

        do {
            afficherMenu();
            choix = sc.nextInt();
            switch (choix) {

                case 1:
                    if (cpt < taille) {
                        System.out.println("\n=== AJOUT PERSONNE ===");
                        prenoms[cpt] = ChaineObligatoire(sc, "Votre prenom: ");
                        noms[cpt] = ChaineObligatoire(sc, "Votre nom: ");
                        ages[cpt] = SaisieAge(sc, "Votre age: ");
                        cpt++;
                    } else {
                        System.out.println("Tableau plein !");
                    }
                    break;

                case 2:
                    if (cpt < taille) {
                        listePersonnes(noms, prenoms, ages, cpt);
                    }
                    break;

                case 3:
                    AgeCroissants(prenoms, prenoms, ages, cpt);
                    break;

                case 4:
                    System.out.println("Au revoir !");
                    break;

                default:
                    System.out.println("Choix invalide !");
            }

        } while (choix != 4);

        sc.close();
    }

    // fonction pour le menu
    public static void afficherMenu() {
        System.out.println("\n===== MENU =====");
        System.out.println("1) Ajouter un personne");
        System.out.println("2) Lister les personnes");
        System.out.println("3) Afficher les personnes majeures");
        System.out.println("4) Quitter");
        System.out.println("\nEntrer votre choix: ");
    }

    public static String ChaineObligatoire(Scanner sc, String message) {

        String valeur;
        sc.nextLine();
        do {
            System.out.print(message);
            valeur = sc.nextLine().trim();

            if (valeur.isEmpty()) {
                System.out.println("Champ obligatoire !");
            }

        } while (valeur.isEmpty());

        return valeur;
    }

    public static int SaisieAge(Scanner sc, String message) {

        int valeur;

        do {
            System.out.print(message);
            valeur = sc.nextInt();

            if (valeur <= 0) {
                System.out.println("L'age doit être positif !");
            }

        } while (valeur <= 0);

        sc.nextLine();
        return valeur;
    }

    public static void listePersonnes(
            String[] noms,
            String[] prenoms,
            int[] ages,
            int cpt) {

        if (cpt == 0) {
            System.out.println("Aucune personne enregistrée.");
            return;
        }

        for (int i = 0; i < cpt; i++) {

            System.out.println("\n--------------------");
            System.out.println("Prenom : " + prenoms[i]);
            System.out.println("Nom : " + noms[i]);
            System.out.println("Age : " + ages[i]);
        }
    }

    public static void AgeCroissants(String[] prenoms, String[] noms, int[] ages, int cpt) {

        for (int i = 0; i < cpt; i++) {

            if (ages[i] > 18) {
                System.out.println("\nPersonnes majeures :");
                System.out.println("\n"+prenoms[i] + " " + noms[i] + ": " + ages[i]);
            }

        }

    }
}
