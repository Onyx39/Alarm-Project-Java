//import java.time.*;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        
        //EmissionGaz e = new EmissionGaz(LocalDate.of(2022, 5,6), "Polytech", 1, "CO2");
        //System.out.println(e.getClass());

        MoniteurA monoA = new MoniteurA("monoA");
        MoniteurB monoB = new MoniteurB("monoB");

        ArrayList<Listener> liste_mono = new ArrayList<Listener>();
        liste_mono.add(monoA);
        liste_mono.add(monoB);

        CaptGaz cg = new CaptGaz(1, "Bidule", "Polytech");
        CaptIncendie ci = new CaptIncendie(1, "Alarme incendie", "Mairie");
        CaptRadiation cr = new CaptRadiation(1, "detecteur radiation", "Mosanto");

        ArrayList<CaptIncendie> liste_capteur_feu = new ArrayList<CaptIncendie>();
        ArrayList<CaptGaz> liste_capteur_gaz = new ArrayList<CaptGaz>();
        ArrayList<CaptRadiation> liste_capteur_radiation = new ArrayList<CaptRadiation>();
        liste_capteur_gaz.add(cg);
        liste_capteur_feu.add(ci);
        liste_capteur_radiation.add(cr);


        //cg.createEvent(LocalDate.of(2022, 5, 6), "Polytech", 1, "CO2");
        //ci.createEvent(LocalDate.of(2022, 5, 6), "Mairie", 1);
        //cr.createEvent(LocalDate.of(2022, 5, 6), "Polytech", 1, 50);


        //IHM MyIHM = new IHM(liste_mono, liste_capteur_feu, liste_capteur_gaz, liste_capteur_radiation);
        IHM2 myIHM = new IHM2 (liste_mono, liste_capteur_feu, liste_capteur_gaz, liste_capteur_radiation);
    }

}

//UML LAB pour faire des uml en ligne. Gratuits pour etudiants.