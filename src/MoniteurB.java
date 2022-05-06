class MoniteurB implements Listener {

    String nom;

    public MoniteurB (String unNom) {
        nom = unNom;
    }

    @Override
    public void onEvent(AnomalieEvent e) {
        if (e.getClass().getSimpleName() == "EmissionGaz") {
            System.out.println("Moniteur B : Alerte gaz");
        }
        else if (e.getClass().getSimpleName() == "EmissionRadiation") {
            System.out.println("Moniteur B: Alerte radiation");
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