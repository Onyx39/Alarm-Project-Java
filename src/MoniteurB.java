public class MoniteurB implements ListenerB {

    String nom;

    public MoniteurB (String unNom) {
        nom = unNom;
    }

    @Override
    public void onEvent(EmissionGaz e) {
        String res = "Moniteur B : Alerte au gaz (" + e.type + ") de niveau " + e.importance.toString();
        res += " au bâtiment " + e.lieu + " le " + e.date;
        System.out.println(res);
        }
    
    @Override
    public void onEvent(EmissionRadiation e) {
        String res = "Moniteur B : Alerte au radiation (" + e.niveau_radiation.toString() + ") de niveau " + e.importance.toString();
        res += " au bâtiment " + e.lieu + " le " + e.date;
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