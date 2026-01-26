public class Trader extends Person {
    private int id ;

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
}
