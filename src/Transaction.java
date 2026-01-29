import java.time.LocalDateTime;

public class Transaction {
    private LocalDateTime date ;
    private Portfolio portfolio;

    public Transaction(LocalDateTime date, Portfolio portfolio) {
        this.date = date;
        this.portfolio = portfolio;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public Portfolio getPortfolio() {
        return portfolio;
    }

    public void setPortfolio(Portfolio portfolio) {
        this.portfolio = portfolio;
    }
}
