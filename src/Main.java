import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner add = new Scanner(System.in);
        int choix ;
        System.out.println("");
        System.out.println("2. Admine ");
        System.out.println("1. Trader ");
        choix = add.nextInt();

    }
    public static void menuPrincipal(){
        Scanner add = new Scanner(System.in);
        int choix ;
        System.out.println("");
        System.out.println("2. Admine ");
        System.out.println("1. Trader ");
        choix = add.nextInt();
        if (choix == 1){

        } else if (choix == 2) {

        }else {
            System.out.println("Choix Invalid !!");
        }
    }
    public static int menuAdmin(){
        Scanner add = new Scanner(System.in);
        int choix ;
        System.out.println("");
        System.out.println("2. Ajouter Person ");
        System.out.println("1. Ajouter Trader ");
        System.out.println("1. Ajouter Portfolio ");
        System.out.println("1. Ajouter Action ");
        System.out.println("1. Ajouter Crypto ");
        System.out.println("1. Supprimer Portfolio ");
        System.out.println("1. Supprimer Trader ");
        return choix = add.nextInt();

    }
    public static int menuTrader(){
        Scanner add = new Scanner(System.in);
        int choix ;
        System.out.println("");
        System.out.println("2. Acheter Action ");
        System.out.println("1. Acheter Crypto ");
        System.out.println("1. Consulter Portfolio ");
        System.out.println("1. Consulter Historique Transaction ");
        System.out.println("1.  ");
        System.out.println("1. Supprimer Portfolio ");
        System.out.println("1. Supprimer Trader ");
        return choix = add.nextInt();
    }

}