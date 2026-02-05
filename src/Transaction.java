import java.time.LocalDate;

public class Transaction {
    private String type ;
    private LocalDate date ;
    private Trader trader;
    private Actif actif ;
    private float valeur ;

    public Transaction(String type, LocalDate date, Trader trader, Actif actif, float valeur) {
        this.type = type;
        this.date = date;
        this.trader = trader;
        this.actif = actif;
        this.valeur = valeur;
    }

    public float getValeur() {
        return valeur;
    }

    public void setValeur(float valeur) {
        this.valeur = valeur;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Trader getTrader() {
        return trader;
    }

    public void setTrader(Trader trader) {
        this.trader = trader;
    }

    public Actif getActif() {
        return actif;
    }

    public void setActif(Actif actif) {
        this.actif = actif;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "type='" + type + '\'' +
                ", date : " + date +
                ", actif : " + actif.getAsset().getNom() +
                ", valeur : " + valeur +
                ", Nom du trader : " + trader.getNom() +
                " , Id du Trader : "+trader.getId()+'}';
    }
}
