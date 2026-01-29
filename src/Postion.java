public class Postion {

    private Asset asset;
    private float quantite;
    private float valeurAchat;

    public Postion(Asset asset, float quantite, float valeurAchat) {
        this.asset = asset;
        this.quantite = quantite;
        this.valeurAchat = valeurAchat;
    }

    public Asset getAsset() {
        return asset;
    }

    public void setAsset(Asset asset) {
        this.asset = asset;
    }

    public float getQuantite() {
        return quantite;
    }

    public void setQuantite(float quantite) {
        this.quantite = quantite;
    }

    public float getValeurAchat() {
        return valeurAchat;
    }

    public void setValeurAchat(float valeurAchat) {
        this.valeurAchat = valeurAchat;
    }
}

