public class MoniteurA implements ListenerA{
    String nom;

    public MoniteurA (String unNom) {
        nom = unNom;
    }

    @Override
    public void onEvent(EmissionGaz e) {
        String res = "Moniteur A : Alerte au gaz (" + e.type + ") de niveau " + e.importance.toString();
        res += " au bâtiment" + e.lieu + "le " + e.date;
        System.out.println(res);

    }

    @Override
    public void onEvent (Incendie e) {
        String res = "Moniteur A : Alerte incendie de niveau " + e.importance.toString();
        res += " au bâtiment" + e.lieu + "le " + e.date;
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