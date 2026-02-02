import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;

abstract class Asset {
    private String nom ;
    private float prixUnitaire ;
    private String type ;
    static ArrayList<Crypto> Cryptos = new ArrayList<>();
    static ArrayList<Action> actions = new ArrayList<>();

    public Asset(String nom, float prixUnitaire, String type) {
        this.nom = nom;
        this.prixUnitaire = prixUnitaire;
        this.type = type;
    }

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

    public static void addAction(Scanner add){
        System.out.println("Entre Le Nom d'Action : ");
        add.nextLine();
        String nomAction = add.nextLine();
        System.out.println("Entre le Prix Unitaire d'Action : ");
        float prixUnit = add.nextFloat();
        String type = "Action";
        actions.add(new Action(nomAction,prixUnit,type));
        System.out.println("L'Action est Creer Avec Succes !! ");

    }
    public static void deleteAction(Scanner add){
        System.out.println("Enter le nom d'Action a Supprimer : ");
        add.nextLine();
        String inputNom = add.nextLine();
        actions.removeIf(a -> a.getNom().equals(inputNom));
    }

    public static void addCrypto(Scanner add){
        System.out.println("Entre le Nom de Crypto Monnaie : ");
        add.nextLine();
        String nomCrypto = add.nextLine();
        System.out.println("Entre le Prix Unitaire du Crypto Monnaie : ");
        float prixUnitt = add.nextFloat();
        String type = "Crypto";
        Cryptos.add(new Crypto(nomCrypto,prixUnitt,type));
        System.out.println("Le Crypto Monnaie est Creer Avec Succes !! ");
    }
    public static void deleteCrypro(Scanner add){
        System.out.println("Entre le Nom de Crypto a Supprimer : ");
        add.nextLine();
        String inputNom = add.nextLine();
        Cryptos.removeIf(c -> c.getNom().equals(inputNom));
    }
    public static void displayCryptos(){
        for (Crypto c : Cryptos){
            System.out.println("Nom du Crypto : "+c.getNom()+" , le prix Unitaire : "+c.getPrixUnitaire());
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
            System.out.println("Nom d'Action : "+a.getNom()+" , le prix Unitaire : "+a.getPrixUnitaire());
        }
    }
    public static Crypto findCrypto(String nom){
        Crypto f = null;
        for (Crypto c : Cryptos){
            if (c.getNom().equals(nom)){
                f = c;
            }
        }
        return f;
    }
    public static Action findAction(String nom) {
        for (Action a : actions) {
            if (a.getNom().equals(nom)) {
                return a;
            }
        }
        return null;
    }


}
