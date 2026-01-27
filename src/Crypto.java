import java.util.ArrayList;
import java.util.Scanner;

public class Crypto extends Asset{
      private String nomCrypto;
      private float prixUnit;

    public Crypto(String nomCrypto, float prixUnit) {
        this.nomCrypto = nomCrypto;
        this.prixUnit = prixUnit;
    }

    public String getNomCrypto() {
        return nomCrypto;
    }

    public void setNomCrypto(String nomCrypto) {
        this.nomCrypto = nomCrypto;
    }

    public float getPrixUnit() {
        return prixUnit;
    }

    public void setPrixUnit(float prixUnit) {
        this.prixUnit = prixUnit;
    }

}
