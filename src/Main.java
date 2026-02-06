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
                System.out.println("3. Transactions ");
                System.out.println("4. Quitter ");
                choix = add.nextInt();
                switch (choix) {
                    case 1 -> menuAdmin();
                    case 2 -> menuTrader();
                    case 3 -> menuTradsaction();
                    case 4 -> System.out.println("Au revoir !");
                    default -> System.out.println("Choix Invalid ! ");
                }
            } catch (InputMismatchException e) {
                System.out.println("Input Invalid ! ");
                add.nextLine();
            }
        } while (choix != 4);
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

    public static void menuTradsaction(){
        Scanner add = new Scanner(System.in);
        int choix = 0;
        do {
            try {
                System.out.println(" ");
                System.out.println("1. Afficher les Transactions d'un Trader ");
                System.out.println("2. Afficher les Transactions d'Achat ");
                System.out.println("3. Afficher les Transactions du Vente ");
                System.out.println("4. Afficher les Transactions d'un Actif Financier");
                System.out.println("5. Afficher Les Transaction dans un intervalle de dates ");
                System.out.println("6. Les Transactions Trier par Date ");
                System.out.println("7. Les Transactions Trier par Montant ");
                System.out.println("8. Le Volume Total des Transactions par Actif ");
                System.out.println("9. Le Volume Total des Transactions d'Achat ");
                System.out.println("10. Le Volume Total des Transactions du Vente ");
                System.out.println("11. Le Volume Total échangé  Par Trader ");
                System.out.println("12. Nombre Total des Transactions ");
                System.out.println("13. Classement 'N' des traders par volume  ");
                System.out.println("14. volume total échangé par instrument financier ");
                System.out.println("15. L’instrument le plus échangé ");
                System.out.println("16. Montant total des BUY et des SELL Séparément ");
                System.out.println("17. Quitter Menu Trader ");
                choix = add.nextInt();
                switch (choix){
                    case 1 -> Platform.TrassactionTrader(add);
                    case 2 -> Platform.TrassactionTypeAchat();
                    case 3 -> Platform.TrassactionTypeVente();
                    case 4 -> Platform.FilterTransactionAsset(add);
                    case 5 -> Platform.FilterDateIntervalle(add);
                    case 6 -> Platform.OrderDate(add);
                    case 7 -> Platform.OrderMontant(add);
                    case 8 -> Platform.volumeParAsset();
                    case 9 -> Platform.montantTotalAchat();
                    case 10 -> Platform.montantTotalVente();
                    case 11 -> Platform.volumeTotalTrader();
                    case 12 -> Platform.nomberTransactionTotal();
                    case 13 -> Platform.topNTraders(add);
                    case 14 -> Platform.volumeParInstrument();
                    case 15 -> Platform.topActif();
                    case 16 -> Platform.montantTotalAchatVente();
                    case 17 -> System.out.println("Au revoir !");
                    default -> System.out.println("Choix Invalid ! ");
                }
            } catch (InputMismatchException e) {
                System.out.println("Input Invalid ! ");
                add.nextLine();
            }
        } while (choix != 17);
        return;
    }

}
