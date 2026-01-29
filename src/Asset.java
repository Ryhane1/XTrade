import java.util.ArrayList;
import java.util.Scanner;

abstract class Asset {
    private String nom ;
    private float prixUnitaire ;
    private String type ;

    public Asset(String nom, float prixUnitaire, String type) {
        this.nom = nom;
        this.prixUnitaire = prixUnitaire;
        this.type = type;
    }

//    public Asset(String nom, float prixUnitaire) {
//        this.nom = nom;
//        this.prixUnitaire = prixUnitaire;
//    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public float getPrixUnitaire() {
        return prixUnitaire;
    }

    public void setPrixUnitaire(float prixUnitaire) {
        this.prixUnitaire = prixUnitaire;
    }
















    //    private Crypto crypto;
//    private Action action;
    static ArrayList<Crypto> Cryptos = new ArrayList<>();
    static ArrayList<Action> actions = new ArrayList<>();

//    public Asset(Crypto crypto, Action action) {
//        this.crypto = crypto;
//        this.action = action;
//    }
//
//    public Crypto getCrypto() {
//        return crypto;
//    }
//
//    public void setCrypto(Crypto crypto) {
//        this.crypto = crypto;
//    }
//
//    public Action getAction() {
//        return action;
//    }
//
//    public void setAction(Action action) {
//        this.action = action;
//    }

//    public static ArrayList<Crypto> getCryptos() {
//        return Cryptos;
//    }
//
//    public static void setCryptos(ArrayList<Crypto> cryptos) {
//        Cryptos = cryptos;
//    }
//
//    public static ArrayList<Action> getActions() {
//        return actions;
//    }
//
//    public static void setActions(ArrayList<Action> actions) {
//        Asset.actions = actions;
//    }

    public static void addAction(Scanner add){
        System.out.println("Entre Le Nom d'Action : ");
        String nomAction = add.nextLine();
        System.out.println("Entre le Prix Unitaire d'Action : ");
        float prixUnit = add.nextFloat();
        String type = "Action";
        actions.add(new Action(nomAction,prixUnit,type));
    }
    public static void deleteAction(Scanner add){
        System.out.println("Enter le nom d'Action a Supprimer : ");
        String inputNom = add.nextLine();
        actions.removeIf(a -> a.getNom().equals(inputNom));
    }

    public static void addCrypto(Scanner add){
        System.out.println("Entre le Nom de Crypto Monnaie : ");
        String nomCrypto = add.nextLine();
        System.out.println("Entre le Prix Unitaire du Crypto Monnaie : ");
        float prixUnitt = add.nextFloat();
        String type = "Crypto";
        Cryptos.add(new Crypto(nomCrypto,prixUnitt,type));
    }
    public static void deleteCrypro(Scanner add){
        System.out.println("Entre le Nom de Crypto a Supprimer : ");
        String inputNom = add.nextLine();
        Cryptos.removeIf(c -> c.getNom().equals(inputNom));
    }
    public static void displayCryptos(){
        for (Crypto c : Cryptos){
            System.out.println("Nom du Crypto : "+c.getNom()+" et le prix Unitaire : "+c.getPrixUnitaire());
        }
    }
    public static void displayCrypto(String nom){
        for (Crypto c : Cryptos){
            if (nom == c.getNom()){
                System.out.println("Nom du Crypto : "+c.getNom()
                        +" et le prix Unitaire : "+c.getPrixUnitaire());
            }
        }
    }
    public static void displayActions(){
        for (Action a : actions){
            System.out.println("Nom du Crypto : "+a.getNom()+" et le prix Unitaire : "+a.getPrixUnitaire());
        }
    }
    public static Crypto findCrypto(String nom){
        Crypto f = null;
        for (Crypto c : Cryptos){
            if (c.getNom() == nom){
                f = c;
            }
        }
        return f;
    }
    public static Action findAction(String nom){
        Action f =null;
        for (Action a : actions){
            if (a.getNom() == nom){
                f = a;
            }
        }
        return f;
    }


}
