public class MoniteurA implements Listener{
    String nom;

    public MoniteurA (String unNom) {
        nom = unNom;
    }

    @Override
    public void onEvent(AnomalieEvent e) {
        if (e.getClass().getSimpleName() == "EmissionGaz") {
            System.out.println("Moniteur A : Alerte gaz");
        }
        else if (e.getClass().getSimpleName() == "Incendie") {
            System.out.println("Moniteur A : Alerte incendie");
        }

        
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