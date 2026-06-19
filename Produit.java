package GestionProduit;
// un produit a:
// un code dans un tableau reserve à lui 
// un libellé dans un tableau reserve à lui
// un prix dans un tableau reserve à lui
// quantité en stock du produit dans un tableau reserve à lui 
// description dans un tableau reserve à lui

// on réalise le code avec des fonctions

// Menu
// 1) Lister tous les produits
// 2) Ajouter un produit
// 3) Afficher les prix par ordre croissant
// 4) Rechercher un produit par son code 
// 5) Quitter

// NB
// tous les champs sont obligatoires sauf description
// le code produit doit être unique et doit comporter 6 caractères auto genere
// le prix et quantite en stock doivent être positifs

import java.util.Scanner;

public class Produit {


    public static void main(String[] args) {
        final int taille = 100;
        Scanner sc = new Scanner(System.in);
        String[] codes = new String[taille];
        String[] libelles = new String[taille];
        int[] prix = new int[taille];
        int[] quantites = new int[taille];
        String[] descriptions = new String[taille];
        int cpt = 0;
        int choix;

        do {
            afficherMenu();
            choix = sc.nextInt();
            switch (choix) {

                case 1:
                    if(cpt < taille){
                    listeProduits(codes, libelles, prix, quantites, descriptions, cpt);
                    }
                    break;

                case 2:
                    if (cpt < taille) {

                        System.out.println("\n=== AJOUT PRODUIT ===");

                        codes[cpt] = GenererCodeProduit(codes, cpt);

                        libelles[cpt] =
                                ChaineObligatoire(sc, "Libellé : ");

                        prix[cpt] =
                                SaisiePrix(sc, "Prix : ");

                        quantites[cpt] =
                                SaisieQuantite(sc, "Quantité en stock : ");

                        descriptions[cpt] =
                                Description(sc, "Description (optionnelle) : ");

                        System.out.println("Code généré : " + codes[cpt]);

                        cpt++;
                    } else {
                        System.out.println("Tableau plein !");
                    }
                    break;

                case 3:
                    PrixCroissants(libelles, prix, cpt);
                    break;

                case 4:
                    RechercheProduit(sc, codes, libelles, prix,
                            quantites, descriptions, cpt);
                    break;

                case 5:
                    System.out.println("Au revoir !");
                    break;

                default:
                    System.out.println("Choix invalide !");
            }

        } while (choix != 5);

        sc.close();
    }

//fonction pour le menu 
    public static void afficherMenu() {
        System.out.println("\n===== MENU =====");
        System.out.println("1) Lister tous les produits");
        System.out.println("2) Ajouter un produit");
        System.out.println("3) Afficher les prix par ordre croissant");
        System.out.println("4) Rechercher un produit par son code");
        System.out.println("5) Quitter");
        System.out.println("\nEntrer votre choix: ");
    }

//fonction pour la generation automatique du code
    public static String GenererCodeProduit(String[] codes, int cpt) {
    return String.format("PR%03d", cpt + 1);
}


    public static String ChaineObligatoire(Scanner sc, String message) {

        String valeur;

        do {
            System.out.print(message);
            valeur = sc.nextLine().trim();

            if (valeur.isEmpty()) {
                System.out.println("Champ obligatoire !");
            }

        } while (valeur.isEmpty());
        sc.nextLine();
        return valeur;
    }

    public static String Description(Scanner sc, String message) {
        System.out.print(message);
        return sc.nextLine();
    }

    public static int SaisiePrix(Scanner sc, String message) {

        int valeur;

        do {
            System.out.print(message);
            valeur = sc.nextInt();

            if (valeur <= 0) {
                System.out.println("Le prix doit être positif !");
            }

        } while (valeur <= 0);

        sc.nextLine();
        return valeur;
    }

    public static int SaisieQuantite(Scanner sc, String message) {

        int valeur;

        do {
            System.out.print(message);
            valeur = sc.nextInt();

            if (valeur < 0) {
                System.out.println("La quantité doit être positive !");
            }

        } while (valeur < 0);

        sc.nextLine();
        return valeur;
    }

    public static void listeProduits(
            String[] codes,
            String[] libelles,
            int[] prix,
            int[] quantites,
            String[] descriptions,
            int cpt) {

        if (cpt == 0) {
            System.out.println("Aucun produit enregistré.");
            return;
        }

        for (int i = 0; i < cpt; i++) {

            AfficherUnProduit(codes, libelles, prix, quantites, descriptions, i);

        }
    }


public static void PrixCroissants(String[] libelles, int[] prix, int cpt) {

    for (int i = 0; i < cpt - 1; i++) {
        for (int j = i + 1; j < cpt; j++) {

            if (prix[i] > prix[j]) {
                int tempPrix = prix[i];
                prix[i] = prix[j];
                prix[j] = tempPrix;

                String tempLibelle = libelles[i];
                libelles[i] = libelles[j];
                libelles[j] = tempLibelle;
            }
        }
    }

    System.out.println("\nPrix par ordre croissant :");

    for (int i = 0; i < cpt; i++) {
        System.out.println(libelles[i] + ": " + prix[i]);
    }
}


    public static void RechercheProduit(
            Scanner sc,
            String[] codes,
            String[] libelles,
            int[] prix,
            int[] quantites,
            String[] descriptions,
            int cpt) {

        sc.nextLine();

        System.out.print("Code Produit: ");
        String code = sc.nextLine();

        boolean trouve = false;

        for (int i = 0; i < cpt; i++) {

            if (codes[i].equals(code)) {

                trouve = true;

                AfficherUnProduit(codes, libelles, prix, quantites, descriptions, i);

                break;
            }
        }

        if (!trouve) {
            System.out.println("Produit introuvable.");
        }
    }


    public static void AfficherUnProduit(
            String[] codes,
            String[] libelles,
            int[] prix,
            int[] quantites,
            String[] descriptions,
            int i) {


            System.out.println("\n--------------------");
            System.out.println("Code : " + codes[i]);
            System.out.println("Libellé : " + libelles[i]);
            System.out.println("Prix : " + prix[i]);
            System.out.println("Quantité : " + quantites[i]);
            System.out.println("Description : " + descriptions[i]);

    }
}
