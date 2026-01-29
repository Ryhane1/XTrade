import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner add = new Scanner(System.in);
        int choix ;
        System.out.println("");
        System.out.println("1. Admine ");
        System.out.println("2. Trader ");
        System.out.println("3. Quitter ");
        choix = add.nextInt();
        switch (choix) {
            case 1 -> menuAdmin();
            case 2 -> menuTrader();
            case 3 -> System.out.println("Au revoir !");
            default -> System.out.println("Choix Invalid ! ");
//            case 4 -> withdrawSold(add);
//            case 5 -> displayAccounts();
//            case 6 -> deleteAccount(add);
//            case 7 -> savingAccount(add);
//            case 8 -> displaySavings();
//            case 9 -> transfertSold(add);
//            case 10 -> System.out.println("Au revoir !");
        }


    }

//    public static void menuPrincipal(){
//        Scanner add = new Scanner(System.in);
//        int choix ;
//        System.out.println("");
//        System.out.println("2. Admin ");
//        System.out.println("1. Trader ");
//        choix = add.nextInt();
//        if (choix == 1){
//
//        } else if (choix == 2) {
//
//        }else {
//            System.out.println("Choix Invalid !!");
//        }

    public static void menuAdmin(){
        Scanner add = new Scanner(System.in);
        int choix ;
        System.out.println("");
        System.out.println("1. Ajouter Trader ");
        System.out.println("2. Ajouter Portfolio ");
        System.out.println("3. Ajouter Action ");
        System.out.println("4. Ajouter Crypto ");
        System.out.println("5. Supprimer Trader ");
        System.out.println("6. Supprimer Portfolio ");
        System.out.println("7. Supprimer Action ");
        System.out.println("8. Supprimer Crypto ");
        System.out.println("9. Quitter Menu Admin ");
        choix = add.nextInt();
        switch (choix) {
            case 1 -> Platform.addTrader(add);
            case 2 -> Platform.addPortfolio(add) ;
            case 3 -> Asset.addAction(add);
            case 4 -> Asset.addCrypto(add);
            case 5 -> Platform.deleteTrader(add);
            case 6 -> Platform.deletePortfolio(add);
            case 7 -> Asset.deleteAction(add);
            case 8 -> Asset.deleteCrypro(add);
            case 9 -> System.out.println("Au revoir !");
            default -> System.out.println("Choix Invalid ! ");
        }


    }
    public static void menuTrader(){
        Scanner add = new Scanner(System.in);
        int choix ;
        System.out.println(" ");
        System.out.println("1. Acheter Action ");
        System.out.println("2. Acheter Crypto ");
        System.out.println("3. Consulter Portfolio ");
        System.out.println("4. Consulter Historique Transaction ");
        System.out.println("5. Quitter Menu Trader ");
//        System.out.println("1. Supprimer Portfolio ");
//        System.out.println("1. Supprimer Trader ");
        choix = add.nextInt();
        switch (choix){
            case 1 -> Platform.byAction(add);
            case 2 -> Platform.byCrypto(add);
        }
    }

}