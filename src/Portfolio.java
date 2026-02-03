import java.util.ArrayList;

public class Portfolio {
        private Trader trader;
        private float balance;
        private ArrayList<Actif> Actifs = new ArrayList<>();

    public Portfolio(Trader trader, float balance, ArrayList<Actif> Actifs) {
        this.trader = trader;
        this.balance = balance;
        this.Actifs =  new ArrayList<>();
    }

    public Portfolio(Trader trader, float balance) {
            this.trader = trader;
            this.balance = balance;
        }

        public void acheterAsset(Asset asset, float budget) {
            if (budget > balance) {
                System.out.println("Solde insuffisant !");
                return;
            }
            for (Actif r : Actifs){
                System.out.println("loop");
            if (asset == r.getAsset() ){
                System.out.println("if alt");
                float quantite = budget / asset.getPrixUnitaire();
                r.setQuantite(r.getQuantite()+quantite);
                balance -= budget;
                System.out.println("Achat réussi !!");
            }else {
                float quantite = budget / asset.getPrixUnitaire();
                Actifs.add(new Actif(asset, quantite, budget));
                System.out.println("else");
                balance -= budget;
                System.out.println("Achat réussi !!");
            }
            }
//            float quantite = budget / asset.getPrixUnitaire();
//            Actifs.add(new Actif(asset, quantite, budget));
//            balance -= budget;
//            System.out.println("Achat réussi !!");
        }

        public ArrayList<Actif> getActifs() {
            return Actifs;
        }

        public float getBalance() {
            return balance;
        }

    public void setActifs( Actif actif) {
        this.Actifs.add(actif);
    }

    public Trader getTrader() {
        return trader;
    }

    public void setTrader(Trader trader) {
        this.trader = trader;
    }

    public void setBalance(float balance) {
        this.balance = balance;
    }

    public void setPosts(ArrayList<Actif> actifs) {
        this.Actifs = actifs;
    }
}
