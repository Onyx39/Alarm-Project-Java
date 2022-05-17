package test;
import alarm.EmissionGaz;
import alarm.Incendie;
import alarm.ListenerA;


public class MoniteurA implements ListenerA{
    public String nom;

    public MoniteurA (String unNom) {
        nom = unNom;
    }

    @Override
    public void onEvent(EmissionGaz e) {
        String res = "Moniteur A : Alerte au gaz (" + e.getType() + ") de niveau " + e.getImportance().toString();
        res += " au bâtiment " + e.getLieu().getNom() + " le " + e.getDate();
        System.out.println(res);

    }

    @Override
    public void onEvent (Incendie e) {
        String res = "Moniteur A : Alerte incendie de niveau " + e.getImportance().toString();
        res += " au bâtiment " + e.getLieu().getNom() + " le " + e.getDate();
        System.out.println(res);
        }
    

        

//Setters 

    public void setNom (String newNom) {
        nom = newNom;
    }

//Getters

    public String getNom () {
        return nom;
    }
}