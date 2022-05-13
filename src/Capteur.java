import java.util.ArrayList;

public class Capteur {

    Integer id;
    String nom;
    Batiment lieu;
    ArrayList<ListenerA> liste_ecouteurs_typeA;
    ArrayList<ListenerB> liste_ecouteurs_typeB;

    public Capteur (Integer unId, String unNom, Batiment unLieu) {
        id = unId;
        nom = unNom;
        lieu = unLieu;
        liste_ecouteurs_typeA = new ArrayList<ListenerA>();
        liste_ecouteurs_typeB = new ArrayList<ListenerB>();
    }

    public void addListenerA(ListenerA unEcouteur) {
        liste_ecouteurs_typeA.add(unEcouteur);
    }

    public void removeListenerA (ListenerA unEcouteur) {
        for (int i = 0; i < liste_ecouteurs_typeA.size(); i++) {
            if (liste_ecouteurs_typeA.get(i) == unEcouteur) {
                liste_ecouteurs_typeA.remove(i);
            }
        }
    }
    
    public void addListenerB(ListenerB unEcouteur) {
        liste_ecouteurs_typeB.add(unEcouteur);
    }

    public void removeListenerB (ListenerB unEcouteur) {
        for (int i = 0; i < liste_ecouteurs_typeB.size(); i++) {
            if (liste_ecouteurs_typeB.get(i) == unEcouteur) {
                liste_ecouteurs_typeB.remove(i);
            }
        }
    }

//Setters 

    public void setId (Integer newId) {
        id = newId;
    }

    public void setnom (String newNom) {
        nom = newNom;
    }

    public void setLieu(Batiment newLieu) {
        lieu = newLieu;
    }

//Getters

    public Integer getId() {
        return id;
    }

    public String getNom () {
        return nom;
    }

    public Batiment getLieu() {
        return lieu;
    }

}