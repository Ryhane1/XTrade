
public class Trader extends Person {
    private Portfolio portfolio;
    private int id ;
    private float soldInitial;


    public Trader(String nom, String mail, int id, float soldInitial) {
        super(nom, mail);
        this.id = id;
        this.soldInitial = soldInitial;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getSoldInitial() {
        return soldInitial;}

    public void setSoldInitial(float soldInitial) {
        this.soldInitial = soldInitial;}
}
