
public class Portfolio<T> {
    private Trader trader;
    private float balance;

    public Portfolio(Trader trader, float balance) {
        this.trader = trader;
        this.balance = balance;
    }

    public float getBalance() {
        return balance;
    }

    public void setBalance(float balance) {
        this.balance = balance;
    }

    public Trader getTrader() {
        return trader;
    }

    public void setTrader(Trader trader) {
        this.trader = trader;
    }


}
