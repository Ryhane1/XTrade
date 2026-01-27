import java.util.ArrayList;
import java.util.Scanner;

abstract class Asset {
    static ArrayList<Crypto> Cryptos = new ArrayList<>();
    static ArrayList<Action> actions = new ArrayList<>();

    public static void addAction(Scanner add){
        System.out.println("Entre Le Nom d'Action : ");
        String nomAction = add.nextLine();
        System.out.println("Entre le Prix Unitaire d'Action : ");
        float prixUnit = add.nextFloat();
        actions.add(new Action(nomAction,prixUnit));
    }
    public static void deleteAction(Scanner add){
        System.out.println("Enter le nom d'Action a Supprimer : ");
        String inputNom = add.nextLine();
        actions.removeIf(a -> a.getNomStock().equals(inputNom));
    }

    public static void addCrypto(Scanner add){
        System.out.println("Entre le Nom de Crypto Monnaie : ");
        String nomCrypto = add.nextLine();
        System.out.println("Entre le Prix Unitaire du Crypto Monnaie : ");
        float prixUnitt = add.nextFloat();
        Cryptos.add(new Crypto(nomCrypto,prixUnitt));
    }
    public static void deleteCrypro(Scanner add){
        System.out.println("Entre le Nom de Crypto a Supprimer : ");
        String inputNom = add.nextLine();
        Cryptos.removeIf(c -> c.getNomCrypto().equals(inputNom));
    }

}
