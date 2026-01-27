import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Platform {

    static ArrayList<Trader> traders = new ArrayList<>();
    static ArrayList<Portfolio> portfolios = new ArrayList<>();
    public static void addTrader(Scanner add){
        System.out.println("Entre le nom : ");
        String nom = add.nextLine();
        System.out.println("Entre Mail : ");
        String mail = add.nextLine();
        int id = new Random().nextInt(100000,1000000);
        System.out.println("Id Générer !!");
        System.out.println("Entre le sold Initial : ");
        float soldeInitial = add.nextFloat();
        traders.add(new Trader(nom,mail,id,soldeInitial));
        System.out.println("Compte Creer !!");
    }
    public static void deleteTrader(Scanner add){
        System.out.println("Entre compte ID ");
        int inputId = add.nextInt();
        traders.removeIf(t -> t.getId() ==inputId);
    }
    public static void addPortfolio(Scanner add){
        System.out.println("Entre Id du Trader :");
        int idT = add.nextInt();
        for (Trader t : traders){
            if (idT == t.getId()){
            float blance = t.getSoldInitial();
            Portfolio p = new Portfolio<>(t,blance);
            portfolios.add(p);}

        }
    }
    public static void deletePortfolio(Scanner add){
        System.out.println("Entre Id Portfolio a Supprimer : ");
        int idD = add.nextInt();
        portfolios.removeIf(p -> p.getTrader().getId()==idD);
    }
}
