import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Platform {

    static ArrayList<Trader> traders = new ArrayList<>();
    static ArrayList<Portfolio> portfolios = new ArrayList<>();
    static ArrayList<Transaction> transactions = new ArrayList<>();

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
            Portfolio p = new Portfolio(t,blance);
            portfolios.add(p);}

        }
    }
    public static Portfolio findPortfolio(int idby){
        Portfolio d = null;
        for (Portfolio p : portfolios){
            if (idby == p.getTrader().getId()){
                d = p;
            }
        }
        return d ;
    }
    public static void displayPortfolios(){
        for (Portfolio p : portfolios) {
            System.out.println("ID : " + p.getTrader().getId() + "Nom du Trader : " + p.getTrader().getNom()
                    + " Balance : " + p.getBalance());
            System.out.println("Les Asstes : ");
            for (Postion r : p.getPostions()){
                System.out.println("Nom du d'Asset : " + r.getAsset().getNom()
                        + " Quatite : " + r.getQuantite()
                        + " Prix Unitaire : " + r.getAsset().getPrixUnitaire());
            }
        }
    }
    public static void deletePortfolio(Scanner add){
        System.out.println("Entre Id Portfolio a Supprimer : ");
        int idD = add.nextInt();
        portfolios.removeIf(p -> p.getTrader().getId()==idD);
    }
    public static void byCrypto(Scanner add){
        System.out.println("Entre votre ID Portfolio : ");
        int idby = add.nextInt();
        Portfolio p = findPortfolio(idby);
        Asset.displayCryptos();
        System.out.println("Entre le Nom du Crypto a Acheter : ");
        String nom = add.nextLine();
        System.out.println("Entre le Montant a Acheter : ");
        float budget = add.nextFloat();
        Asset c = Asset.findCrypto(nom);
        p.acheterAsset(c,budget);
        LocalDateTime date = LocalDateTime.now();
        transactions.add(new Transaction(date,p));
        float quatite = budget/c.getPrixUnitaire();
        p.setPostions(new Postion(c,quatite,budget));
        System.out.println("Achat est fait !!");
        System.out.println("Vous avez Acheter la quatite : "+quatite
                +" , du Crypto : "+c.getNom()
                +"avec une Valeur de : "+budget);
    }
    public static void byAction(Scanner add){
        System.out.println("Entre votre ID Portfolio : ");
        int idby = add.nextInt();
        Portfolio p = findPortfolio(idby);
        Asset.displayActions();
        System.out.println("Entre le Nom d'action a Acheter : ");
        String nom = add.nextLine();
        System.out.println("Entre le Montant a Acheter : ");
        float budget = add.nextFloat();
        Action a = Asset.findAction(nom);
        float quantite = budget/a.getPrixUnitaire();
        p.setPostions(new Postion(a,quantite,budget));
        p.setBalance(p.getBalance()-budget);
        System.out.println("Achat est Fait !!");
        System.out.println("Vou avez acheter la Quatiter : "+quantite
                +" , d'Action : "+a.getNom()
                +"Avec une Valeur de : "+budget);
    }
    public static void displayPortfolio(Scanner add , int id){
        System.out.println("Entre Portfolio ID : ");
        int idd = add.nextInt();
        Portfolio p = findPortfolio(idd);
        System.out.println("ID : "+p.getTrader().getId()+"Nom du Trader : "+p.getTrader().getNom()
                +" Balance : "+p.getBalance());
        System.out.println("Les Asstes : ");
        for (Postion r : p.getPostions()){
            System.out.println("Nom d'Asset : " + r.getAsset().getNom()
                    + " Quatite : " + r.getQuantite()
                    + " Prix Unitaire : "+ r.getAsset().getPrixUnitaire()
                    +" , La Valeur d'Asset : "+ r.getValeurAchat());
        }
    }
    public static void displayPortfolioID(int id){
        Portfolio p = findPortfolio(id);
        System.out.println("ID : "+p.getTrader().getId()+"Nom du Trader : "+p.getTrader().getNom()
                +" Balance : "+p.getBalance());
        System.out.println("Les Asstes : ");
        for (Postion r : p.getPostions()){
            System.out.println("Nom d'Asset : " + r.getAsset().getNom()
                    + " Quatite : " + r.getQuantite()
                    + " Prix Unitaire : "+ r.getAsset().getPrixUnitaire()
                    +" , La Valeur d'Asset : "+ r.getValeurAchat());
        }
    }
    public static void sellAsset(Scanner add){
        System.out.println("Entre ID du Portfolio : ");
        int id = add.nextInt();
//        Portfolio p1 = new Portfolio<>();
        Portfolio p = findPortfolio(id);
        displayPortfolioID(id);
        System.out.println("Entre le nom d'Asset a vendre : ");
        String nom = add.nextLine();
        for (Postion r : p.getPostions()){
            if (nom == r.getAsset().getNom()){
                System.out.println("Nom d'Asset : "+r.getAsset().getNom()
                        +" , La Quantité : "+r.getQuantite()
                        +" , le Prix Unitaire : "+r.getAsset().getPrixUnitaire());
                System.out.println("Entre la Quantité a Vendre : ");
                float quantite = add.nextFloat();
                if (quantite > r.getQuantite()){
                    System.out.println("Quantite Insuffisant !!");
                    return;
                }
                r.setQuantite(r.getQuantite()-quantite);
                p.setBalance(p.getBalance()+(quantite*r.getAsset().getPrixUnitaire()));
                System.out.println("la Vente est fait avec Succes !!");
            }
        }
    }

}
