public class Batiment {

    String nom, adresse;

    public Batiment (String unNom, String uneAdresse)  {
        nom = unNom;
        adresse = uneAdresse;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }
    
}
