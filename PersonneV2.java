import java.util.Scanner;

// Classe Personne
class Personne {
    String nom;
    String prenom;
    int age;
}

public class PersonneV2 {

    public static void main(String[] args) {

        final int taille = 100;
        Scanner sc = new Scanner(System.in);

        Personne[] personnes = new Personne[taille];

        int cpt = 0;
        int choix;

        do {
            afficherMenu();
            choix = sc.nextInt();

            switch (choix) {

                case 1:
                    if (cpt < taille) {

                        System.out.println("\n=== AJOUT PERSONNE ===");

                        Personne p1 = new Personne();

                        p1.prenom = ChaineObligatoire(sc, "Votre prenom : ");
                        p1.nom = ChaineObligatoire(sc, "Votre nom : ");
                        p1.age = SaisieAge(sc, "Votre age : ");

                        personnes[cpt] = p1;
                        cpt++;

                    } else {
                        System.out.println("Tableau plein !");
                    }
                    break;

                case 2:
                    listePersonnes(personnes, cpt);
                    break;

                case 3:
                    AgeCroissants(personnes, cpt);
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
        System.out.println("\nEntrer votre choix : ");
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

    public static void listePersonnes(Personne[] personnes, int cpt) {

        if (cpt == 0) {
            System.out.println("Aucune personne enregistrée.");
            return;
        }

        for (int i = 0; i < cpt; i++) {

            System.out.println("\n--------------------");
            System.out.println("Prenom : " + personnes[i].prenom);
            System.out.println("Nom : " + personnes[i].nom);
            System.out.println("Age : " + personnes[i].age);
        }
    }

    public static void AgeCroissants(Personne[] personnes, int cpt) {

        System.out.println("\nPersonnes majeures :");

        for (int i = 0; i < cpt; i++) {

            if (personnes[i].age >= 18) {

                System.out.println(
                        personnes[i].prenom + " "
                        + personnes[i].nom + " : "
                        + personnes[i].age);
            }
        }
    }
}