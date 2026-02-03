import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Platform {

    static ArrayList<Trader> traders = new ArrayList<>();
    static ArrayList<Portfolio> portfolios = new ArrayList<>();
    static List<Transaction> transactions = new ArrayList<>();

    public static void addTrader(Scanner add){
        System.out.println("Entre le nom : ");
        add.nextLine();
        String nom = add.nextLine();
        System.out.println("Entre Mail : ");
        String mail = add.nextLine();
        int id = new Random().nextInt(100000,1000000);
        System.out.println("ID est Générer !!");
        System.out.println("Entre le sold Initial : ");
        float soldeInitial = add.nextFloat();
        traders.add(new Trader(nom,mail,id,soldeInitial));
        System.out.println("Compte est Creer !!");
    }
    public static void deleteTrader(Scanner add){
        System.out.println("Entre compte ID ");
        int inputId = add.nextInt();
        traders.removeIf(t -> t.getId() ==inputId);
        System.out.println("Trader est Supprimer avec Succes !!");
    }
    public static void displayTraders(){
        System.out.println("Traders : ");
        for (Trader t : traders){
            System.out.println("ID : "+t.getId()+" , Nom : "+t.getNom()
                    +" , Mail : "+t.getMail()+" , Sold Initial : "+t.getSoldInitial());
        }
    }
    public static void addPortfolio(Scanner add){
        displayTraders();
        System.out.println("Entre Id du Trader :");
        int idT = add.nextInt();
        for (Trader t : traders){
            if (idT == t.getId()){
            float blance = t.getSoldInitial();
//            Portfolio p = ;
            portfolios.add(new Portfolio(t,blance));
            System.out.println("Portfolio Creer avec Succes !!");
            return;
            }
        } System.out.println("Trader n'existe pas !");
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
        if (portfolios.isEmpty()) {
            System.out.println("La liste des Portfolio est vide.");
        } else {
                for (Portfolio p : portfolios) {
            System.out.println("ID : " + p.getTrader().getId() + " , Nom du Trader : " + p.getTrader().getNom()
                    + " , Balance : " + p.getBalance());
//                    if (p.getActifs().isEmpty()) { System.out.println("La liste des Assets est vide.");return;}
//                    System.out.println("Les Asstes : ");
//            for (Actif r : p.getActifs()){
//                System.out.println("Nom du d'Asset : " + r.getAsset().getNom()
//                        + " Quatite : " + r.getQuantite()
//                        + " Prix Unitaire : " + r.getAsset().getPrixUnitaire());
//                 }
             }
        }
    }
    public static void deletePortfolio(Scanner add){
        System.out.println("Entre Id Portfolio a Supprimer : ");
        int idD = add.nextInt();
        portfolios.removeIf(p -> p.getTrader().getId()==idD);
        System.out.println("Portfolio est supprimer !!");
    }
    public static void byCrypto(Scanner add){
        System.out.println("Entre votre ID Portfolio : ");
        int idby = add.nextInt();
        Portfolio p = findPortfolio(idby);
        Asset.displayCryptos();
        System.out.println("Entre le Nom du Crypto a Acheter : ");
        add.nextLine();
        String nom = add.nextLine();
        System.out.println("Entre le Montant a Acheter : ");
        float budget = add.nextFloat();
        Asset c = Asset.findCrypto(nom);
//        p.acheterAsset(c,budget);
        float quantite = budget/c.getPrixUnitaire();
        Actif r = new Actif(c,quantite,budget);
        p.setActifs(r);
        LocalDateTime date = LocalDateTime.now();
        String typeT = "Achat";
        transactions.add(new Transaction(typeT,date,p.getTrader(),r,budget));
        System.out.println("Achat est fait !!");
        System.out.println("Vous avez Acheter la quatite : "+quantite
                +" , du Crypto : "+c.getNom()
                +" , avec une Valeur de : "+budget);
    }
    public static void byAction(Scanner add){
        System.out.println("Entre votre ID Portfolio : ");
        int idby = add.nextInt();
        Portfolio p = findPortfolio(idby);
        Asset.displayActions();
        System.out.println("Entre le Nom d'action a Acheter : ");
        add.nextLine();
        String nom = add.nextLine();
        System.out.println("Entre le Montant a Acheter : ");
        float budget = add.nextFloat();
        Action a = Asset.findAction(nom);
        float quantite = budget/a.getPrixUnitaire();
        Actif r = new Actif(a,quantite,budget);
        p.setActifs(r);
        p.setBalance(p.getBalance()-budget);
        LocalDateTime date = LocalDateTime.now();
        String typeT = "Achat";
        transactions.add(new Transaction(typeT,date,p.getTrader(),r,budget));
        System.out.println("Achat est Fait !!");
        System.out.println("Vou avez acheter la Quatiter : "+quantite
                +" , d'Action : "+a.getNom()
                +" , Avec une Valeur de : "+budget);
    }
    public static void displayPortfolio(Scanner add){
        System.out.println("Entre Portfolio ID : ");
        int idd = add.nextInt();
        Portfolio p = findPortfolio(idd);
        System.out.println("ID : "+p.getTrader().getId()+" , Nom du Trader : "+p.getTrader().getNom()
                +" , Balance : "+p.getBalance());
        System.out.println("Les Asstes : ");
        for (Actif r : p.getActifs()){
            System.out.println("Nom d'Asset : " + r.getAsset().getNom()
                    + " Quatite : " + r.getQuantite()
                    + " Prix Unitaire : "+ r.getAsset().getPrixUnitaire()
                    +" , La Valeur d'Asset : "+ r.getValeurAchat());
        }
    }
    public static void displayPortfolioID(int id){
        Portfolio p = findPortfolio(id);
        System.out.println("ID : "+p.getTrader().getId()+" , Nom du Trader : "+p.getTrader().getNom()
                +" , Balance : "+p.getBalance());
        System.out.println("Les Asstes : ");
        for (Actif r : p.getActifs()){
            System.out.println("Nom d'Asset : " + r.getAsset().getNom()
                    + " Quatite : " + r.getQuantite()
                    + " Prix Unitaire : "+ r.getAsset().getPrixUnitaire()
                    +" , La Valeur d'Asset : "+ r.getValeurAchat());
        }
    }
    public static void sellAsset(Scanner add){
        System.out.println("Entre ID du Portfolio : ");
        int id = add.nextInt();
        Portfolio p = findPortfolio(id);
        displayPortfolioID(id);
        System.out.println("Entre le nom d'Asset a vendre : ");
        add.nextLine();
        String nom = add.nextLine();
        for (Actif r : p.getActifs()){
            if (nom.equals(r.getAsset().getNom())){
                System.out.println("Nom d'Asset : "+r.getAsset().getNom()
                        +" , La Quantité : "+r.getQuantite()
                        +" , le Prix Unitaire : "+r.getAsset().getPrixUnitaire());
                System.out.println("Entre la Quantité a Vendre : ");
                float quantite = add.nextFloat();
                if (quantite > r.getQuantite() && quantite < 0){
                    System.out.println("Quantite Insuffisant !!");
                    return;
                }
                r.setQuantite(r.getQuantite()-quantite);
                p.setBalance(p.getBalance()+(quantite*r.getAsset().getPrixUnitaire()));
                LocalDateTime date = LocalDateTime.now();
                float valeur = quantite*r.getAsset().getPrixUnitaire();
                float g = r.getValeurAchat()- valeur;
                r.setValeurAchat(g);
                String typeT = "Vente";
                transactions.add(new Transaction(typeT,date,p.getTrader(),r,valeur));
                System.out.println("la Vente est fait avec Succes !!");
            }
        }
    }
    public static void displayTransactions(){
        for (Transaction t : transactions){
            System.out.println("Type de Transaction : "+t.getType()+" , Date : " +t.getDate()
                    +" , Trader Nom : "+t.getTrader().getNom()+" , ID : "+t.getTrader().getId()+" , Asset : "
                    +t.getActif().getAsset().getNom()+" , Valeur : "+t.getValeur());
        }
    }


    public static void TrassactionTrader(Scanner add){
        System.out.println("Entre le ID du tader : ");
        int id = add.nextInt();
        System.out.println("Les transactions lie a ID : "+id);
        for (Transaction t : transactions){
            if (t.getTrader().getId() == id){
                System.out.println("Date : " +t.getDate()+" , Asset : "
                        +t.getActif().getAsset().getNom()+" , Valeur : "+t.getValeur()
                        +" , Trader Nom : "+t.getTrader().getNom());
            }
        }
        System.out.println("Les transactions lie a ID : "+id);
        List<Transaction> trader = transactions.stream()
                .filter(g -> g.getTrader().getId() == id)
                .toList();
        for (Transaction z : trader){
            System.out.println("Date : " +z.getDate()+" , Asset : "
                    +z.getActif().getAsset().getNom()+" , Valeur : "+z.getValeur()
                    +" , Trader Nom : "+z.getTrader().getNom()+" , ID : "+z.getTrader().getId());
        }

//        List<Transaction> results = transactions.stream()
//                .filter(t -> t.getType().equals("Achat"))
////                .map(String::toUpperCase)
////                .sorted()
//                .toList(); // or .collect(Collectors.toList()) for older Java versions
//        System.out.println(results);
    }

    public static void TrassactionType(){
        System.out.println("Transaction d'Achat : ");
        for (Transaction t : transactions){
            if (t.getType().equals("Achat")){
            System.out.println("Date : " +t.getDate()+" , Asset : "
                    +t.getActif().getAsset().getNom()+" , Valeur : "+t.getValeur()
                    +" , Trader Nom : "+t.getTrader().getNom()+" , ID : "+t.getTrader().getId());
        }
        }
        List<Transaction> achat = transactions.stream()
                .filter(g -> g.getType().equals("Achat"))
                .toList();
        for (Transaction z : achat){
            System.out.println("Date : " +z.getDate()+" , Asset : "
                    +z.getActif().getAsset().getNom()+" , Valeur : "+z.getValeur()
                    +" , Trader Nom : "+z.getTrader().getNom()+" , ID : "+z.getTrader().getId());
        }
        System.out.println("Transaction de Vente : ");
        List<Transaction> sell = transactions.stream()
                .filter(g -> g.getType().equals("Vente"))
                .toList();
        for (Transaction z : sell){
            System.out.println("Date : " +z.getDate()+" , Asset : "
                    +z.getActif().getAsset().getNom()+" , Valeur : "+z.getValeur()
                    +" , Trader Nom : "+z.getTrader().getNom()+" , ID : "+z.getTrader().getId());
        }

//        List<Transaction> results = transactions.stream()
//                .filter(t -> t.getType().equals("Achat"))
////                .map(String::toUpperCase)
////                .sorted()
//                .toList(); // or .collect(Collectors.toList()) for older Java versions
//        System.out.println(results);
    }
    public static void TrassactionAsset(){
        System.out.println("Transaction d'Achat : ");
        for (Transaction t : transactions){
            if (t.getType().equals("Achat")){
                System.out.println("Date : " +t.getDate()+" , Asset : "
                        +t.getActif().getAsset().getNom()+" , Valeur : "+t.getValeur()
                        +" , Trader Nom : "+t.getTrader().getNom()+" , ID : "+t.getTrader().getId());
            }
        }
        List<Transaction> achat = transactions.stream()
                .filter(g -> g.getActif().getAsset().getNom().equals(filter))
                .forEach(System.out::println);
//                .toList();
        for (Transaction z : achat){
            System.out.println("Date : " +z.getDate()+" , Asset : "
                    +z.getActif().getAsset().getNom()+" , Valeur : "+z.getValeur()
                    +" , Trader Nom : "+z.getTrader().getNom()+" , ID : "+z.getTrader().getId());
        }
        List<Transaction> sell = transactions.stream()
                .filter(g -> g.getType().equals("Vente"))
                .toList();
        for (Transaction z : sell){
            System.out.println("Date : " +z.getDate()+" , Asset : "
                    +z.getActif().getAsset().getNom()+" , Valeur : "+z.getValeur()
                    +" , Trader Nom : "+z.getTrader().getNom()+" , ID : "+z.getTrader().getId());
        }

//        List<Transaction> results = transactions.stream()
//                .filter(t -> t.getType().equals("Achat"))
////                .map(String::toUpperCase)
////                .sorted()
//                .toList(); // or .collect(Collectors.toList()) for older Java versions
//        System.out.println(results);

    }

}
