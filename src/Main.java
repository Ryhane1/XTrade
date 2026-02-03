import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner add = new Scanner(System.in);
        int choix = 0;


        do {
            try {
                System.out.println(" ");
                System.out.println("1. Admin ");
                System.out.println("2. Trader ");
                System.out.println("3. Quitter ");
                choix = add.nextInt();
                switch (choix) {
                    case 1 -> menuAdmin();
                    case 2 -> menuTrader();
                    case 3 -> System.out.println("Au revoir !");
                    default -> System.out.println("Choix Invalid ! ");
                }
            } catch (InputMismatchException e) {
                System.out.println("Input Invalid ! ");
                add.nextLine();
            }
        } while (choix != 3);
        add.close();
    }

    public static void menuAdmin(){
        Scanner add = new Scanner(System.in);
        int choix = 0 ;
        do {
            try {
                System.out.println(" ");
                System.out.println("1. Ajouter Trader ");
                System.out.println("2. Afficher la liste des Traders ");
                System.out.println("3. Ajouter Portfolio ");
                System.out.println("4. Afficher la liste des Portfolios ");
                System.out.println("5. Ajouter Action ");
                System.out.println("6. Ajouter Crypto ");
                System.out.println("7. Afficher les Actions ");
                System.out.println("8. Affiche les Cryptos Monnaies ");
                System.out.println("9. Supprimer Trader ");
                System.out.println("10. Supprimer Portfolio ");
                System.out.println("11. Supprimer Action ");
                System.out.println("12. Supprimer Crypto ");
                System.out.println("13. Quitter Menu Admin ");
                choix = add.nextInt();
                switch (choix) {
                    case 1 -> Platform.addTrader(add);
                    case 2 -> Platform.displayTraders();
                    case 3 -> Platform.addPortfolio(add) ;
                    case 4 -> Platform.displayPortfolios();
                    case 5 -> Asset.addAction(add);
                    case 6 -> Asset.addCrypto(add);
                    case 7 -> Asset.displayActions();
                    case 8 -> Asset.displayCryptos();
                    case 9 -> Platform.deleteTrader(add);
                    case 10 -> Platform.deletePortfolio(add);
                    case 11 -> Asset.deleteAction(add);
                    case 12 -> Asset.deleteCrypro(add);
                    case 13 -> System.out.println("Au revoir !");
                    default -> System.out.println("Choix Invalid ! ");
                }
            } catch (InputMismatchException e) {
            System.out.println("Input Invalid ! ");
            add.nextLine();
            }
        } while (choix != 13);
            return;
    }

    public static void menuTrader(){
        Scanner add = new Scanner(System.in);
        int choix = 0;
        do {
            try {
                System.out.println(" ");
                System.out.println("1. Afficher les Actions ");
                System.out.println("2. Afficher les Cryptos Monnaies ");
                System.out.println("3. Acheter Action ");
                System.out.println("4. Acheter Crypto ");
                System.out.println("5. Vendre Actif/Asset ");
                System.out.println("6. Consulter Portfolio ");
                System.out.println("7. Consulter Historique Transaction ");
                System.out.println("8. Quitter Menu Trader ");
                choix = add.nextInt();
                switch (choix){
                    case 1 -> Asset.displayActions();
                    case 2 -> Asset.displayCryptos();
                    case 3 -> Platform.byAction(add);
                    case 4 -> Platform.byCrypto(add);
                    case 5 -> Platform.sellAsset(add);
                    case 6 -> Platform.displayPortfolio(add);
                    case 7 -> Platform.displayTransactions();
                    case 8 -> System.out.println("Au revoir !");
                    default -> System.out.println("Choix Invalid ! ");
                }
            } catch (InputMismatchException e) {
        System.out.println("Input Invalid ! ");
        add.nextLine();
        }
        } while (choix != 8);
            return;
    }

}
