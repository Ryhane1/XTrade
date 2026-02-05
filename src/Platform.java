import javax.swing.*;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

import static java.util.Locale.filter;
import static java.util.stream.Collectors.toList;

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
        LocalDate date = LocalDate.now();
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
        LocalDate date = LocalDate.now();
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
                LocalDate date = LocalDate.now();
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
    public static void FilterTransactionAsset(Scanner add){
        System.out.println("Entre le nom d'Asset a chercher : ");
        String nom = add.next();
        for (Transaction g : transactions){
        if (!Objects.equals(g.getActif().getAsset().getNom(), nom)) {
            System.out.println("Asset n'existe pas !!");
        }}
        List<Transaction> asset = transactions.stream().filter(t -> t.getActif().getAsset().getNom().equals(nom))
                .toList();
        asset.stream().forEach(System.out::println);
    }

    public static void FilterTransactionDate(Scanner add){
        System.out.println("Entre la date initial sous la form (aaaa-mm-jj) : ");
        LocalDate date1 = LocalDate.parse(add.next());
        System.out.println("Entre la date final sous la form (aaaa-mm-jj) : ");
        LocalDate date2 = LocalDate.parse(add.next());
//        for (Transaction g : transactions){
//            if (!Objects.equals(g.getActif().getAsset().getNom(), nom)) {
//                System.out.println("Asset n'existe pas !!");
//            }}
        List<Transaction> asset = transactions.stream().filter(t -> t.getDate().isBefore(date1) && date2.isBefore(t.getDate()))
                .toList();
        asset.stream().forEach(System.out::println);
        if (asset.isEmpty()){
            System.out.println("Aucune Transaction est dispo");
        }
    }

    public static void OrderTransactionDate(Scanner add){
        System.out.println("Entre l'Order 'C' pour Croissant et 'D' pour Décroissant : ");
        String order = add.next();
        if (order.equals("C")){
            List<Transaction> asset = transactions.stream().sorted(Comparator.comparing(Transaction::getDate))
                    .toList();
            asset.stream().forEach(System.out::println);
        } else if (order.equals("D")) {
            List<Transaction> asset = transactions.stream().sorted(Comparator.comparing(Transaction::getDate).reversed())
                    .toList();
            asset.stream().forEach(System.out::println);
        }else {
            System.out.println("Aucune Transaction est dispo");
        }
    }

    public static void OrderTransactionMontant(Scanner add){
        System.out.println("Entre l'Order 'C' pour Croissant et 'D' pour Décroissant : ");
        String order = add.next();
        if (order.equals("C")){
        List<Transaction> asset = transactions.stream().sorted(Comparator.comparing(Transaction::getValeur))
                .toList();
        asset.stream().forEach(System.out::println);
        } else if (order.equals("D")) {
            List<Transaction> asset = transactions.stream().sorted(Comparator.comparing(Transaction::getValeur).reversed())
                    .toList();
            asset.stream().forEach(System.out::println);
        }else {
            System.out.println("Aucune Transaction est dispo");
        }
    }

    public static void volumeTransactionAsset(Scanner add){
         Map<String, Float> TraderOrder = transactions.stream().collect
                 (Collectors.groupingBy(t-> t.getActif().getAsset().getNom(),
                 Collectors.reducing(0f,trans -> trans.getActif().getQuantite(), Float::sum)));
        TraderOrder.forEach((nomActif, totalQuantite) -> {
                System.out.println("  - Actif: " + nomActif + " | Quantité totale: " + totalQuantite);
            });

//        System.out.println("Entre le nom d'Asset a chercher : ");
//        String nom = add.next();
//        for (Transaction g : transactions){
//            if (!Objects.equals(g.getActif().getAsset().getNom(), nom)) {
//                System.out.println("Asset n'existe pas !!");
//            }}
//        List<Transaction> asset = transactions.stream().filter(t -> t.getActif().getAsset().getNom().equals(nom))
//                .toList();
//        long count = asset.stream().count();
//        System.out.println("le Nombre des transaction d'asset : "+nom +" , est : "+count);
//        if (asset.isEmpty()){
//            System.out.println("Aucune Transaction est dispo");
        }


    public static void montantTransactionAchat(){
        List<Transaction> achat = transactions.stream()
                .filter(g -> g.getType().equals("Achat"))
                .toList();
        float montant = achat.stream()
                .map(Transaction::getValeur)
                .reduce(0f, Float::sum);
        System.out.println("le Montant Total des transaction d'Achat est : "+montant);
        if (achat.isEmpty()){
            System.out.println("Aucune Transaction est dispo");
        }
    }

    public static void montantTransactionVente(){
        List<Transaction> achat = transactions.stream()
                .filter(g -> g.getType().equals("Vente"))
                .toList();
        float montant = achat.stream()
                .map(Transaction::getValeur)
                .reduce(0f, Float::sum);
        System.out.println("le Montant Total des transaction de Vente est : "+montant);
        if (achat.isEmpty()){
            System.out.println("Aucune Transaction est dispo");
        }
    }

    public static void nomberTransactionTrader(){
//        System.out.println("Entre l'ID du Trader a chercher : ");
//        int id = add.nextInt();
//        for (Transaction g : transactions){
//            if (id != g.getTrader().getId()) {
//                System.out.println("Asset n'existe pas !!");
//            }}
//        List<Transaction> trader = transactions.stream().filter(t -> t.getTrader().getId() ==id)
//                .toList();
//        long count = trader.stream().count();
//        System.out.println("le Nombre des transaction du Trader ID : "+id +" , est : "+count);
//        if (trader.isEmpty()){
//            System.out.println("Aucune Transaction est dispo");
//        }
//        int sommeA = liste.stream()
//                .filter(e -> "A".equals(e.getId())) // Filtre l'élément A
//                .mapToInt(Element::getValeur)      // Récupère la valeur
//                .sum();
        Map<Integer, Map<String, Float>> TraderOrder = transactions.stream().collect(Collectors.groupingBy(Transaction -> Transaction.getTrader().getId(),
                Collectors.groupingBy(t-> t.getActif().getAsset().getNom(),
                Collectors.reducing(0f,trans -> trans.getActif().getQuantite(), Float::sum))));
        TraderOrder.forEach((traderId, actifsMap) -> {
            System.out.println("Trader ID: " + traderId);

            actifsMap.forEach((nomActif, totalQuantite) -> {
                System.out.println("  - Actif: " + nomActif + " | Quantité totale: " + totalQuantite);
            });
        });

//        Map<Trader, Float> trader = transactions.stream()
//                .collect(Collectors.groupingBy(Transaction::getTrader, Collectors.reducing(0,transaction -> transaction.getActif().getQuantite(), Float::sum)));
//
//        trader.forEach((trad, somme)-> System.out.println(trad+" , Volume total des échanges : "+somme));
    }

    public static void nomberTransactionTotal(){
        long count = transactions.stream().count();
        System.out.println("le Nombre des transaction total : "+count);
        if (transactions.isEmpty()){
            System.out.println("Aucune Transaction est trouve !!");
        }
    }

    public static void topNTraders(Scanner add){
        System.out.println("Entre le nomber des Trader a ordonner : ");
        int n = add.nextInt();
        Map<Trader, Float > trader = transactions.stream()
                .collect(Collectors.groupingBy(Transaction::getTrader, Collectors.reducing(0f,Transaction::getValeur, Float::sum)));
        System.out.println("Voila le classment des "+n+" Top Traders par Volume : ");
        trader.entrySet().stream()
                .sorted(Map.Entry.<Trader, Float>comparingByValue().reversed())
                .limit(n)
                .forEach(entry -> System.out.println(entry.getKey() +" , volume total des échanges : "+entry.getValue()));
//        trader.entrySet().stream()
//                .sorted(Map.Entry.<Trader, Float>comparingByValue().reversed())
//                .limit(n)
//                .forEach(entry -> System.out.println(entry.getKey() + "  , volume total des échanges : " + entry.getValue()));


//        perOrder.forEach((trad, somme)-> System.out.println(trad+" , volume total des échanges : "+somme));
    }

    public static void topActif(){
        Map<Asset, Float> actifTop = transactions.stream().collect
                (Collectors.groupingBy(t-> t.getActif().getAsset(),
                        Collectors.reducing(0f,trans -> trans.getActif().getQuantite(), Float::sum)));
        System.out.println("l’instrument financier le plus échanger :");
        actifTop.entrySet().stream()
                .sorted(Map.Entry.<Asset , Float>comparingByValue().reversed())
                .limit(1)
                .forEach(entry -> {
            System.out.println(entry.getKey() + " | Quantité totale: " + entry.getValue());});
    }



}
