import java.time.LocalDate;
import java.util.ArrayList;

public class Capteur {

    int id;
    String nom, lieu;
    ArrayList<Listener> liste_ecouteurs;

    public Capteur (int unId, String unNom, String unLieu) {
        id = unId;
        nom = unNom;
        lieu = unLieu;
        liste_ecouteurs = new ArrayList<Listener>();
    }

    public void addListener(Listener unEcouteur) {
        liste_ecouteurs.add(unEcouteur);
    }

    public void removeListener (Listener unEcouteur) {
        for (int i = 0; i < liste_ecouteurs.size(); i++) {
            if (liste_ecouteurs.get(i) == unEcouteur) {
                liste_ecouteurs.remove(i);
            }
        }
    }

//Setters 

    public void setId (int newId) {
        id = newId;
    }

    public void setnom (String newNom) {
        nom = newNom;
    }

    public void setLieu(String newLieu) {
        lieu = newLieu;
    }

//Getters

    public int getId() {
        return id;
    }

    public String getNom () {
        return nom;
    }

    public String getLieu() {
        return lieu;
    }

}