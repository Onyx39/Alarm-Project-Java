package test;
import alarm.EmissionGaz;
import alarm.EmissionRadiation;
import alarm.ListenerB;

public class MoniteurB implements ListenerB {

    String nom;

    public MoniteurB (String unNom) {
        nom = unNom;
    }

    @Override
    public void onEvent(EmissionGaz e) {
        String res = "Moniteur B : Alerte au gaz (" + e.getType() + ") de niveau " + e.getImportance().toString();
        res += " au bâtiment " + e.getLieu().getNom() + " le " + e.getDate();
        System.out.println(res);
        }
    
    @Override
    public void onEvent(EmissionRadiation e) {
        String res = "Moniteur B : Alerte aux radiations (" + e.niveau_radiation.toString() + ") de niveau " + e.getImportance().toString();
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