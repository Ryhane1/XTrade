import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Trader extends Person {
    private int id ;
    static ArrayList<Person> traders = new ArrayList<>();
    Scanner add = new Scanner(System.in);
    public Trader(String nom, String mail, int id) {
        super(nom, mail);
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public static void addTrader(Scanner add){
        System.out.println("Entre le nom : ");
        String nom = add.nextLine();
        System.out.println("Entre Mail : ");
        String mail = add.nextLine();
        int id = new Random().nextInt(100000,1000000);
        System.out.println("Id Générer !!");
        traders.add(new Trader(nom,mail,id));

    }

}
