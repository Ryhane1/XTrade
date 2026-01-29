import java.util.ArrayList;
import java.util.List;

public class Portfolio {
        private Trader trader;
        private float balance;
        private ArrayList<Postion> postions;

    public Portfolio(Trader trader, float balance, ArrayList<Postion> postions) {
        this.trader = trader;
        this.balance = balance;
        this.postions =  new ArrayList<>();
    }

    public Portfolio() {
        this.postions =  new ArrayList<>();

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
            for (Postion p : postions){
            if (asset == p.getAsset() ){
                float quantite = budget / asset.getPrixUnitaire();
                p.setQuantite(p.getQuantite()+quantite);
                return;
            }}
            float quantite = budget / asset.getPrixUnitaire();
            postions.add(new Postion(asset, quantite, budget));
            balance -= budget;
            System.out.println("Achat réussi !!");
        }

        public ArrayList<Postion> getPostions() {
            return postions;
        }

        public float getBalance() {
            return balance;
        }

    public void setPostions( Postion position) {
        this.postions.add(position);
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

    public void setPosts(ArrayList<Postion> positions) {
        this.postions = positions;
    }




//    private Trader trader;
//    private float balance;
//    private List<Crypto> Cryptoo ;
//    private ArrayList<Action> Actionn;
//    private float quantite;
//
//    public Portfolio(Trader trader, float balance,  List<Crypto> cryptoo, ArrayList<Action> actionn, float quantite) {
//        this.trader = trader;
//        this.balance = balance;
//        Cryptoo = cryptoo;
//        Actionn = actionn;
//        this.quantite = quantite;
//    }

//    public Portfolio(Trader trader, float balance, Asset asset, ArrayList<Crypto> cryptoo, ArrayList<Action> actionn, float quantite) {
//        this.trader = trader;
//        this.balance = balance;
//        this.asset = asset;
//        Cryptoo = cryptoo;
//        Actionn = actionn;
//        this.quantite = quantite;
//    }

//    public Portfolio(Trader trader, float balance, Asset asset, float quantite) {
//        this.trader = trader;
//        this.balance = balance;
//        this.asset = asset;
//        this.quantite = quantite;
//    }
//
//    public Portfolio(Trader trader, float balance, Asset asset) {
//        this.trader = trader;
//        this.balance = balance;
//        this.asset = asset;
//    }
//




//
//    public Portfolio(Trader trader, float balance) {
//        this.trader = trader;
//        this.balance = balance;
//    }
//
//    public float getBalance() {
//        return balance;
//    }
//
//    public void setBalance(float balance) {
//        this.balance = balance;
//    }
//
//    public Trader getTrader() {
//        return trader;
//    }
//
//    public void setTrader(Trader trader) {
//        this.trader = trader;
//    }
//
////    public Asset getAsset() {
////        return asset;
////    }
////
////    public void setAsset(Asset asset) {
////        this.asset = asset;
////    }
//
//    public float getQuantite() {
//        return quantite;
//    }
//
//    public void setQuantite(float quantite) {
//        this.quantite = quantite;
//    }
//
//    public List<Crypto> getCryptoo() {
//        return Cryptoo;
//    }
//
//    public void setCryptoo(Crypto crypto) {
//        this.Cryptoo.add(crypto);
//    }
//
//    public ArrayList<Action> getActionn() {
//        return Actionn;
//    }
//
//    public void setActionn(Action action) {
//        this.Actionn.add(action);
//    }
}
