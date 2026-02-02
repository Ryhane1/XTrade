import java.time.LocalDateTime;

public class Transaction {
    private String type ;
    private LocalDateTime date ;
    private Trader trader;
    private Actif actif ;
    private float valeur ;

    public Transaction(String type, LocalDateTime date, Trader trader, Actif actif, float valeur) {
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

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
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


}
